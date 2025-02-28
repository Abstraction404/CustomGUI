package plugin.testing.customGUI.customgui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class MenuGUI
{
    final private int invSize = 27;

    public MenuGUI(Player target)
    {
        Inventory inventory = Bukkit.createInventory(null, invSize, "Player Menu");

        //Heal item
        ItemStack healItem = new ItemStack(Material.GREEN_WOOL, 1);
        ItemMeta healItemMeta = healItem.getItemMeta();
        healItemMeta.setItemName(ChatColor.GREEN + "Heal player");
        healItemMeta.setLore(List.of(ChatColor.GOLD + "Heals back to full HP and hunger."));
        healItemMeta.setEnchantmentGlintOverride(true);
        healItem.setItemMeta(healItemMeta);

        //Ingot item
        ItemStack giveItem = new ItemStack(Material.NETHERITE_INGOT, 1);
        ItemMeta giveItemMeta = giveItem.getItemMeta();
        giveItemMeta.setDisplayName(ChatColor.GRAY + "Give ingots");
        giveItemMeta.setLore(List.of(ChatColor.GOLD + "Gives a stack of netherite ingots."));
        giveItemMeta.setEnchantmentGlintOverride(true);
        giveItem.setItemMeta(giveItemMeta);

        //Profile item
        ItemStack headItem = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta headItemMeta = (SkullMeta) headItem.getItemMeta();
        headItemMeta.setOwningPlayer(Bukkit.getOfflinePlayer(target.getUniqueId()));
        headItemMeta.setDisplayName(ChatColor.RESET + "" + ChatColor.GOLD + ChatColor.BOLD +
                target.getDisplayName() + "'s profile");
        headItemMeta.setLore(List.of(ChatColor.GOLD + "Shows basic player information."));
        headItemMeta.setEnchantmentGlintOverride(true);
        headItem.setItemMeta(headItemMeta);

        //Summon item
        ItemStack summonItem = new ItemStack(Material.WARDEN_SPAWN_EGG, 1);
        ItemMeta summonItemMeta = summonItem.getItemMeta();
        summonItemMeta.setDisplayName(ChatColor.AQUA + "Summon entity");
        summonItemMeta.setLore(List.of(ChatColor.RED + "Use with caution in survival."));
        summonItemMeta.setEnchantmentGlintOverride(true);
        summonItem.setItemMeta(summonItemMeta);

        //Filler item
        ItemStack fillerItem = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta fillerItemMeta = fillerItem.getItemMeta();
        fillerItemMeta.setItemName(ChatColor.RESET + " ");
        fillerItem.setItemMeta(fillerItemMeta);

        inventory.setItem(4, headItem);
        inventory.setItem(12, healItem);
        inventory.setItem(14, giveItem);
        inventory.setItem(22, summonItem);

        for (int slot = 0; slot < invSize; slot++)
        {
            ItemStack invItem = inventory.getItem(slot);

            if (invItem == null || invItem.getType() == Material.AIR)
            {
                inventory.setItem(slot, fillerItem);
            }
        }

        target.openInventory(inventory);
    }


}
