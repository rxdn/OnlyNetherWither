package io.github.rxdn.onlynetherwither;

import org.bukkit.World;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OnlyNetherWither extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        if (!(e.getEntity() instanceof Wither)) {
            return;
        }

        if (e.getLocation().getWorld().getEnvironment() != World.Environment.NETHER) {
            e.setCancelled(true);
        }
    }
}
