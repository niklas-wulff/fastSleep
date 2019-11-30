package de.high_ping.fastsleep.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedLeaveListener implements Listener {

    @EventHandler
    public void onBedEnter(PlayerBedLeaveEvent event){
        if(BedEnterListener.sleeping != 0){
            BedEnterListener.sleeping--;
        }
    }
}
