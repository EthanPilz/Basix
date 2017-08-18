package com.ethanpilz.Basix.Command;

import com.ethanpilz.Basix.Basix;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Spycommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender.hasPermission("basix.*") || sender.hasPermission("basix.spy")) {
            //spy [playerName]
            if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    //Player was found

                    if (sender instanceof Player) {
                        //Sender is a player

                        Player p1 = (Player) sender;
                        Player p2 = Bukkit.getPlayer(args[0]);

                        p1.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 1));
                        p1.getInventory().addItem(new ItemStack(Material.MILK_BUCKET,1));
                        p1.teleport(p2.getLocation());
                        sender.sendMessage(Basix.basixprefix + "Spying on " + p2.getName());
                    }
                    else {
                        sender.sendMessage(Basix.noConsole);
                        //Console sender sent it
                    }
                }
                else {
                    //The player is not online
                    sender.sendMessage(Basix.invalidPlayer);
                }
            }
            else {
                sender.sendMessage(Basix.invalidPlayer);
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
