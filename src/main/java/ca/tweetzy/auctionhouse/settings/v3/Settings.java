/*
 * Auction House
 * Copyright 2023 Kiran Hart
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

package ca.tweetzy.auctionhouse.settings.v3;

import ca.tweetzy.auctionhouse.AuctionHouse;
import ca.tweetzy.auctionhouse.api.AuctionUsageMode;
import ca.tweetzy.flight.comp.enums.CompMaterial;
import ca.tweetzy.flight.config.ConfigEntry;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Settings extends SettingTemp {


	public static ConfigEntry PREFIX = create("prefix", "&8[&eAuctionHouse&8]", "The prefix for the plugin");
	public static ConfigEntry LANGUAGE = create("language", "en_us", "The primary language of the plugin");
	public static ConfigEntry LANG = create("lang", "en_US", "Default language file");
	public static ConfigEntry HIDE_THANKYOU = create("hide thank you", false, "Hides the purchase thank you message in the console.");
	public static ConfigEntry UPDATE_CHECKER = create("update checker", true, "If true, auction house will check for updates periodically");
	public static ConfigEntry ALLOW_USAGE_OF_IN_GAME_EDITOR = create("Allow Usage Of This Menu In Game", true, "Once you set this to true, you will no longer be able to access it unless you enable it within the actual config.yml");

	/*
	==============================================================
					Database Options (legacy key names for migration)
	==============================================================
	 */
	public static ConfigEntry DATABASE_USE = create("database.use database", false, "Should the plugin use a database to store shop data?");
	public static ConfigEntry DATABASE_TABLE_PREFIX = create("database.table prefix", "auctionhouse_", "What prefix should be used for table names");
	public static ConfigEntry DATABASE_HOST = create("database.host", "localhost", "What is the connection url/host");
	public static ConfigEntry DATABASE_PORT = create("database.port", 3306, "What is the port to database (default is 3306)");
	public static ConfigEntry DATABASE_NAME = create("database.name", "plugin_dev", "What is the name of the database?");
	public static ConfigEntry DATABASE_USERNAME = create("database.username", "root", "What is the name of the user connecting?");
	public static ConfigEntry DATABASE_PASSWORD = create("database.password", "Password1.", "What is the password to the user connecting?");
	public static ConfigEntry DATABASE_CUSTOM_PARAMS = create("database.custom parameters", "?useUnicode=yes&characterEncoding=UTF-8&useServerPrepStmts=false&rewriteBatchedStatements=true&useSSL=true", "Leave this alone if you don't know what you're doing. Set to 'None' to use no custom connection params");

	/*
	==============================================================
						  Economy Settings
	==============================================================
	 */
	public static final ConfigEntry CURRENCY_ALLOW_PICK = create("economy.currency.allow pick", true, "If true, players will be able to select which currency they want to use.");
	public static final ConfigEntry CURRENCY_DEFAULT_SELECTED = create("economy.currency.default selection", "Vault/Vault", "The default currency selection, PluginName/CurrencyName -> Ex. Vault/Vault or UltraEconomy/Gems etc");
	public static final ConfigEntry CURRENCY_VAULT_SYMBOL = create("economy.currency.vault symbol", "$", "When using default/vault currency, what symbol should be used.");
	public static final ConfigEntry CURRENCY_VAULT_SYMBOL_OVERRIDES = create("economy.currency.vault symbol overrides", false, "If true, the vault symbol will override the symbol provided by the country/language combination");
	public static final ConfigEntry CURRENCY_BLACKLISTED = create("economy.currency.black listed", Collections.singletonList("UltraEconomy:Test"), "A list of owning plugins & the currency to be blacklisted. Ex. UltraEconomy:Test");
	public static final ConfigEntry CURRENCY_FORMAT_LANGUAGE = create("economy.currency.format.language", "en", "An ISO 639 alpha-2 or alpha-3 language code.");
	public static final ConfigEntry CURRENCY_FORMAT_COUNTRY = create("economy.currency.format.country", "US", "An ISO 3166 alpha-2 country code or a UN M.49 numeric-3 area code.");
	public static final ConfigEntry CURRENCY_ABBREVIATE_NUMBERS = create("economy.currency.abbreviate numbers", false, "Should numbers be abbreviated?. Example: 123,000 will become 123k ");
	public static final ConfigEntry CURRENCY_HIDE_VAULT_SYMBOL = create("economy.currency.hide vault symbol", false, "Should the specified vault symbol be hidden?");
	public static final ConfigEntry CURRENCY_STRIP_ENDING_ZEROES = create("economy.currency.strip ending zeroes", false, "If the number ends with 00, should it be stripped. EX 123.00 becomes 123");
	public static final ConfigEntry CURRENCY_TIGHT_CURRENCY_SYMBOL = create("economy.currency.tight currency symbol", false, "If true, the space between the currency symbol and number will be removed");
	public static final ConfigEntry CURRENCY_USE_GROUPING = create("economy.currency.use grouping", true, "If false, number grouping will be disabled. Ex. 123,456.78 becomes 123456.78");
	public static final ConfigEntry CURRENCY_ALLOW_CUSTOM = create("economy.currency.allow custom item", true, "If true, players will be able to provide a custom item as the currency");
	public static final ConfigEntry CURRENCY_LIMIT_TO_PERMISSION = create("economy.currency.limit to permission", false, "If true, currencies will be limited by permission. Example auctionhouse.currency.ultraeconomy_gems will allow usage of the gems currency from ultra economy");
	public static final ConfigEntry CURRENCY_REMOVE_SPACE_FROM_CUSTOM = create("economy.currency.hide space between in currency", false, "If true, if the currency has a custom display name is will go from 123 currency to 123currency/symbol");

	/*
	==============================================================
				  Time aliases & Command flags
	==============================================================
	 */
	public static final ConfigEntry TIME_ALIAS_YEAR = create("time aliases.year", Arrays.asList("y", "year", "years"), "Time aliases for year, Must be in lowercase.");
	public static final ConfigEntry TIME_ALIAS_MONTH = create("time aliases.month", Arrays.asList("mo", "month", "months"), "Time aliases for month, Must be in lowercase.");
	public static final ConfigEntry TIME_ALIAS_WEEK = create("time aliases.week", Arrays.asList("w", "week", "weeks"), "Time aliases for week, Must be in lowercase.");
	public static final ConfigEntry TIME_ALIAS_DAY = create("time aliases.day", Arrays.asList("d", "day", "days"), "Time aliases for day, Must be in lowercase.");
	public static final ConfigEntry TIME_ALIAS_HOUR = create("time aliases.hour", Arrays.asList("h", "hour", "hours"), "Time aliases for hour, Must be in lowercase.");
	public static final ConfigEntry TIME_ALIAS_MINUTE = create("time aliases.minute", Arrays.asList("min", "minute", "minutes"), "Time aliases for minute, Must be in lowercase.");
	public static final ConfigEntry TIME_ALIAS_SECOND = create("time aliases.second", Arrays.asList("s", "second", "seconds"), "Time aliases for second, Must be in lowercase.");
	public static final ConfigEntry CMD_FLAG_ALIAS_SELL_BUNDLE = create("command flags.sell command.bundle", Arrays.asList("-b", "-bundle"), "Aliases for the bundle command flag in the sell command");
	public static final ConfigEntry CMD_FLAG_ALIAS_SELL_PARTIAL_BUY = create("command flags.sell command.partial buy", Arrays.asList("-p", "-partialbuy"), "Aliases for the partial buy command flag in the sell command");
	public static final ConfigEntry CMD_FLAG_ALIAS_SELL_STACK_PRICE = create("command flags.sell command.stack price", Arrays.asList("-s", "-stack"), "Aliases for the stack price flag in the sell command");
	public static final ConfigEntry CMD_FLAG_ALIAS_SELL_INFINITE = create("command flags.sell command.infinite", Arrays.asList("-i", "-infinite"), "Aliases for the infinite flag in the sell command");
	public static final ConfigEntry CMD_FLAG_ALIAS_SELL_SERVER = create("command flags.sell command.server", Arrays.asList("-server"), "Aliases for the server flag in the sell command");
	public static final ConfigEntry CMD_FLAG_ALIAS_SELL_TIME = create("command flags.sell command.time", Arrays.asList("-t"), "Aliases for the time flag in the sell command");
	public static final ConfigEntry CMD_FLAG_ALIAS_SELL_SINGLE = create("command flags.sell command.single", Arrays.asList("-one"), "Aliases for the single item flag in the sell command");

	/*
	==============================================================
						  COMMAND ALIASES
	==============================================================
	 */
	public static final ConfigEntry CMD_ALIAS_MAIN = create("command aliases.main", Arrays.asList("ah", "auctions", "auctionhouses", "ahgui", "auctiongui"), "Command aliases for the main command");
	public static final ConfigEntry CMD_ALIAS_SUB_ACTIVE = create("command aliases.subcommands.active", Collections.singletonList("active"), "Command aliases for the active command");
	public static final ConfigEntry CMD_ALIAS_SUB_CART = create("command aliases.subcommands.cart", Collections.singletonList("cart"), "Command aliases for the cart command");
	public static final ConfigEntry CMD_ALIAS_SUB_ADMIN = create("command aliases.subcommands.admin", Collections.singletonList("admin"), "Command aliases for the admin command");
	public static final ConfigEntry CMD_ALIAS_SUB_BAN = create("command aliases.subcommands.ban", Collections.singletonList("ban"), "Command aliases for the ban command");
	public static final ConfigEntry CMD_ALIAS_SUB_BIDS = create("command aliases.subcommands.bids", Collections.singletonList("bids"), "Command aliases for the bids command");
	public static final ConfigEntry CMD_ALIAS_SUB_CONFIRM = create("command aliases.subcommands.confirm", Collections.singletonList("confirm"), "Command aliases for the confirm command");
	public static final ConfigEntry CMD_ALIAS_SUB_EXPIRED = create("command aliases.subcommands.expired", Collections.singletonList("expired"), "Command aliases for the expired command");
	public static final ConfigEntry CMD_ALIAS_SUB_FILTER = create("command aliases.subcommands.filter", Collections.singletonList("filter"), "Command aliases for the filter command");
	public static final ConfigEntry CMD_ALIAS_SUB_MARKCHEST = create("command aliases.subcommands.markchest", Collections.singletonList("markchest"), "Command aliases for the markchest command");
	public static final ConfigEntry CMD_ALIAS_SUB_PRICE_LIMIT = create("command aliases.subcommands.price limit", Collections.singletonList("pricelimit"), "Command aliases for the price limits command, formally min prices");
	public static final ConfigEntry CMD_ALIAS_SUB_PAYMENTS = create("command aliases.subcommands.payments", Collections.singletonList("payments"), "Command aliases for the payments command");
	public static final ConfigEntry CMD_ALIAS_SUB_REQUEST = create("command aliases.subcommands.request", Collections.singletonList("request"), "Command aliases for the request command");
	public static final ConfigEntry CMD_ALIAS_SUB_SEARCH = create("command aliases.subcommands.search", Collections.singletonList("search"), "Command aliases for the search command");
	public static final ConfigEntry CMD_ALIAS_SUB_SELL = create("command aliases.subcommands.sell", Collections.singletonList("sell"), "Command aliases for the sell command");
	public static final ConfigEntry CMD_ALIAS_SUB_STATS = create("command aliases.subcommands.stats", Collections.singletonList("stats"), "Command aliases for the stats command");
	public static final ConfigEntry CMD_ALIAS_SUB_TOGGLELISTINFO = create("command aliases.subcommands.togglelistinfo", Collections.singletonList("togglelistinfo"), "Command aliases for the toggle list info command");
	public static final ConfigEntry CMD_ALIAS_SUB_TRANSACTIONS = create("command aliases.subcommands.transactions", Collections.singletonList("transactions"), "Command aliases for the transactions command");
	public static final ConfigEntry CMD_ALIAS_SUB_UNBAN = create("command aliases.subcommands.unban", Collections.singletonList("unban"), "Command aliases for the unban command");
	public static final ConfigEntry CMD_ALIAS_SUB_WATCHLIST = create("command aliases.subcommands.watchlist", Collections.singletonList("watchlist"), "Command aliases for the watchlist command");

	/*
	==============================================================
						  	LISTINGS
	==============================================================
	 */

	// ================ LISTING PRIORITY ================
	public static ConfigEntry LISTING_PRIORITY_ENABLED = create("settings.listing.listing priority.enabled", true, "If true, players will be able to pay to prioritize listings");
	public static ConfigEntry LISTING_PRIORITY_TIME_PER_BOOST = create("settings.listing.listing priority.time per boost", 60 * 30, "How many seconds should the priority last for each time they pay", "By default users will be able to stack boosts");
	public static ConfigEntry LISTING_PRIORITY_TIME_ALLOW_MULTI_BOOST = create("settings.listing.listing priority.allow multiple boost", false, "If true players can boost an item multiple times before it runs out. (ex. if they have a boost active they can extend by paying before it expires)");
	public static ConfigEntry LISTING_PRIORITY_TIME_COST_PER_BOOST = create("settings.listing.listing priority.cost per boost", 1000, "How much should it cost the player to boost their item each time");

	/*
	==============================================================
						PAYMENTS & PRICING
	==============================================================
	 */
	public static ConfigEntry MANUAL_PAYMENTS_ONLY_FOR_OFFLINE_USERS = create("settings.listing.use stored payments for offline only", false, "If true, the usage of the manual payment collection will only be done if the user is offline");
	public static ConfigEntry STORE_PAYMENTS_FOR_MANUAL_COLLECTION = create("settings.listing.store payments for manual collection", false, "If true, auction house will store the payments to be manually collected rather than automatically given to the player");
	public static ConfigEntry PLAYER_NEEDS_TOTAL_PRICE_TO_BID = create("settings.listing.bidder must have funds in account", false, "Should the player who is placing a bid on an item have the money in their account to cover the cost?");

	/*
	==============================================================
							 TAX
	==============================================================
	 */
	public static ConfigEntry TAX_ENABLED = create("settings.tax system.enabled", false, "Should auction house use it's tax system?");
	public static ConfigEntry TAX_CHARGE_LISTING_FEE = create("settings.tax system.charge listing fee", true, "Should auction house charge players to list an item?");
	public static ConfigEntry TAX_LISTING_FEE = create("settings.tax system.listing fee", 5.0, "How much should it cost to list a new item?");
	public static ConfigEntry TAX_LISTING_FEE_PERCENTAGE = create("settings.tax system.listing fee is percentage", true, "Should the listing fee be based on a percentage instead?");
	public static ConfigEntry TAX_CHARGE_SALES_TAX_TO_BUYER = create("settings.tax system.charge sale tax to buyer", false, "Should auction house tax the buyer instead of the seller?");
	public static ConfigEntry TAX_SALES_TAX_BUY_NOW_PERCENTAGE = create("settings.tax system.buy now sales tax", 15.0, "Tax % that should be charged on items that are bought immediately");
	public static ConfigEntry TAX_SALES_TAX_AUCTION_WON_PERCENTAGE = create("settings.tax system.auction won sales tax", 10.0, "Tax % that should be charged on items that are won through the auction");


	/*
	==============================================================
					Auction settings (legacy paths)
	==============================================================
	 */
	public static ConfigEntry DATE_FORMAT_LEGACY = create("auction setting.date format", "MMM dd, yyyy hh:mm aa", "You can learn more about date formats by googling SimpleDateFormat patterns");
	public static ConfigEntry TIMEZONE = create("auction setting.timezone", "America/Toronto", "Ensure this is correct as features like the access hours will use this timezone.");
	public static ConfigEntry PACKET_NAMESPACE_KEYS = create("auction setting.packet.namespaced keys", Arrays.asList("ecoitems", "ecoarmor"), "Namespaced keys of plugins using packet lore");
	public static ConfigEntry CART_SYSTEM_ENABLED = create("auction setting.cart system.enabled", false, "Should auction house allow the cart system?");
	public static ConfigEntry WATCHLIST_ENABLED = create("auction setting.watchlist.enabled", true, "Should players be able to watch/save listings and view them in a watchlist?");
	public static ConfigEntry WATCHLIST_MAX_LISTINGS = create("auction setting.watchlist.max listings per player", 30, "Maximum number of listings a player can have on their watchlist.");
	public static ConfigEntry CLICKS_ADD_TO_WATCHLIST = create("auction setting.clicks.add to watchlist", "SHIFT_RIGHT", "Click type to add/remove a listing from your watchlist. Valid: LEFT, RIGHT, SHIFT_LEFT, SHIFT_RIGHT");
	public static ConfigEntry USE_NAMES_FOR_CHECKS = create("auction setting.experimental.use names for checks", false, "Do not touch this unless you have a good reason too?");
	public static ConfigEntry TIMED_USAGE_ENABLED = create("auction setting.access hours.use access hours", false, "If true, the auction house will be only accessible during specified hours");
	public static ConfigEntry TIMED_USAGE_RANGE = create("auction setting.access hours.access hours", Collections.singletonList("00:00:00-23:59:59"), "The hours in 24hr format which the auction house can be used.");
	public static ConfigEntry EXPIRE_MENU_REQUIRES_CONFIRM = create("auction setting.collection bin needs confirm", true, "If true the player must confirm they want to remove their item from the collection bin");
	public static ConfigEntry SHOW_LISTING_ERROR_IN_CONSOLE = create("auction setting.show listing error in console", false, "If true, an exception will be thrown and shown in the console if something goes wrong during item listing");
	public static ConfigEntry ALLOW_REPEAT_BIDS = create("auction setting.allow repeated bids", true, "If true, the highest bidder on an item can keep placing bids to raise their initial bid.");
	public static ConfigEntry COLLECTION_BIN_ITEM_LIMIT = create("auction setting.collection bin item limit", 45, "How many items can be stored in the collection bin.");
	public static ConfigEntry SELL_MENU_SKIPS_TYPE_SELECTION = create("auction setting.skip type selection for sell menu", false, "If true the sell menu process will skip asking for the listing type depending on your auction settings");
	public static ConfigEntry BUNDLE_LIST_LIMIT = create("auction setting.bundle listing limit.listing limit", 45, "How many bundled listings can a player sell at any given time");
	public static ConfigEntry BUNDLE_LIST_LIMIT_INCLUDE_COLLECTION_BIN = create("auction setting.bundle listing limit.include collection bin", false, "If true, collection bin bundles will also count towards this limit");
	public static ConfigEntry DEFAULT_BIN_LISTING_TIME = create("auction setting.listings times.bin item", 86400, "The default listing time for bin items (buy only items) before they expire");
	public static ConfigEntry DEFAULT_AUCTION_LISTING_TIME = create("auction setting.listings times.auction item", 604800, "The default listing time for auction items before they expire");
	public static ConfigEntry DEFAULT_FILTER_CATEGORY = create("auction setting.default filters.auction category", "ALL", "Valid Options: ALL, FOOD, ARMOR, BLOCKS, TOOLS, WEAPONS, POTIONS, SPAWNERS, ENCHANTS, MISC, SEARCH, SELF");
	public static ConfigEntry DEFAULT_FILTER_SORT = create("auction setting.default filters.auction sort", "RECENT", "Valid Options: RECENT, OLDEST, PRICE");
	public static ConfigEntry DEFAULT_FILTER_SALE_TYPE = create("auction setting.default filters.sale type", "BOTH", "Valid Options: USED_BIDDING_SYSTEM, WITHOUT_BIDDING_SYSTEM, BOTH");
	public static ConfigEntry ENABLE_FILTER_SYSTEM = create("auction setting.use filter system", true, "If false, auction house will disable the filter button.");
	public static ConfigEntry MAX_REQUEST_AMOUNT = create("auction setting.max request amount", 64, "How much of an item should a player be able to ask for in a single request?");
	public static ConfigEntry BLOCK_REQUEST_USING_FILLED_SHULKER = create("auction setting.block requests using filled shulkers", true, "If false, players can make a request using a shulker that contains items");
	public static ConfigEntry MIN_REQUEST_PRICE = create("auction setting.pricing.min request price", 1, "The minimum price for a request");
	public static ConfigEntry MAX_REQUEST_PRICE = create("auction setting.pricing.max request price", 1000000000, "The maximum price for a request");
	public static ConfigEntry AUTO_REFRESH_AUCTION_PAGES = create("auction setting.auto refresh auction pages", true, "Should auction pages auto refresh?");
	public static ConfigEntry AUTO_REFRESH_ACTIVE_AUCTION_PAGES = create("auction setting.auto refresh active auction pages", false, "Should the /ah active pages be auto refreshed?");
	public static ConfigEntry INCREASE_TIME_ON_BID = create("auction setting.increase time on bid", true, "Should the remaining time be increased when a bid is placed?");
	public static ConfigEntry TIME_TO_INCREASE_BY_ON_BID = create("auction setting.time to increase by on the bid", 20, "How many seconds should be added to the remaining time?");
	public static ConfigEntry ALLOW_SALE_OF_DAMAGED_ITEMS = create("auction setting.allow sale of damaged items", true, "If true, player's can sell items that are damaged (not max durability)");
	public static ConfigEntry ALLOW_FLOODGATE_PLAYERS = create("auction setting.allow flood gate players", false, "If true, player's who connected using floodgate (bedrock players) won't be able to use the auction house");
	public static ConfigEntry RESTRICT_ALL_TRANSACTIONS_TO_PERM = create("auction setting.restrict viewing all transactions", false, "If true, player's will need the perm: auctionhouse.transactions.viewall to view all transactions");
	public static ConfigEntry BLOCKED_WORLDS = create("auction setting.blocked worlds", Collections.singletonList("creative"), "A list of worlds that Auction House will be disabled in");
	public static ConfigEntry PREVENT_SALE_OF_REPAIRED_ITEMS = create("auction setting.prevent sale of repaired items", false, "Items repaired before this setting is turned on will still be able to be listed.");
	public static ConfigEntry ITEM_COPY_REQUIRES_GMC = create("auction setting.admin copy requires creative", false, "If true when using the admin copy option the player must be in creative");
	public static ConfigEntry LOG_ADMIN_ACTIONS = create("auction setting.log admin actions", true, "If true, any admin actions made will be logged");
	public static ConfigEntry ROUND_ALL_PRICES = create("auction setting.round all prices", false, "If true, any decimal numbers will be rounded to the nearest whole number");
	public static ConfigEntry DISABLE_AUTO_SAVE_MSG = create("auction setting.disable auto save message", false, "If true, auction house will not log the auto save task to the console");
	public static ConfigEntry DISABLE_CLEANUP_MSG = create("auction setting.disable clean up message", false, "If true, auction house will not log the clean up process to the console");
	public static ConfigEntry DISABLE_PROFILE_UPDATE_MSG = create("auction setting.disable profile update message", false, "If true, auction house will not log the player profile updates to the console");
	public static ConfigEntry RECORD_TRANSACTIONS = create("auction setting.record transactions", true, "Should every transaction be recorded (everything an auction is won or an item is bought)");
	public static ConfigEntry BUNDLE_IS_OPENED_ON_RECLAIM = create("auction setting.open bundle on reclaim", true, "When the player claims an expired item, if its a bundle, should it be automatically opened.");
	public static ConfigEntry MAX_SHULKER_IN_BUNDLE = create("auction setting.maximmum bundle and shulker in bundle", 5, "The maximum amount of shulkers/vanilla bundles that can be added to a bundle");
	public static ConfigEntry BROADCAST_AUCTION_LIST = create("auction setting.broadcast auction list", false, "Should the entire server be alerted when a player lists an item?");
	public static ConfigEntry BROADCAST_AUCTION_BID = create("auction setting.broadcast auction bid", false, "Should the entire server be alerted when a player bids on an item?");
	public static ConfigEntry BROADCAST_AUCTION_SALE = create("auction setting.broadcast auction sale", false, "Should the entire server be alerted when an auction is sold");
	public static ConfigEntry BROADCAST_AUCTION_ENDING = create("auction setting.broadcast auction ending", false, "Should the entire server be alerted when an auction is about to end?");
	public static ConfigEntry BROADCAST_AUCTION_ENDING_AT_TIME = create("auction setting.broadcast auction ending at time", 20, "When the time on the auction item reaches this amount of seconds left, the broadcast ending will take affect");
	public static ConfigEntry OFFLINE_NOTIFICATIONS_ENABLED = create("auction setting.offline notifications enabled", true, "When a player is offline, queue auction notifications and deliver them when they next join.");
	public static ConfigEntry USE_REALISTIC_BIDDING = create("auction setting.use realistic bidding", false, "If true auction house will use a more realistic bidding approach.");
	public static ConfigEntry BID_MUST_BE_HIGHER_THAN_PREVIOUS = create("auction setting.bid must be higher than previous", true, "Only applies if use realistic bidding is true.");
	public static ConfigEntry USE_LIVE_BID_NUMBER_IN_CONFIRM_GUI = create("auction setting.live bid number in confirm gui.use", true, "If true, the bid confirmation menu will auto update every 1 second by default");
	public static ConfigEntry LIVE_BID_NUMBER_IN_CONFIRM_GUI_RATE = create("auction setting.live bid number in confirm gui.rate", 1, "How often the confirm gui for bids will update");
	public static ConfigEntry ALLOW_USAGE_OF_BID_SYSTEM = create("auction setting.allow bid system usage", true, "Should players be allowed to use the bid option cmd params?");
	public static ConfigEntry ALLOW_USAGE_OF_BUY_NOW_SYSTEM = create("auction setting.allow buy now system usage", true, "Should players be allowed to use the right-click buy now feature on biddable items?");
	public static ConfigEntry BUY_NOW_DISABLED_BY_DEFAULT_IN_SELL_MENU = create("auction setting.buy now disabled in sell menu by default", false, "If true, players will just need to toggle buy now on their items to allow buy now");
	public static ConfigEntry AUTO_SAVE_ENABLED = create("auction setting.auto save.enabled", true, "Should the auto save task be enabled?");
	public static ConfigEntry AUTO_SAVE_EVERY = create("auction setting.auto save.time", 900, "How often should the auto save active? (in seconds. Ex. 900 = 15min)");
	public static ConfigEntry ALLOW_PURCHASE_OF_SPECIFIC_QUANTITIES = create("auction setting.allow purchase of specific quantities", false, "When a buy now item is right-clicked should it open a special gui to specify the quantity of items to buy from the stack?");
	public static ConfigEntry USE_REFRESH_COOL_DOWN = create("auction setting.use refresh cool down", true, "Should the refresh cooldown be enabled?");
	public static ConfigEntry REFRESH_COOL_DOWN = create("auction setting.refresh cool down", 2, "How many seconds should pass before the player can refresh the auction house again?");
	public static ConfigEntry MAIN_AH_FILTER_COOLDOWN = create("auction setting.auction house filter cooldown", 1500, "How many milliseconds should pass before they can change the filter again? use -1 to disable");
	public static ConfigEntry MAIN_AH_NAVIGATION_COOLDOWN = create("auction setting.auction house page navigation cooldown", 500, "How many milliseconds should pass before they can navigate to another page? use -1 to disable");
	public static ConfigEntry MAIN_AH_ITEM_CLICK_COOLDOWN = create("auction setting.auction house item click cooldown", 500, "How many milliseconds should pass before a player can click another auction item? use -1 to disable");
	public static ConfigEntry MAIN_AH_REFRESH_BUTTON_COOLDOWN = create("auction setting.auction house refresh button cooldown", 1000, "How many milliseconds should pass before a player can click the refresh button again? use -1 to disable");
	public static ConfigEntry TRANSACTION_FILTER_COOLDOWN = create("auction setting.transaction filter cooldown", 1500, "How many milliseconds should pass before they can change the filter again? use -1 to disable");
	public static ConfigEntry TRANSACTION_NAVIGATION_COOLDOWN = create("auction setting.transaction page navigation cooldown", 500, "How many milliseconds should pass before they can navigate to another page? use -1 to disable");
	public static ConfigEntry CMD_COOLDOWN = create("auction setting.command cool down", 0, "How many seconds should pass between using commands");
	public static ConfigEntry ALLOW_PURCHASE_IF_INVENTORY_FULL = create("auction setting.allow purchase with full inventory", true, "Should auction house allow players to buy items even if their inventory is full?");
	public static ConfigEntry ASK_FOR_BID_CONFIRMATION = create("auction setting.ask for bid confirmation", true, "Should Auction House open the confirmation menu for the user to confirm whether they actually meant to place a bid or not?");
	public static ConfigEntry ASK_FOR_LISTING_CONFIRMATION = create("auction setting.ask for listing confirmation", false, "Should Auction House ask the user to confirm the listing?");
	public static ConfigEntry REPLACE_HOW_TO_SELL_WITH_LIST_BUTTON = create("auction setting.replace how to sell with list button", false, "This will replace the How to Sell button with a List Item button");
	public static ConfigEntry ALLOW_USAGE_OF_SELL_GUI = create("auction setting.allow usage of sell gui", true, "Should the sell menu be enabled?");
	public static ConfigEntry FORCE_AUCTION_USAGE = create("auction setting.force auction usage", false, "If enabled, all items sold on the auction house must be an auction (biddable) items");
	public static ConfigEntry ALLOW_INDIVIDUAL_ITEM_CLAIM = create("auction setting.allow individual item claim", true, "If enabled, you will be able to click individual items from the expiration menu to claim them back.");
	public static ConfigEntry FORCE_CUSTOM_BID_AMOUNT = create("auction setting.force custom bid amount", false, "If enabled, the bid increment line on auction items will be hidden and when you go to bid on an item, it will ask you to enter a custom amount.");
	public static ConfigEntry BIDDING_TAKES_MONEY = create("auction setting.bidding takes money", false, "If enabled, players will be outright charged the current bid for the item. If they are outbid or the item is cancelled, they will get their money back.");
	public static ConfigEntry FORCE_SYNC_MONEY_ACTIONS = create("auction setting.force sync money actions", false, "If true, auction house will forcefully run a sync task to withdraw/deposit cash.");
	public static ConfigEntry EXPIRATION_TIME_LIMIT_ENABLED = create("auction setting.expiration time limit.enabled", false, "If true, auction house will automatically delete unclaimed expired items after set time");
	public static ConfigEntry EXPIRATION_TIME_LIMIT = create("auction setting.expiration time limit.time", 24 * 7, "In hours, what should the minimum age of an unclaimed item be in order for it to be deleted?");
	public static ConfigEntry ASK_FOR_CANCEL_CONFIRM_ON_BID_ITEMS = create("auction setting.ask for cancel confirm on bid items", true, "Should Auction House ask the user if they want to cancel the item?");
	public static ConfigEntry ASK_FOR_CANCEL_CONFIRM_ON_NON_BID_ITEMS = create("auction setting.ask for cancel confirm on non bid items", false, "Should Auction House ask the user if they want to cancel the item?");
	public static ConfigEntry ASK_FOR_CANCEL_CONFIRM_ON_ALL_ITEMS = create("auction setting.ask for cancel confirm on end all", true, "Should Auction House ask the user to confirm in chat when using end all in active listings?");
	public static ConfigEntry BASE_PRICE_MUST_BE_HIGHER_THAN_BID_START = create("auction setting.base price must be higher than bid start", true, "Should the base price (buy now price) be higher than the initial bid starting price?");
	public static ConfigEntry SYNC_BASE_PRICE_TO_HIGHEST_PRICE = create("auction setting.sync the base price to the current price", true, "Ex. If the buy now price was 100, and the current price exceeds 100 to say 200, the buy now price will become 200.");
	public static ConfigEntry ADMIN_OPTION_SHOW_RETURN_ITEM = create("auction setting.admin option.show return to player", true);
	public static ConfigEntry ADMIN_OPTION_SHOW_CLAIM_ITEM = create("auction setting.admin option.show claim item", true);
	public static ConfigEntry ADMIN_OPTION_SHOW_DELETE_ITEM = create("auction setting.admin option.show delete item", true);
	public static ConfigEntry ADMIN_OPTION_SHOW_COPY_ITEM = create("auction setting.admin option.show copy item", true);
	public static ConfigEntry ALLOW_PLAYERS_TO_ACCEPT_BID = create("auction setting.allow players to accept bid", true, "If true, players can right click a biddable item inside their active listings menu to accept the current bid");
	public static ConfigEntry SELLERS_MUST_WAIT_FOR_TIME_LIMIT_AFTER_BID = create("auction setting.prevent cancellation of bid on items", false, "If true, players must wait out the duration of the auction listing if there is already a bid on it");
	public static ConfigEntry PER_WORLD_ITEMS = create("auction setting.per world items", false, "If true, items can only be seen in the world they were listed in");
	public static ConfigEntry ALLOW_PLAYERS_TO_DEFINE_AUCTION_TIME = create("auction setting.allow players to set auction time", false, "If true players can use -t 1 day for example to set the listing time for their item");
	public static ConfigEntry MAX_CUSTOM_DEFINED_TIME = create("auction setting.max custom defined time", 604800, "What should the limit on custom defined listing times be in seconds?");
	public static ConfigEntry SMART_MIN_BUY_PRICE = create("auction setting.smart min and buy price", false, "Will calculate buy now/min prices on a per item basis.");
	public static ConfigEntry TITLE_INPUT_CANCEL_WORD = create("auction setting.title input cancel word", "cancel", "The word to be used to cancel chat inputs (users can also just click any block)");
	public static ConfigEntry USE_SEPARATE_FILTER_MENU = create("auction setting.use separate filter menu", false, "If true, rather than using a single filter item inside the auction menu it will open an entirely new menu to select the filter");
	public static ConfigEntry FILTER_ONLY_USES_WHITELIST = create("auction setting.filter only uses whitelist", false, "If true, auction house will ignore default filters, and only filter by the items added to the category whitelists");
	public static ConfigEntry FILTER_WHITELIST_USES_DURABILITY = create("auction setting.filter whitelist uses durability", false, "If true, the filter will look at material names and durability values for comparisons only");
	public static ConfigEntry SELL_MENU_REQUIRES_USER_TO_HOLD_ITEM = create("auction setting.require user to hold item when using sell menu", false, "If enabled, when running just /ah sell, the user will need to hold the item in their hand");
	public static ConfigEntry OPEN_MAIN_AUCTION_HOUSE_AFTER_MENU_LIST = create("auction setting.open main auction house after listing using menu", true, "Should the main auction house be opened after the user lists an item using the sell menu?");
	public static ConfigEntry SELL_MENU_CLOSE_SENDS_TO_LISTING = create("auction setting.sell menu close sends to listings", true, "If true, when the player clicks the close button within the sell menu, it will send them to the main auction house");
	public static ConfigEntry PAYMENT_HANDLE_USE_CMD = create("auction setting.payment handle.use command", false, "In special cases, you will want to use this");
	public static ConfigEntry PAYMENT_HANDLE_WITHDRAW_CMD = create("auction setting.payment handle.withdraw command", "eco take %player% %price%", "Command that will be executed to withdraw a player's balance");
	public static ConfigEntry PAYMENT_HANDLE_DEPOSIT_CMD = create("auction setting.payment handle.deposit command", "eco give %player% %price%", "Command that will be executed to deposit a player's balance");
	public static ConfigEntry TICK_UPDATE_TIME = create("auction setting.tick auctions every", 1, "How many seconds should pass before the plugin updates all the times on items?");
	public static ConfigEntry CLAIM_MS_DELAY = create("auction setting.item claim delay", 100, "How many ms should a player wait before being allowed to claim an item?");
	public static ConfigEntry ALLOW_ITEM_BUNDLES = create("auction setting.bundles.enabled", true, "If true, players can use -b in the sell command to bundle all similar items into a single item.");
	public static ConfigEntry ITEM_BUNDLE_ITEM = create("auction setting.bundles.item", CompMaterial.GOLD_BLOCK.name(), "Material used for bundle items");
	public static ConfigEntry MIN_ITEM_PRICE_USES_SIMPLE_COMPARE = create("auction setting.use simple compare for min item price", true, "If true, AH will just compare material and model data types");
	public static ConfigEntry FILTER_CLICKS_SORT_PRICE_RECENT_ENABLED = create("auction setting.default filters.enabled clicks.sort by price or recent", true);
	public static ConfigEntry FILTER_CLICKS_RESET_ENABLED = create("auction setting.default filters.enabled clicks.reset", true);
	public static ConfigEntry FILTER_CLICKS_LISTING_CURRENCY_ENABLED = create("auction setting.default filters.enabled clicks.listing currency", true);
	public static ConfigEntry FILTER_CLICKS_SALE_TYPE_ENABLED = create("auction setting.default filters.enabled clicks.sort sale type", true);
	public static ConfigEntry FILTER_CLICKS_CHANGE_CATEGORY_ENABLED = create("auction setting.default filters.enabled clicks.change category", true);
	public static ConfigEntry FILTER_CLICKS_TRANSACTION_BUY_TYPE_ENABLED = create("auction setting.default filters.enabled clicks.transaction buy type", true);
	public static ConfigEntry FILTER_DONT_REMEMBER = create("auction setting.default filters.do not save filter setting", false, "If true if you close the auction house your filter options will reset back to default");

	/*
	==============================================================
					Blocked items & Auction time
	==============================================================
	 */
	public static ConfigEntry BLOCKED_ITEMS = create("blocked items", Collections.singletonList("ENDER_CHEST"), "Materials that should be blocked (not allowed to sell)");
	public static ConfigEntry BLOCKED_NBT_TAGS = create("blocked nbt tags", Collections.singletonList("example_tag"), "A list of NBT tags that are blocked from the auction house. These are case sensitive");
	public static ConfigEntry MAKE_BLOCKED_ITEMS_A_WHITELIST = create("blocked items is whitelist", false, "If true, blocked items will become a whitelist, meaning only items specified in blocked list will be allowed in the ah");
	public static ConfigEntry BLOCKED_ITEM_NAMES = create("blocked item names", Arrays.asList("fuck", "bitch", "nigger", "nigga", "pussy"), "If an item contains any words/names specified here, it won't list.");
	public static ConfigEntry BLOCKED_ITEM_LORES = create("blocked item lores", Arrays.asList("kill yourself", "another random phrase"), "If an item lore contains any of these values, it won't list");
	public static ConfigEntry AUCTION_TIME = create("auction time", Collections.singletonList("rankone:30"), "Special time permissions for users. Format: key:seconds e.g. rankone:30");

	/*
	==============================================================
					Auction stack info layout (order of placeholders)
	==============================================================
	 */
	public static ConfigEntry AUCTION_STACK_INFO_LAYOUT = create("auction stack.info layout", Arrays.asList(
			"%original_item_lore%",
			"%header%",
			"%seller%",
			"%highest_bidder%",
			"",
			"%buy_now_price%",
			"%current_price%",
			"%bid_increment%",
			"",
			"%listing_time%",
			"%listing_priority%",
			"%listing_watched%",
			"%controls_header%",
			"%controls%",
			"%controls_footer%"
	), "The info order for the stacks; change the ordering of listing stack information");

	/*
	==============================================================
					Sounds & Transaction logging
	==============================================================
	 */
	public static ConfigEntry SOUNDS_LISTED_ITEM = create("sounds.listed item on the auction house", "ENTITY_EXPERIENCE_ORB_PICKUP", "Sound when listing item");
	public static ConfigEntry SOUNDS_NAVIGATE_GUI_PAGES = create("sounds.navigated between gui pages", "ENTITY_BAT_TAKEOFF", "Sound when navigating between GUI pages");
	public static ConfigEntry SOUNDS_NOT_ENOUGH_MONEY = create("sounds.not enough money", "ENTITY_ITEM_BREAK", "Sound when player does not have enough money");
	public static ConfigEntry SOUNDS_PURCHASE_SUCCESS = create("sounds.purchase success", "ENTITY_EXPERIENCE_ORB_PICKUP", "Sound when a player successfully buys an item");
	public static ConfigEntry SOUNDS_ITEM_SOLD = create("sounds.item sold", "BLOCK_NOTE_BLOCK_PLING", "Sound when someone buys the seller's item (only plays if seller is online)");
	public static ConfigEntry SOUNDS_GUI_CLICK = create("sounds.gui click", "UI_BUTTON_CLICK", "Sound when clicking GUI elements");
	public static ConfigEntry TRANSACTION_LOGGING_ENABLED = create("settings.transaction logging.enabled", true, "If true, all transactional actions will be logged to daily-rotated log files");
	public static ConfigEntry TRANSACTION_LOGGING_RETENTION_DAYS = create("settings.transaction logging.retention days", 30, "How many days to keep transaction log files before automatic cleanup (0 = never cleanup)");

	/*
	==============================================================
					Discord (non-display config)
	==============================================================
	 */
	public static ConfigEntry DISCORD_ENABLED = create("discord.enabled", false, "Should the discord webhook feature be enabled?");
	public static ConfigEntry DISCORD_MSG_USERNAME = create("discord.user.username", "Auction House", "The name of the user who will send the message");
	public static ConfigEntry DISCORD_MSG_PFP = create("discord.user.avatar picture", "https://cdn.kiranhart.com/spigot/auctionhouse/icon.png", "The avatar image of the discord user");
	public static ConfigEntry DISCORD_WEBHOOKS = create("discord.webhooks", Collections.singletonList("https://discord.com/api/webhooks/example/channel"), "A list of webhook urls (channels) you want a message sent to");
	public static ConfigEntry DISCORD_DELAY_LISTINGS = create("discord.delay options.delay listing", false, "If true AuctionHouse will delay sending new listing messages by the specified seconds.");
	public static ConfigEntry DISCORD_DELAY_LISTING_TIME = create("discord.delay options.delay listing time", 10, "How many seconds should Auction House wait to send the discord message for new listings");
	public static ConfigEntry DISCORD_ALERT_ON_AUCTION_START = create("discord.alerts.new auction listing", true, "Should a message be sent when a new auction listing is made");
	public static ConfigEntry DISCORD_ALERT_ON_BIN_START = create("discord.alerts.new bin listing", true, "Should a message be sent when a new bin listing is made (non biddable)");
	public static ConfigEntry DISCORD_ALERT_ON_BID = create("discord.alerts.new bid", true, "Should a message be sent when a bid is placed on an item");
	public static ConfigEntry DISCORD_ALERT_ON_BIN_BUY = create("discord.alerts.bin listing bought", true, "Should a message be sent when an item is bought");
	public static ConfigEntry DISCORD_ALERT_ON_AUCTION_WON = create("discord.alerts.auction listing won", true, "Should a message be sent when an auction is won");
	public static ConfigEntry DISCORD_COLOR_NEW_AUCTION_LISTING = create("discord.colors.new auction listing", "137-100-100", "The color of the embed, it needs to be in hsb format. Separate the numbers with a -");
	public static ConfigEntry DISCORD_COLOR_NEW_BIN_LISTING = create("discord.colors.new bin listing", "137-100-100", "The color of the embed, it needs to be in hsb format. Separate the numbers with a -");
	public static ConfigEntry DISCORD_COLOR_NEW_BID = create("discord.colors.new bid", "137-100-100", "The color of the embed, it needs to be in hsb format. Separate the numbers with a -");
	public static ConfigEntry DISCORD_COLOR_BIN_LISTING_BOUGHT = create("discord.colors.bin listing bought", "137-100-100", "The color of the embed, it needs to be in hsb format. Separate the numbers with a -");
	public static ConfigEntry DISCORD_COLOR_AUCTION_LISTING_WON = create("discord.colors.auction listing won", "137-100-100", "The color of the embed, it needs to be in hsb format. Separate the numbers with a -");
	public static ConfigEntry DISCORD_FIELD_SELLER_INLINE = create("discord.field.seller.inline", true);
	public static ConfigEntry DISCORD_FIELD_ITEM_INLINE = create("discord.field.item.inline", true);
	public static ConfigEntry DISCORD_FIELD_BIN_LISTING_PRICE_INLINE = create("discord.field.bin listing price.inline", true);
	public static ConfigEntry DISCORD_FIELD_AUCTION_BUYOUT_PRICE_INLINE = create("discord.field.auction buyout price.inline", true);
	public static ConfigEntry DISCORD_FIELD_AUCTION_START_PRICE_INLINE = create("discord.field.auction start price.inline", false);
	public static ConfigEntry DISCORD_FIELD_BIN_BOUGHT_INLINE = create("discord.field.bin listing bought.inline", false);
	public static ConfigEntry DISCORD_FIELD_AUCTION_WON_INLINE = create("discord.field.auction listing won price.inline", false);
	public static ConfigEntry DISCORD_FIELD_AUCTION_WINNER_INLINE = create("discord.field.auction winner.inline", false);
	public static ConfigEntry DISCORD_FIELD_AUCTION_BIDDER_INLINE = create("discord.field.auction bidder.inline", false);
	public static ConfigEntry DISCORD_FIELD_BID_AMT_INLINE = create("discord.field.bid amount.inline", true);
	public static ConfigEntry DISCORD_FIELD_CURRENT_PRICE_INLINE = create("discord.field.current auction price.inline", true);

	/*
	==============================================================
					TBD
	==============================================================
	 */
	public static ConfigEntry AUCTION_HOUSE_USAGE_MODE = create("settings.usage mode", AuctionUsageMode.BIN_AND_AUCTION.name(), "How core listing mechanics should function for auction house.");
	public static ConfigEntry ALLOW_OWNER_TO_BUY_OWN_ITEM = create("settings.purchasing.allow owner to buy own item", false, "Should the lister be allowed to buy their own item (... but why)");
	public static ConfigEntry ALLOW_OWNER_TO_BID_ON_OWN_ITEM = create("settings.purchasing.allow owner to bid on own item", false, "Should the lister be allowed to bid on their own item (... but why)");


	/*
	==============================================================
			   Auction / Bin Listing Specific Features
	==============================================================
	 */
	public static ConfigEntry ALLOW_BUYOUT_ON_AUCTIONS = create("settings.allow buyout on auctions", true, "If true players can list auctions that use the buyout feature");


	/*
	==============================================================
						Min & Max Item Prices
	==============================================================
	 */
	public static ConfigEntry MIN_STARTING_PRICE = create("settings.pricing.minimum starting price", 1, "The minimum price a listing can be set at");
	public static ConfigEntry MIN_BIN_PRICE = create("settings.pricing.minimum bin price", 1, "The minimum price for a bin (non biddable) listing");
	public static ConfigEntry MAX_STARTING_PRICE = create("settings.pricing.maximum starting price", 1000000000, "The maximum price a listing can be set at");
	public static ConfigEntry MAX_BIN_PRICE = create("settings.pricing.maximum bin price", 1000000000, "The maximum price for a bin (non biddable) listing");

	/*
	==============================================================
					 		   Taxes
	==============================================================
	 */

	/*
	==============================================================
						Number & Date Formats
	==============================================================
	 */
	public static ConfigEntry DATE_FORMAT = create("settings.formatting.date format", "MMMM/dd/yyyy - hh:mm a", "The default date format to be used");
	public static ConfigEntry TIME_FORMAT = create("settings.formatting.time format", "hh:mm:ss a", "The default time format to be used");
	public static ConfigEntry DATETIME_FORMAT = create("settings.formatting.datetime format", "MMMM/dd/yyyy - hh:mm:ss a", "The default combined date/time format to be used");

	/*
	==============================================================
					 Internal Timers/Cooldowns
	==============================================================
	 */
	public static ConfigEntry DELAY_REFRESH_MAIN_AUCTION = create("settings.delays.main auction refresh", 3000, "How many milliseconds must pass before the user can click the refresh button again. (0 to disable)");
	public static ConfigEntry DELAY_EXPIRED_ITEM_CLAIM = create("settings.delays.expired item claim", 100, "How many milliseconds must pass between each expired item claim (0 to disable)");
	public static ConfigEntry DELAY_EXPIRED_ITEM_CLAIM_ALL = create("settings.delays.expired collect all", 1, "How many milliseconds must pass before the user can click the collect all button again (0 to disable)");
	public static ConfigEntry DELAY_INTERNAL_LISTING_CREATE = create("settings.delays.internal create delay", 2, "How many ticks should auction house wait before actually creating the item.");
	public static ConfigEntry DELAY_NEW_LISTING = create("settings.delays.new listing", -1, "If not set to -1 (disabled) how many seconds must a player wait to list another item after listing 1?");
	public static ConfigEntry TIMER_AUTO_REFRESH_MAIN_AUCTION = create("settings.timers.main auction auto refresh", 20, "How many ticks before the page updates all items (0 to disable)");
	public static ConfigEntry TIMER_GUI_AUTO_REFRESH = create("settings.timers.refresh guis every", 10, "How many seconds should pass before the auction gui auto refreshes?");
	public static ConfigEntry TIMER_SQL_PULL_RATE = create("settings.timers.sql pull rate", 20 * 60 * 10, "How many ticks before the page updates all items (0 to disable)");
	public static ConfigEntry TIMER_ITEM_UPDATE_TIME = create("settings.timers.update items every", 1, "How many seconds should pass before the plugin updates all the times on items?");

	// ========================== GARBAGE DELETION ==========================
	public static ConfigEntry GARBAGE_DELETION_TIMED_MODE = create("settings.clean up system.timed mode", true, "If true, auction house will only run the garbage deletion task, after set amount of seconds", "otherwise if false, it will wait until the total garbage bin count", "reaches/exceeds the specified value");
	public static ConfigEntry GARBAGE_DELETION_TIMED_DELAY = create("settings.clean up system.timed delay", 60, "If timed mode is true, this value will be ran after x specified seconds, the lower this number the more frequent a new async task will be ran!");
	public static ConfigEntry GARBAGE_DELETION_MAX_ITEMS = create("settings.clean up system.max items", 30, "If timed mode is false, whenever the garbage bin reaches this number, auction house will run the deletion task.", "You should adjust this number based on your server since some servers may have more or less items being claimed / marked for garbage clean up");


	/*
	==============================================================
					 	  Click Controls
	==============================================================
	 */

	/*
	==============================================================
				       Inventory Icons & Slots
	==============================================================
	 */
	public static ConfigEntry GUI_FILLER = create("gui.filler item", CompMaterial.BLACK_STAINED_GLASS_PANE.name(), "An item to be used to fill empty gui slots");

	// ==================== Main Auction Menu ==================== //
	public static ConfigEntry GUI_MAIN_ROWS = create("gui.main.rows", 6, "How many rows should the gui have");
	public static ConfigEntry GUI_MAIN_FILL_SLOTS = create("gui.main.fill slots", IntStream.rangeClosed(0, 44).boxed().collect(Collectors.toList()), "Slot numbers where auction items will be placed");
	public static ConfigEntry GUI_MAIN_DECORATION = create("gui.main.decoration", Collections.singletonList(""), "Additional Decoration Items, format is MATERIAL_NAME:slot so ex. DIAMOND:1");

	public static ConfigEntry GUI_MAIN_ITEMS_COLLECTION_BIN_SLOT = create("gui.main.items.collection bin.slot", 46, "What slot should this item be placed in?");
	public static ConfigEntry GUI_MAIN_ITEMS_COLLECTION_BIN_ITEM = create("gui.main.items.collection bin.item", CompMaterial.ENDER_CHEST.name(), "The material type/texture url for this item");

	public static ConfigEntry GUI_MAIN_ITEMS_ACTIVE_LISTINGS_SLOT = create("gui.main.items.active listings.slot", 45, "What slot should this item be placed in?");
	public static ConfigEntry GUI_MAIN_ITEMS_ACTIVE_LISTINGS_ITEM = create("gui.main.items.active listings.item", CompMaterial.DIAMOND.name(), "The material type/texture url for this item");

	public static ConfigEntry GUI_MAIN_ITEMS_PROFILE_SLOT = create("gui.main.items.profile.slot", 53, "What slot should this item be placed in?");

	public static ConfigEntry GUI_MAIN_ITEMS_REFRESH_SLOT = create("gui.main.items.refresh.slot", 49, "What slot should this item be placed in?");
	public static ConfigEntry GUI_MAIN_ITEMS_REFRESH_ITEM = create("gui.main.items.refresh.item", CompMaterial.END_CRYSTAL.name(), "The material type/texture url for this item");

	public static ConfigEntry GUI_MAIN_ITEMS_SEARCH_SLOT = create("gui.main.items.search.slot", 52, "What slot should this item be placed in?");
	public static ConfigEntry GUI_MAIN_ITEMS_SEARCH_ITEM = create("gui.main.items.search.item", CompMaterial.DARK_OAK_SIGN.name(), "The material type/texture url for this item");

	// ==================== Auction Collection Menu ==================== //
	public static ConfigEntry GUI_COLLECTION_BIN_ROWS = create("gui.collection bin.rows", 6, "How many rows should the gui have");
	public static ConfigEntry GUI_COLLECTION_BIN_FILL_SLOTS = create("gui.collection bin.fill slots", IntStream.rangeClosed(0, 44).boxed().collect(Collectors.toList()), "Slot numbers where collection items will be placed");
	public static ConfigEntry GUI_COLLECTION_BIN_DECORATION = create("gui.collection bin.decoration", Collections.singletonList(""), "Additional Decoration Items, format is MATERIAL_NAME:slot so ex. DIAMOND:1");


	// ==================== Player Preferences Menu ==================== //
	public static ConfigEntry GUI_PROFILE_SETTINGS_ROWS = create("gui.profile settings.rows", 6, "How many rows should the gui have");
	public static ConfigEntry GUI_PROFILE_SETTINGS_DECORATION = create("gui.profile settings.decoration", Collections.singletonList(""), "Additional Decoration Items, format is MATERIAL_NAME:slot so ex. DIAMOND:1");

	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_LANGUAGE_SLOT = create("gui.profile settings.items.language.slot", 10, "What slot should this item be placed in?");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_LANGUAGE_ITEM = create("gui.profile settings.items.language.item", "https://textures.minecraft.net/texture/fc1e73023352cbc77b896fe7ea242b43143e013bec5bf314d41e5f26548fb2d2", "The material type/texture url for this item");

	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_LISTING_INFO_SLOT = create("gui.profile settings.items.show listing info.slot", 12, "What slot should this item be placed in?");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_LISTING_INFO_ITEM_ON = create("gui.profile settings.items.show listing info.item on", CompMaterial.LIME_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_LISTING_INFO_ITEM_OFF = create("gui.profile settings.items.show listing info.item off", CompMaterial.RED_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");

	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_OUTBID_SLOT = create("gui.profile settings.items.show alert on outbid.slot", 14, "What slot should this item be placed in?");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_OUTBID_ITEM_ON = create("gui.profile settings.items.show alert on outbid.item on", CompMaterial.LIME_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_OUTBID_ITEM_OFF = create("gui.profile settings.items.show alert on outbid.item off", CompMaterial.RED_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");

	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_SALE_SLOT = create("gui.profile settings.items.show alert on sale.slot", 16, "What slot should this item be placed in?");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_SALE_ITEM_ON = create("gui.profile settings.items.show alert on sale.item on", CompMaterial.LIME_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_SALE_ITEM_OFF = create("gui.profile settings.items.show alert on sale.item off", CompMaterial.RED_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");

	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_AUCTION_WIN_SLOT = create("gui.profile settings.items.show alert on auction win.slot", 28, "What slot should this item be placed in?");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_AUCTION_WIN_ITEM_ON = create("gui.profile settings.items.show alert on auction win.item on", CompMaterial.LIME_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");
	public static ConfigEntry GUI_PROFILE_SETTINGS_ITEMS_SHOW_ALERT_ON_AUCTION_WIN_ITEM_OFF = create("gui.profile settings.items.show alert on auction win.item off", CompMaterial.RED_STAINED_GLASS_PANE.name(), "The material type/texture url for this item");

	// ==================== Auction Ban Menu ==================== //
	public static ConfigEntry GUI_BAN_BACKGROUND = create("gui.ban.background.item", CompMaterial.BLACK_STAINED_GLASS_PANE.name(), "The background item for this menu");

	// ==================== Player Selector Menu ==================== //
	public static ConfigEntry GUI_PLAYER_SELECTOR_BACKGROUND = create("gui.player selector.background.item", CompMaterial.BLACK_STAINED_GLASS_PANE.name(), "The background item for this menu");

	/*
	==============================================================
				      	   Confirmations
	==============================================================
	 */
	public static ConfigEntry CONFIRM_LISTING = create("settings.confirmation.listing", false, "Ask for confirmation before listing an item?");
	public static ConfigEntry CONFIRM_PLACE_BID = create("settings.confirmation.place bid", false, "Ask for confirmation before bidding on an item?");
	public static ConfigEntry CONFIRM_BUY_ITEM = create("settings.confirmation.buy item", false, "Ask for confirmation before buying an item?");
	public static ConfigEntry CONFIRM_ACCEPT_BID = create("settings.confirmation.accept bid", false, "Ask for confirmation before accepting current bid?");
	public static ConfigEntry CONFIRM_CANCEL_LISTING = create("settings.confirmation.cancel listing", false, "Ask for confirmation before canceling a listing?");

	public static void init() {
		AuctionHouse.getMigrationCoreConfig().init();
	}
}
