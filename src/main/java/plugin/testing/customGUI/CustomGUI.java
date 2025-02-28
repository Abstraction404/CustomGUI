package plugin.testing.customGUI;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.testing.customGUI.commands.CommandGUI;
import plugin.testing.customGUI.listeners.ListenerGUI;

import java.util.Objects;

public final class CustomGUI extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        Objects.requireNonNull(getCommand("customgui")).setExecutor(new CommandGUI());

        getServer().getPluginManager().registerEvents(new ListenerGUI(), this);
    }

    @Override
    public void onDisable()
    {

    }
}
