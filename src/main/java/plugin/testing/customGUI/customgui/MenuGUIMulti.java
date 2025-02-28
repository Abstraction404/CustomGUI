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

public class MenuGUIMulti
{
    final private int invSize = 27;

    final public Inventory p1 = Bukkit.createInventory(null, invSize, "Player Menu");
    final public Inventory p2 = Bukkit.createInventory(null, invSize, "Gamemodes");

    public MenuGUIMulti(Player target)
    {
        //Back item
        ItemStack backItem = new ItemStack(Material.REPEATER, 1);
        ItemMeta backItemMeta = backItem.getItemMeta();
        backItemMeta.setDisplayName(ChatColor.YELLOW + "Previous page");
        backItemMeta.setEnchantmentGlintOverride(true);
        backItem.setItemMeta(backItemMeta);

        //Forward item
        ItemStack forwardItem = new ItemStack(Material.COMPARATOR, 1);
        ItemMeta forwardItemMeta = forwardItem.getItemMeta();
        forwardItemMeta.setDisplayName(ChatColor.YELLOW + "Next page");
        forwardItemMeta.setEnchantmentGlintOverride(true);
        forwardItem.setItemMeta(forwardItemMeta);

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

        //Creative item
        ItemStack creativeItem = new ItemStack(Material.COMMAND_BLOCK, 1);
        ItemMeta creativeItemMeta = creativeItem.getItemMeta();
        creativeItemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Creative Mode");
        creativeItemMeta.setLore(List.of(ChatColor.GOLD + "Change gamemode to creative"));
        creativeItemMeta.setEnchantmentGlintOverride(true);
        creativeItem.setItemMeta(creativeItemMeta);

        //Survival item
        ItemStack survivalItem = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta survivalItemMeta = survivalItem.getItemMeta();
        survivalItemMeta.setDisplayName(ChatColor.YELLOW + "Survival Mode");
        survivalItemMeta.setLore(List.of(ChatColor.GOLD + "Change gamemode to survival"));
        survivalItemMeta.setEnchantmentGlintOverride(true);
        survivalItem.setItemMeta(survivalItemMeta);

        //Adventure item
        ItemStack adventureItem = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta adventureItemMeta = adventureItem.getItemMeta();
        adventureItemMeta.setDisplayName(ChatColor.RED + "Adventure Mode");
        adventureItemMeta.setLore(List.of(ChatColor.GOLD + "Change gamemode to adventure"));
        adventureItemMeta.setEnchantmentGlintOverride(true);
        adventureItem.setItemMeta(adventureItemMeta);

        //Spectator item
        ItemStack spectatorItem = new ItemStack(Material.SPYGLASS, 1);
        ItemMeta spectatorItemMeta = spectatorItem.getItemMeta();
        spectatorItemMeta.setDisplayName(ChatColor.AQUA + "Spectator Mode");
        spectatorItemMeta.setLore(List.of(ChatColor.GOLD + "Change gamemode to spectator"));
        spectatorItemMeta.setEnchantmentGlintOverride(true);
        spectatorItem.setItemMeta(spectatorItemMeta);

        p1.setItem(4, headItem);
        p1.setItem(12, healItem);
        p1.setItem(14, giveItem);
        p1.setItem(17, forwardItem);
        p1.setItem(22, summonItem);

        p2.setItem(4, creativeItem);
        p2.setItem(9, backItem);
        p2.setItem(12, survivalItem);
        p2.setItem(14, adventureItem);
        p2.setItem(22, spectatorItem);

        for (int slot = 0; slot < invSize; slot++)
        {
            ItemStack invItemP1 = p1.getItem(slot);
            ItemStack invItemP2 = p2.getItem(slot);

            if (invItemP1 == null || invItemP1.getType() == Material.AIR)
            {
                p1.setItem(slot, fillerItem);
            }

            if (invItemP2 == null || invItemP2.getType() == Material.AIR)
            {
                p2.setItem(slot, fillerItem);
            }
        }

        //target.openInventory(p1);
    }


}
