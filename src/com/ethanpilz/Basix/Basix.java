package com.ethanpilz.Basix;

import com.ethanpilz.Basix.Command.Serverinfo;
import com.ethanpilz.Basix.Command.Spycommand;
import com.ethanpilz.Basix.Command.Troll;
import com.ethanpilz.Basix.Listener.DeathEvent;
import com.ethanpilz.Basix.Runnable.Lag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Basix extends JavaPlugin {

    public static final String noPermission = ChatColor.RED + "You don't have permission to access this command.";
    public static final String invalidPlayer = ChatColor.RED + "Invalid Player";
    public static final String noConsole = ChatColor.RED + "You have to be a player in-game to execute this command.";
    public static final String basixprefix = ChatColor.DARK_RED + "[B] " + ChatColor.WHITE;

    public static final String pluginName = "Basix";
    public static final String pluginVersion = "1.0";
    private static final String consolePrefix = "[Basix] ";
    private static Basix instance;
    private static final Logger log = Logger.getLogger("Minecraft");

    public void onEnable()
    {
        //Variables
        this.instance = this;

        //Register Listeners
        Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(), this);

        //Register commands
        getCommand("spy").setExecutor(new Spycommand());
        getCommand("troll").setExecutor(new Troll());
        getCommand("serverinfo").setExecutor(new Serverinfo());

        //Lag.java enable
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);

        Basix.log.log(Level.INFO, Basix.consolePrefix + "Startup is complete.");
    }

}

