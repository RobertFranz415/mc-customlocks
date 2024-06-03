package com.valiantrealms.customlocksmc;

import com.valiantrealms.customlocksmc.Locks.Locks;
import com.valiantrealms.customlocksmc.commands.LockMenu;
import com.valiantrealms.customlocksmc.util.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CustomLocksMC extends JavaPlugin {
    private ConfigUtil diffConfig;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling CustomLocksMC");

        this.saveResource("LockPickDifficulties.yml", false);
        this.diffConfig = new ConfigUtil(this, "LockPickDifficulties.yml");


        // Enabling commands
        Objects.requireNonNull(getCommand("customlockpick")).setExecutor(new LockMenu(this));

        new DelayedTask(this);
        new Locks(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getScheduler().cancelTask(867530942); // Canceling save process
        Bukkit.getLogger().info("Disabling CustomLocksMC");
    }

    public ConfigUtil getDiffConfig() {
        return this.diffConfig;
    }
    public void setDiffConfig(ConfigUtil diffConfig) {
        this.diffConfig = diffConfig;
        diffConfig.save();
    }

    public static CustomLocksMC getInstance() {
        return getPlugin(CustomLocksMC.class);
    }

}
