package com.kinyshu.customitemsdrop;

import com.kinyshu.customitemsdrop.config.Config;
import com.kinyshu.customitemsdrop.events.OnBlockBreak;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main main;
    public static Main getInstance() {
        return main;
    }

    @Override public void onEnable() {

        main = this;
        this.saveDefaultConfig();

        new Config();
        this.getServer().getPluginManager().registerEvents(new OnBlockBreak(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.RED + "Disabled " + this.getName());
    }
}
