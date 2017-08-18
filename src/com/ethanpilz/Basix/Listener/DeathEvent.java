package com.ethanpilz.Basix.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

@SuppressWarnings("unused")

public class DeathEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getDamage() >= player.getHealth() && player.getKiller() != null){

                player.setLevel(0);

                Random random = new Random();
                int r = random.nextInt(4);

                String[] messages = new String[4];

                messages[0] = ChatColor.AQUA + player.getName() + ChatColor.RED + " was brutally slaughtered by " + ChatColor.DARK_RED + player.getKiller().getName();
                messages[1] = ChatColor.AQUA + player.getName() + ChatColor.RED + " had an bad encounter with " + ChatColor.DARK_RED + player.getKiller().getName();
                messages[2] = ChatColor.AQUA + player.getName() + ChatColor.RED + " made " + ChatColor.DARK_RED + player.getKiller().getName() + ChatColor.RED + " really angry.";
                messages[3] = ChatColor.AQUA + player.getName() + ChatColor.RED + " was sliced into pieces by " + ChatColor.DARK_RED + player.getKiller().getName();

                Bukkit.broadcastMessage(messages[r]);

            }
            else if (event.getDamage() >= player.getHealth()) {
                String item = player.getInventory().getItemInMainHand().getType().toString().toLowerCase();
                player.getInventory().clear();
                player.setLevel(0);

                if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " fell really far...");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " forgot how to breathe.");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.VOID) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ": " + ChatColor.RED + "checkmate scientists.");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " was that one in a million chance with lightning");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " tried to swim in something a little hotter than water.");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.WITHER) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " had a bad encounter with black magic.");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " was tired of trying to swim.");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.POISON) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " took the wrong kind of drugs.");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " got some boom boom.");
                }
                else if (event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FIRE) {
                    if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED +
                                " lost their " + item + " because they like to play with matches");
                    } else {
                        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.RED + " played with fire");
                    }
                } else {

                    String[] messages = new String[9];
                    messages[0] = ChatColor.AQUA + player.getName() + ChatColor.RED + " was broken into many pieces.";
                    messages[1] = ChatColor.AQUA + player.getName() + ChatColor.RED + " had an unfortunate encounter.";
                    messages[2] = ChatColor.AQUA + player.getName() + ChatColor.RED + " had a very bad time.";
                    messages[3] = ChatColor.AQUA + player.getName() + ChatColor.AQUA + "'s " + ChatColor.RED + "soul escaped.";
                    messages[4] = ChatColor.AQUA + player.getName() + ChatColor.RED + " did not have a peaceful ending.";
                    messages[5] = ChatColor.AQUA + player.getName() + ChatColor.RED + " doesn't know how to stay out of dangers way.";
                    messages[6] = ChatColor.AQUA + player.getName() + ChatColor.RED + " was naturally selected.";
                    messages[7] = ChatColor.AQUA + player.getName() + ChatColor.RED + " was never taught how to be careful.";
                    messages[8] = ChatColor.AQUA + player.getName() + ChatColor.RED + " did not respect the dangers of the world.";

                    Random random = new Random();
                    int r = random.nextInt(9);

                    Bukkit.broadcastMessage(messages[r]);
                }
            }

        }
    }
}