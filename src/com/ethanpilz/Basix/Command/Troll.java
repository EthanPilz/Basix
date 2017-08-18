package com.ethanpilz.Basix.Command;

import com.ethanpilz.Basix.Basix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.InputMismatchException;

public class Troll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender.hasPermission("basix.*") || sender.hasPermission("basix.troll")) {
            //spy [playerName]
            if (args.length == 2) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    try {
                        int number = Integer.parseInt(args[1]);
                        Player p2 = Bukkit.getPlayer(args[0]);

                        for(int i = 0 ; i<number ; i++){
                            p2.getWorld().spawnEntity(p2.getLocation(), EntityType.CREEPER);
                        }

                        sender.sendMessage(Basix.basixprefix + "Creeper spawned at " + p2.getName() + "'s location.");

                    } catch (InputMismatchException exception) {

                        sender.sendMessage("You need to enter a number.");
                    }
                }
                else {
                    //The player is not online
                    sender.sendMessage(Basix.invalidPlayer);
                }
            }
            else {
                sender.sendMessage(Basix.basixprefix + ChatColor.RED + "Correct format - /troll (player) (number of creepers)");
                //No player not provided
            }
        }
        else {
            sender.sendMessage(Basix.noPermission);
            //No Permissions
        }

        return true;
    }
}

