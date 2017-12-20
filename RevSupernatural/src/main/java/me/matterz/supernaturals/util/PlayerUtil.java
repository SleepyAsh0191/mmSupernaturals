package me.matterz.supernaturals.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

public class PlayerUtil {

	public static Block getTargetBlock(Player player, int range) {
		BlockIterator itr = new BlockIterator(player, 20);
		Block lastBlock = player.getEyeLocation().getBlock();
		while (itr.hasNext()) {
			lastBlock = itr.next();
			if (lastBlock.getType() != Material.AIR) {
				break;
			}
		}
		return lastBlock;
	}
}
