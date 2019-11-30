package de.high_ping.fastsleep.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class BedEnterListener implements Listener {
    public static int sleeping = 0;

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (Bukkit.getWorld(player.getWorld().getName()).getTime() <= 12000) {
            player.sendMessage("§9Sleeping §8| §7Damit du schlafen kannst, muss es Nacht sein!");
            player.sendTitle("§cDu kannst noch nicht schlafen!", "§7Es muss Nacht sein.", 4, 40, 4);
        } else {
            sleeping++;
            int online = Bukkit.getOnlinePlayers().size();
            if(online - sleeping == online/2){
                Bukkit.getWorld(player.getWorld().getName()).setTime(0);
                Bukkit.broadcastMessage("§9Sleeping §8| §7Es wurde Tag, da sich §650% §7der Spieler hingelegt haben.");
                int test = online-sleeping;
                if(test == 0){
                    Bukkit.broadcastMessage("§9Sleeping §8| §7Es wurde Tag, da §650% §7der Spieler geschlafen haben.");
                }
                sleeping = 0;
            } else {
                int test = online-sleeping;
                if(test == 2){
                    Bukkit.broadcastMessage("§9Sleeping §8| §7Damit es Tag wird muss sich noch §6" + "1" + " §7Spieler ins Bett legen.");
                } else if(test >= 3){
                    int test_ = test-1;
                    Bukkit.broadcastMessage("§9Sleeping §8| §7Damit es Tag wird müssen sich noch §6" + test_ + " §7Spieler ins Bett legen.");
                } else {
                    Bukkit.broadcastMessage("§9Sleeping §8| §cError");
                }

            }
        }


    }
}

