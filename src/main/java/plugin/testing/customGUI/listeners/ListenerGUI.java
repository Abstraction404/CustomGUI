package plugin.testing.customGUI.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import plugin.testing.customGUI.customgui.MenuGUIMulti;

import java.util.Objects;

public class ListenerGUI implements Listener
{
    @EventHandler
    public void onInventoryClickP1(InventoryClickEvent event)
    {
        boolean c1 = event.getView().getTitle().equals("Player Menu");

        if (!c1)
        {
            return;
        }

        event.setCancelled(true);

        Player target = (Player) event.getWhoClicked();

        MenuGUIMulti menuGUIMulti = new MenuGUIMulti(target);

        switch (Objects.requireNonNull(event.getCurrentItem()).getType()) {
            case GREEN_WOOL:
                target.setHealth(20);
                target.setFoodLevel(20);
                target.sendMessage(ChatColor.GREEN + "Target healed.");
                break;
            case NETHERITE_INGOT:
                target.getInventory().addItem(
                        new ItemStack(Material.NETHERITE_INGOT, 64)
                );
                target.sendMessage(ChatColor.GREEN + "64 netherite ingots given to target.");
                break;
            case PLAYER_HEAD:
                target.sendMessage(ChatColor.GOLD + "Name: " + ChatColor.AQUA +
                        target.getName() + ChatColor.GOLD + " || Health: " +
                        ChatColor.GREEN + String.valueOf(target.getHealth()) +
                        ChatColor.GOLD + " || Hunger: " + ChatColor.YELLOW +
                        String.valueOf(target.getFoodLevel()) + ChatColor.GOLD +
                        " || Ping: " + ChatColor.LIGHT_PURPLE + String.valueOf(target.getPing()));
                break;
            case WARDEN_SPAWN_EGG:
                target.getWorld().spawnEntity(target.getLocation(), EntityType.WARDEN);
                target.sendMessage(ChatColor.AQUA + "Spawned entity at target's location.");
                break;
            case COMPARATOR:
                target.openInventory(menuGUIMulti.p2);
                break;
            default:
                break;
        }


    }

    @EventHandler
    public void onInventoryClickP2(InventoryClickEvent event)
    {
        boolean c2 = event.getView().getTitle().equals("Gamemodes");

        if (!c2)
        {
            return;
        }

        event.setCancelled(true);

        Player target = (Player) event.getWhoClicked();

        MenuGUIMulti menuGUIMulti = new MenuGUIMulti(target);

        switch (Objects.requireNonNull(event.getCurrentItem()).getType()) {
            case COMMAND_BLOCK:
                target.setGameMode(GameMode.CREATIVE);
                target.sendMessage(ChatColor.LIGHT_PURPLE + "Changed gamemode to creative.");
                break;
            case IRON_AXE:
                target.setGameMode(GameMode.SURVIVAL);
                target.sendMessage(ChatColor.YELLOW + "Changed gamemode to survival.");
                break;
            case WRITABLE_BOOK:
                target.setGameMode(GameMode.ADVENTURE);
                target.sendMessage(ChatColor.RED + "Changed gamemode to adventure.");
                break;
            case SPYGLASS:
                target.setGameMode(GameMode.SPECTATOR);
                target.sendMessage(ChatColor.AQUA + "Changed gamemode to spectator");
                break;
            case REPEATER:
                target.openInventory(menuGUIMulti.p1);
                break;
            case COMPARATOR:
                target.openInventory(menuGUIMulti.p2);
                break;
            default:
                break;
        }

    }
}
