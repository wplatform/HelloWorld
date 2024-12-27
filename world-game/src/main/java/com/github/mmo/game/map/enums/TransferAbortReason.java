package com.github.mmo.game.map.enums;

public enum TransferAbortReason {
    TRANSFER_ABORT_NONE                          ,
    TRANSFER_ABORT_ERROR                         ,
    TRANSFER_ABORT_MAX_PLAYERS                   ,   // Transfer Aborted: instance is full
    TRANSFER_ABORT_NOT_FOUND                     ,   // Transfer Aborted: instance not found
    TRANSFER_ABORT_TOO_MANY_INSTANCES            ,   // You have entered too many instances recently.
    TRANSFER_ABORT_ZONE_IN_COMBAT                ,   // Unable to zone in while an encounter is in progress.
    TRANSFER_ABORT_INSUF_EXPAN_LVL               ,   // You must have <TBC, WotLK> expansion installed to access this area.
    TRANSFER_ABORT_DIFFICULTY                    ,   // <NORMAL, Heroic, Epic> difficulty mode is not available for %s.
    TRANSFER_ABORT_UNIQUE_MESSAGE                ,   // Until you've escaped TLK's grasp, you cannot leave this place!
    TRANSFER_ABORT_TOO_MANY_REALM_INSTANCES      ,   // Additional instances cannot be launched, please try again later.
    TRANSFER_ABORT_NEED_GROUP                    ,   // Transfer Aborted: you must be in a raid group to enter this instance
    TRANSFER_ABORT_NOT_FOUND_2                   ,   // Transfer Aborted: instance not found
    TRANSFER_ABORT_NOT_FOUND_3                   ,   // Transfer Aborted: instance not found
    TRANSFER_ABORT_NOT_FOUND_4                   ,   // Transfer Aborted: instance not found
    TRANSFER_ABORT_REALM_ONLY                    ,   // All players in the party must be from the same realm to enter %s.
    TRANSFER_ABORT_MAP_NOT_ALLOWED               ,   // Map cannot be entered at this time.
    TRANSFER_ABORT_LOCKED_TO_DIFFERENT_INSTANCE  ,   // You are already locked to %s
    TRANSFER_ABORT_ALREADY_COMPLETED_ENCOUNTER   ,   // You are ineligible to participate in at least one encounter in this instance because you are already locked to an instance in which it has been defeated.
    TRANSFER_ABORT_DIFFICULTY_NOT_FOUND          ,   // client writes to console "Unable to resolve requested difficultyID %u to actual difficulty for map %d"
    TRANSFER_ABORT_XREALM_ZONE_DOWN              ,   // Transfer Aborted: cross-realm zone is down
    TRANSFER_ABORT_SOLO_PLAYER_SWITCH_DIFFICULTY ,   // This instance is already in progress. You may only switch difficulties from inside the instance.
    TRANSFER_ABORT_NOT_CROSS_FACTION_COMPATIBLE  ,   // This instance isn't available for cross-faction groups
}
