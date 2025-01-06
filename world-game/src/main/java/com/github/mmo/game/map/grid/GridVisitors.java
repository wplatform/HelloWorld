package com.github.mmo.game.map.grid;

import com.github.mmo.game.entity.object.WorldObject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Iterator;
import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GridVisitors {


    public static Consumer<GridRefManager<? extends WorldObject>> OBJECT_GRID_EVACUATOR = (refManager) -> {
        for (WorldObject o : refManager) {
            if (o.isCreature()) {
                // creature in unloading grid can have respawn point in another grid
                // if it will be unloaded then it will not respawn in original grid until unload/load original grid
                // move to respawn point to prevent this case. For player view in respawn grid this will be normal respawn.
                o.toCreature().getMap().creatureRespawnRelocation(o.toCreature(), true);
            } else if (o.isGameObject()) {
                // GameObject in unloading grid can have respawn point in another grid
                // if it will be unloaded then it will not respawn in original grid until unload/load original grid
                // move to respawn point to prevent this case. For player view in respawn grid this will be normal respawn.
                o.toGameObject().getMap().gameObjectRespawnRelocation(o.toGameObject(), true);
            } else {
                throw new RuntimeException("ObjectGridRespawnMover must not be called for " + o.getTypeId());
            }
        }
    };


    public static Consumer<GridRefManager<? extends WorldObject>> OBJECT_GRID_CLEANER = (refManager) -> {
        for (WorldObject o : refManager) {
            o.setDestroyedObject(true);
            o.cleanupsBeforeDelete();
        }
    };


    public static Consumer<GridRefManager<? extends WorldObject>> OBJECT_GRID_UN_LOADER = (refManager) -> {
        Iterator<? extends WorldObject> iterator = refManager.iterator();
        while (iterator.hasNext()) {
            WorldObject o = iterator.next();
            //Some creatures may summon other temp summons in CleanupsBeforeDelete()
            //So we need this even after cleaner (maybe we can remove cleaner)
            //Example: Flame Leviathan Turret 33139 is summoned when a creature is deleted
            /// @todo Check if that script has the correct logic. Do we really need to summons something before deleting?
            o.cleanupsBeforeDelete();
            iterator.remove();
        }
    };
}
