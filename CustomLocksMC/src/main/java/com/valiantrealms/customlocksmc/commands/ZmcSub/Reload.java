package com.valiantrealms.customlocksmc.commands.ZmcSub;

import com.valiantrealms.customlocksmc.CustomLocksMC;
import org.bukkit.Bukkit;

@SuppressWarnings("CallToPrintStackTrace")
public class Reload {
    private final CustomLocksMC plugin;
    public Reload(CustomLocksMC plugin){
        this.plugin = plugin;
    }

    public void ReloadAll(){
        try{
            plugin.reloadConfig();
            Bukkit.getLogger().info("Saved player files...");


        }catch(Exception e){
            Bukkit.getLogger().severe("Something went wrong trying to reload the configs," +
                    " please check the console.");
            e.printStackTrace();
        }
    }
}
