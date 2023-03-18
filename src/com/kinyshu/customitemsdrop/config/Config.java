package com.kinyshu.customitemsdrop.config;
import com.kinyshu.customitemsdrop.Main;
import com.kinyshu.customitemsdrop.info.BlockInfo;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public List< BlockInfo > blockList = new ArrayList<>();

    public static Config config;
    public static Config getInstance() {
        return config;
    }

    public Config() {
        config = this;
        this.load();
    }

    public void load() {

        FileConfiguration configuration = Main.getInstance().getConfig();

        configuration.getConfigurationSection("settings.blocks").getKeys(false).forEach(block -> {
            configuration.getConfigurationSection("settings.blocks." + block + ".drops").getKeys(false).forEach(id -> {

                this.blockList.add(new BlockInfo(block.toUpperCase(),
                        new BlockInfo.Drops(
                                configuration.getInt("settings.blocks." + block + ".drops." + id + ".id"),
                                configuration.getDouble("settings.blocks." + block + ".drops." + id + ".percent"),
                                configuration.getInt("settings.blocks." + block + ".drops." + id + ".count")
                        )));
            });
        });
    }

    public void reload() {
        this.blockList.clear();
        this.load();
    }
}
