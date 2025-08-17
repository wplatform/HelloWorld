package com.github.azeroth.game.map.grid;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GridVisitors {


    public static GridVisitor OBJECT_GRID_EVACUATOR = (source) -> {
        if (source.isWorldObject()) {
            return GridVisitorResult.CONTINUE;
        }
        if (source.isCreature()) {
            // creature in unloading grid can have respawn point in another grid
            // if it will be unloaded then it will not respawn in original grid until unload/load original grid
            // move to respawn point to prevent this case. For player view in respawn grid this will be normal respawn.
            source.toCreature().getMap().creatureRespawnRelocation(source.toCreature(), true);
        } else if (source.isGameObject()) {
            // GameObject in unloading grid can have respawn point in another grid
            // if it will be unloaded then it will not respawn in original grid until unload/load original grid
            // move to respawn point to prevent this case. For player view in respawn grid this will be normal respawn.
            source.toGameObject().getMap().gameObjectRespawnRelocation(source.toGameObject(), true);
        }
        return GridVisitorResult.CONTINUE;
    };


    public static GridVisitor OBJECT_GRID_CLEANER = (source) -> {
        if (!source.isWorldObject()) {
            source.setDestroyedObject(true);
            source.cleanupsBeforeDelete();
            return GridVisitorResult.CONTINUE;
        }
        return GridVisitorResult.CONTINUE;
    };


    public static GridVisitor OBJECT_GRID_UN_LOADER = (source) -> {
        //Some creatures may summon other temp summons in CleanupsBeforeDelete()
        //So we need this even after cleaner (maybe we can remove cleaner)
        //Example: Flame Leviathan Turret 33139 is summoned when a creature is deleted
        /// @todo Check if that script has the correct logic. Do we really need to summons something before deleting?
        if (!source.isWorldObject()) {
            source.cleanupsBeforeDelete();
        }
        return GridVisitorResult.CONTINUE;
    };
}
