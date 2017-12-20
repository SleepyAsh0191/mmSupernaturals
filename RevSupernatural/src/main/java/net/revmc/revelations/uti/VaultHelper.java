package net.revmc.revelations.uti;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * Helper class for Vault Economy and Permissions
 */
public class VaultHelper {
	public static Economy econ = null;
	public static Permission permission = null;
	public static Chat chat = null;

	/**
	 * Sets up the economy instance
	 * 
	 * @return true if successful
	 */
	public static boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			econ = economyProvider.getProvider();
		}
		return econ != null;
	}

	/**
	 * Sets up the permissions instance
	 * 
	 * @return true if successful
	 */
	public static boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
			permission = permissionProvider.getProvider();
		}
		return (permission != null);
	}

	public static boolean setupChat() {
		RegisteredServiceProvider<Chat> chatProvider = Bukkit.getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.chat.Chat.class);
		if (chatProvider != null) {
			chat = chatProvider.getProvider();
		}
		return (chat != null);
	}

	/**
	 * Checks permission of player in world or in any world
	 * 
	 * @param player
	 * @param perm
	 * @return true if the player has the perm
	 */
	public static boolean checkPerm(final Player player, final String perm) {
		return permission.has(player, perm);
	}

	/**
	 * Adds permission to player
	 * 
	 * @param player
	 * @param perm
	 */
	public static void addPerm(final Player player, final String perm) {
		permission.playerAdd(player, perm);
	}

	/**
	 * Removes a player's permission
	 * 
	 * @param player
	 * @param perm
	 */
	public static void removePerm(final Player player, final String perm) {
		permission.playerRemove(player, perm);
	}

}