package com.github.azeroth.game.map.enums;

public enum TransferAbortReason {
    NONE,
    ERROR,
    MAX_PLAYERS,   // Transfer Aborted: instance is full
    NOT_FOUND,   // Transfer Aborted: instance not found
    TOO_MANY_INSTANCES,   // You have entered too many instances recently.
    ZONE_IN_COMBAT,   // Unable to zone in while an encounter is in progress.
    INSUF_EXPAN_LVL,   // You must have <TBC, WotLK> expansion installed to access this area.
    DIFFICULTY,   // <NORMAL, Heroic, Epic> difficulty mode is not available for %s.
    UNIQUE_MESSAGE,   // Until you've escaped TLK's grasp, you cannot leave this place!
    TOO_MANY_REALM_INSTANCES,   // Additional instances cannot be launched, please try again later.
    NEED_GROUP,   // Transfer Aborted: you must be in a raid group to enter this instance
    NOT_FOUND_2,   // Transfer Aborted: instance not found
    NOT_FOUND_3,   // Transfer Aborted: instance not found
    NOT_FOUND_4,   // Transfer Aborted: instance not found
    REALM_ONLY,   // All players in the party must be from the same realm to enter %s.
    MAP_NOT_ALLOWED,   // Map cannot be entered at this time.
    LOCKED_TO_DIFFERENT_INSTANCE,   // You are already locked to %s
    ALREADY_COMPLETED_ENCOUNTER,   // You are ineligible to participate in at least one encounter in this instance because you are already locked to an instance in which it has been defeated.
    DIFFICULTY_NOT_FOUND,   // client writes to console "Unable to resolve requested difficultyID %u to actual difficulty for map %d"
    XREALM_ZONE_DOWN,   // Transfer Aborted: cross-realm zone is down
    SOLO_PLAYER_SWITCH_DIFFICULTY,   // This instance is already in progress. You may only switch difficulties from inside the instance.
    NOT_CROSS_FACTION_COMPATIBLE,   // This instance isn't available for cross-faction groups
}
