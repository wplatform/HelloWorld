package com.github.mmo.game.map.grid;

import java.util.EnumSet;

public enum GridVisitOption {

   GRID_GAME_OBJECT,
   GRID_CREATURE,
   GRID_DYNAMIC_OBJECT,
   GRID_CORPSE,
   GRID_AREA_TRIGGER,
   GRID_SCENE_OBJECT,
   GRID_CONVERSATION,

   WORLD_PLAYER,
   WORLD_CREATURE,
   WORLD_CORPSE,
   WORLD_DYNAMIC_OBJECT;


   public static final EnumSet<GridVisitOption>  ALL_OBJECT  = EnumSet.allOf(GridVisitOption.class);

   public static final EnumSet<GridVisitOption> GRID_OBJECTS = EnumSet.of(
           GRID_GAME_OBJECT,
           GRID_CREATURE,
           GRID_DYNAMIC_OBJECT,
           GRID_CORPSE,
           GRID_AREA_TRIGGER,
           GRID_SCENE_OBJECT,
           GRID_CONVERSATION);


   public static final EnumSet<GridVisitOption>  WORLD_OBJECTS  = EnumSet.of(
           WORLD_PLAYER,
           WORLD_CREATURE,
           WORLD_CORPSE,
           WORLD_DYNAMIC_OBJECT);
    
}
