package plugin.testing.customGUI.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.testing.customGUI.customgui.MenuGUI;
import plugin.testing.customGUI.customgui.MenuGUIMulti;

public class CommandGUI implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String s, String[] args)
    {
        //Checks whether the sender is a Player or not
        if(!(sender instanceof Player player))
        {
            sender.sendMessage(ChatColor.RED + "The command sender isn't a player.");
            return true;
        }

        //Checks whether inputted parameters are exactly 1 or not
        //For player name
        if(args.length != 1)
        {
            player.sendMessage(ChatColor.RED + "Syntax: /customgui <playername>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        //Checks whether the inputted player name exists on the server or not
        if(target == null)
        {
            player.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        //new MenuGUI(target);
        target.openInventory(new MenuGUIMulti(target).p1);

        return true;
    }
}
