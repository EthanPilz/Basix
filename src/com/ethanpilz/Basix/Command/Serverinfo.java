package com.ethanpilz.Basix.Command;

import com.ethanpilz.Basix.Basix;
import com.ethanpilz.Basix.Runnable.Lag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Serverinfo implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("basix.serverinfo") || sender.hasPermission("basix.*")){
            sender.sendMessage(Basix.basixprefix + ChatColor.GOLD + "Server version - " + ChatColor.AQUA + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3]);
            sender.sendMessage(Basix.basixprefix + ChatColor.GOLD + "TPS - " + ChatColor.AQUA + Lag.getTPS());
            sender.sendMessage(Basix.basixprefix + ChatColor.GOLD + "Total memory - " + ChatColor.GREEN + (Runtime.getRuntime().totalMemory()/1024/1024) + " MB");
            sender.sendMessage(Basix.basixprefix + ChatColor.GOLD + "Free memory - " + ChatColor.GREEN + (Runtime.getRuntime().freeMemory()/1024/1024) + " MB");
            sender.sendMessage(Basix.basixprefix + ChatColor.GOLD + "Worlds - " + ChatColor.GREEN + Bukkit.getServer().getWorlds().size());
            for(World world : Bukkit.getWorlds()) {
                sender.sendMessage(Basix.basixprefix + ChatColor.GOLD + "World names - " + world.getName());
            }
        } else {
            sender.sendMessage(Basix.noPermission);
        }
        return true;
    }
}
