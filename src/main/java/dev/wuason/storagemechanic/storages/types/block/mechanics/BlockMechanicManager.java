package dev.wuason.storagemechanic.storages.types.block.mechanics;

import dev.wuason.storagemechanic.StorageMechanic;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class BlockMechanicManager {

    private Map<String, BlockMechanic> mechanics;
    private StorageMechanic core;

    public BlockMechanicManager(StorageMechanic core) {
        this.mechanics = new HashMap<>();
        this.core = core;
    }

    public void registerMechanic(BlockMechanic mechanic) {
        if(mechanic instanceof Listener) {
            Bukkit.getPluginManager().registerEvents((Listener) mechanic, core);
        }
        this.mechanics.put(mechanic.getId(), mechanic);
    }

    public void unregisterMechanic(String id) {
        this.mechanics.remove(id);
    }

    public BlockMechanic getMechanic(String id) {
        return this.mechanics.get(id);
    }

    public boolean mechanicExists(String id) {
        return this.mechanics.containsKey(id);
    }
}