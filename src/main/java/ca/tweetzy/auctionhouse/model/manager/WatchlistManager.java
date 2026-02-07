/*
 * Auction House
 * Copyright 2018-2022 Kiran Hart
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ca.tweetzy.auctionhouse.model.manager;

import ca.tweetzy.auctionhouse.AuctionHouse;
import ca.tweetzy.auctionhouse.auction.AuctionedItem;
import ca.tweetzy.flight.database.Callback;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Manages player watchlists: which listing IDs each player is watching.
 * Entries are persisted in the watchlist table and cached in memory.
 */
public final class WatchlistManager {

	private final Map<UUID, Set<UUID>> playerToWatchedListingIds = new ConcurrentHashMap<>();

	public void load() {
		AuctionHouse.getDataManager().getWatchlistEntries((error, map) -> {
			if (error != null) {
				AuctionHouse.getInstance().getLogger().warning("Failed to load watchlist: " + error.getMessage());
				return;
			}
			if (map != null) {
				playerToWatchedListingIds.clear();
				map.forEach((player, set) -> playerToWatchedListingIds.put(player, ConcurrentHashMap.newKeySet()));
				map.forEach((player, set) -> playerToWatchedListingIds.get(player).addAll(set));
			}
		});
	}

	public boolean isWatching(@NonNull UUID playerUuid, @NonNull UUID listingId) {
		Set<UUID> set = playerToWatchedListingIds.get(playerUuid);
		return set != null && set.contains(listingId);
	}

	public Set<UUID> getWatchedListingIds(@NonNull UUID playerUuid) {
		Set<UUID> set = playerToWatchedListingIds.get(playerUuid);
		return set == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet<>(set));
	}

	/**
	 * Returns watched listings that still exist and are not expired/in garbage.
	 */
	public List<AuctionedItem> getWatchedListings(@NonNull UUID playerUuid) {
		Set<UUID> ids = getWatchedListingIds(playerUuid);
		if (ids.isEmpty()) return Collections.emptyList();
		List<AuctionedItem> out = new ArrayList<>();
		for (UUID id : ids) {
			AuctionedItem item = AuctionHouse.getAuctionItemManager().getItem(id);
			if (item != null && !item.isExpired() && !AuctionHouse.getAuctionItemManager().getGarbageBin().containsKey(id)) {
				out.add(item);
			}
		}
		return out;
	}

	public int getWatchlistCount(@NonNull UUID playerUuid) {
		Set<UUID> set = playerToWatchedListingIds.get(playerUuid);
		return set == null ? 0 : set.size();
	}

	public void add(@NonNull UUID playerUuid, @NonNull UUID listingId, @NonNull Callback<Boolean> callback) {
		AuctionHouse.getDataManager().addWatchlistEntry(playerUuid, listingId, (error, success) -> {
			if (error != null) {
				if (callback != null) callback.accept(error, false);
				return;
			}
			if (Boolean.TRUE.equals(success)) {
				playerToWatchedListingIds.computeIfAbsent(playerUuid, k -> ConcurrentHashMap.newKeySet()).add(listingId);
			}
			if (callback != null) callback.accept(null, Boolean.TRUE.equals(success));
		});
	}

	public void remove(@NonNull UUID playerUuid, @NonNull UUID listingId, @NonNull Callback<Boolean> callback) {
		AuctionHouse.getDataManager().removeWatchlistEntry(playerUuid, listingId, (error, success) -> {
			if (error != null) {
				if (callback != null) callback.accept(error, false);
				return;
			}
			if (Boolean.TRUE.equals(success)) {
				Set<UUID> set = playerToWatchedListingIds.get(playerUuid);
				if (set != null) {
					set.remove(listingId);
					if (set.isEmpty()) playerToWatchedListingIds.remove(playerUuid);
				}
			}
			if (callback != null) callback.accept(null, Boolean.TRUE.equals(success));
		});
	}

	/**
	 * Remove a listing from all players' watchlists (e.g. when listing ends).
	 */
	public void removeListing(@NonNull UUID listingId) {
		AuctionHouse.getDataManager().removeWatchlistEntriesForListing(listingId, (error, ignored) -> {
			if (error != null) {
				AuctionHouse.getInstance().getLogger().warning("Failed to remove watchlist entries for listing " + listingId + ": " + error.getMessage());
				return;
			}
			playerToWatchedListingIds.values().forEach(set -> set.remove(listingId));
			playerToWatchedListingIds.entrySet().removeIf(e -> e.getValue().isEmpty());
		});
	}
}
