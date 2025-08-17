package com.github.azeroth.game.domain.object;

import com.github.azeroth.game.domain.map.MapDefine;



public interface ObjectDefine {

    float CONTACT_DISTANCE = 0.5f;
    float INTERACTION_DISTANCE = 5.0f;
    float ATTACK_DISTANCE = 5.0f;
    float INSPECT_DISTANCE = 28.0f;
    float TRADE_DISTANCE = 11.11f;
    float MAX_VISIBILITY_DISTANCE = MapDefine.SIZE_OF_GRIDS;           // max distance for visible objects
    float SIGHT_RANGE_UNIT = 50.0f;
    float VISIBILITY_DISTANCE_GIGANTIC = 400.0f;
    float VISIBILITY_DISTANCE_LARGE = 200.0f;
    float VISIBILITY_DISTANCE_NORMAL = 100.0f;
    float VISIBILITY_DISTANCE_SMALL = 50.0f;
    float VISIBILITY_DISTANCE_TINY = 25.0f;
    float DEFAULT_VISIBILITY_DISTANCE = VISIBILITY_DISTANCE_NORMAL; // default visible distance, 100 yards on continents
    float[] VISIBILITY_DISTANCES = {
            DEFAULT_VISIBILITY_DISTANCE,
            VISIBILITY_DISTANCE_TINY,
            VISIBILITY_DISTANCE_SMALL,
            VISIBILITY_DISTANCE_LARGE,
            VISIBILITY_DISTANCE_GIGANTIC,
            MAX_VISIBILITY_DISTANCE
    };
    float DEFAULT_VISIBILITY_INSTANCE = 170.0f;                  // default visible distance in instances, 170 yards
    float DEFAULT_VISIBILITY_BG_ARENAS = 533.0f;                  // default visible distance in BG/Arenas, roughly 533 yards
    float DEFAULT_PLAYER_BOUNDING_RADIUS = 0.388999998569489f;     // player size, also currently used (correctly?) for any non Unit world objects
    float DEFAULT_PLAYER_COMBAT_REACH = 1.5f;
    float DEFAULT_PLAYER_DISPLAY_SCALE = 1.0f;
    float DEFAULT_PLAYER_HOVER_HEIGHT = 1.0f;
    float MIN_MELEE_REACH = 2.0f;
    float NOMINAL_MELEE_RANGE = 5.0f;
    float MELEE_RANGE = (NOMINAL_MELEE_RANGE - MIN_MELEE_REACH * 2); //center to center for players
    // We need in some cases increase search radius. Allow to find creatures with huge combat reach in a different nearby cell.
    float EXTRA_CELL_SEARCH_RADIUS = 40.0f;
    int ATTACK_DISPLAY_DELAY = 200;
    // max distance for detection targets by player
    float MAX_PLAYER_STEALTH_DETECT_RANGE = 30.0f;
    int VISUAL_WAYPOINT = 1; // Creature Entry ID used for waypoints show, visible only for GMs
    int WORLD_TRIGGER = 12999;
    int ARTIFACTS_ALL_WEAPONS_GENERAL_WEAPON_EQUIPPED_PASSIVE = 197886;
    int SPELL_DH_DOUBLE_JUMP = 196055;
    int DISPLAY_ID_HIDDEN_MOUNT = 73200;
    int WAR_MODE_ENLISTED_SPELL_OUTSIDE = 269083;
    int MAX_AGGRO_RESET_TIME = 10; // in seconds
    float MAX_AGGRO_RADIUS = 45.0f;  // yards

}