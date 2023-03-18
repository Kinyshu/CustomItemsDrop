package com.kinyshu.customitemsdrop.events;

import com.kinyshu.customitemsdrop.config.Config;
import com.kinyshu.customitemsdrop.info.BlockInfo;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class OnBlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            for (BlockInfo it : Config.getInstance().blockList) {
                if (it.name.equals(event.getBlock().getType().name())) {
                    double percent = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
                    if (it.drops.percent >= percent) {

                        int level = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                        ItemStack itemStack = new ItemStack(Material.getMaterial(it.drops.id), it.drops.count + level);
                        {
                            player.getInventory().addItem(itemStack);
                            player.playSound(event.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.f, 1.f);
                        }
                        break;
                    }
                }
            }
        }
    }
}
