package com.valiantrealms.customlocksmc.commands;

import com.valiantrealms.customlocksmc.CustomLocksMC;
import com.valiantrealms.customlocksmc.util.Keys;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

//TODO
// Add loot to chests
public class LockMenu implements Listener, CommandExecutor {
    private final CustomLocksMC plugin;
    private final String invName = "Unlock Chest";

    public LockMenu(CustomLocksMC plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    /**
     * General onClickEvent.  Determine what to do based on current inventory name.
     *
     * @param event inventory click
     */
    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event) {
        int slot = event.getSlot();
        UUID uuid = event.getWhoClicked().getUniqueId();
    }

    /**
     * /unlock command method.
     *
     * @param sender  who/what sent the command
     * @param command what command is being run
     * @param label   label
     * @param args    arguments
     * @return true
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Inventory inv = Bukkit.createInventory(player, 9 * 4, this.invName);

        inv.setItem(5, getKey());
        inv.setItem(6, getAdminKey());

        player.openInventory(inv);

        return true;
    }

    /**
     * Helper function for creating item stacks
     *
     * @param item Item to be created
     * @param name Custom name of the item
     * @param lore Custom Lore of the item
     * @return Custom item
     */
    private ItemStack getItem(ItemStack item, String name, String... lore) {
        ItemMeta meta = item.getItemMeta();

        Objects.requireNonNull(meta).setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);
        item.setItemMeta(meta);

        return item;
    }

    private ItemStack getKey() {
        ItemStack chest = new ItemStack(Material.KELP, 30);
        ItemMeta meta = chest.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Rare Key");
        meta.setLore(Collections.singletonList("Use to open a chest"));
        meta.getPersistentDataContainer().set(Keys.CUSTOM_KEY, PersistentDataType.BOOLEAN, true);

        chest.setItemMeta(meta);

        return new ItemStack(chest);
    }
    private ItemStack getAdminKey() {
        ItemStack chest = new ItemStack(Material.LIGHTNING_ROD, 30);
        ItemMeta meta = chest.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Admin Key");
        meta.setLore(Collections.singletonList("Use to customize lockables"));
        meta.getPersistentDataContainer().set(Keys.ADMIN_KEY, PersistentDataType.BOOLEAN, true);

        chest.setItemMeta(meta);

        return new ItemStack(chest);
    }
}
