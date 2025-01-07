package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GameObjectFlag implements EnumFlag.FlagValue {
    IN_USE(0x00000001), // disables interaction while animated
    LOCKED(0x00000002), // require key, spell, event, etc to be opened. Makes "Locked" appear in tooltip
    INTERACT_COND(0x00000004), // cannot interact (condition to interact - requires GO_DYNFLAG_LO_ACTIVATE to enable interaction clientside)
    TRANSPORT(0x00000008), // any kind of transport? Object can transport (elevator, boat, car)
    NOT_SELECTABLE(0x00000010), // not selectable even in GM mode
    NODESPAWN(0x00000020), // never despawn, typically for doors, they just change state
    AI_OBSTACLE(0x00000040), // makes the client register the object in something called AIObstacleMgr, unknown what it does
    FREEZE_ANIMATION(0x00000080),

    // for object types GAMEOBJECT_TYPE_GARRISON_BUILDING, GAMEOBJECT_TYPE_GARRISON_PLOT and GAMEOBJECT_TYPE_PHASEABLE_MO flag bits 8 to 12 are used as WMOAreaTable::NameSetID
    DAMAGED(0x00000200),
    DESTROYED(0x00000400),

    IGNORE_CURRENT_STATE_FOR_USE_SPELL(0x00004000), // Allows casting use spell without checking current state (opening open gameobjects, unlocking unlocked gameobjects and closing closed gameobjects)
    INTERACT_DISTANCE_IGNORES_MODEL(0x00008000), // Client completely ignores model bounds for interaction distance check
    IGNORE_CURRENT_STATE_FOR_USE_SPELL_EXCEPT_UNLOCKED(0x00040000), // Allows casting use spell without checking current state except unlocking unlocked gamobjets (opening open gameobjects and closing closed gameobjects)
    INTERACT_DISTANCE_USES_TEMPLATE_MODEL(0x00080000), // client checks interaction distance from model sent in SMSG_QUERY_GAMEOBJECT_RESPONSE instead of GAMEOBJECT_DISPLAYID
    MAP_OBJECT(0x00100000), // pre-7.0 model loading used to be controlled by file extension (wmo vs m2)
    IN_MULTI_USE(0x00200000), // IN_USE equivalent for objects usable by multiple players
    LOW_PRIORITY_SELECTION(0x04000000); // client will give lower cursor priority to this object when multiple objects overlap
    public final int value;
}
