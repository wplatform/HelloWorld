package com.github.azeroth.game.domain.areatrigger;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
@Getter
@RequiredArgsConstructor
public enum AreaTriggerCreatePropertiesFlag implements EnumFlag.FlagValue {
    NONE(0x00000),
    HAS_ABSOLUTE_ORIENTATION(0x00001),
    HAS_DYNAMIC_SHAPE(0x00002),
    HAS_ATTACHED(0x00004),
    HAS_FACE_MOVEMENT_DIR(0x00008),
    HAS_FOLLOWS_TERRAIN(0x00010), // NYI
    UNK1(0x00020),
    HAS_TARGET_ROLL_PITCH_YAW(0x00040), // NYI
    HAS_ANIM_ID(0x00080), // DEPRECATED
    UNK3(0x00100),
    HAS_ANIM_KIT_ID(0x00200), // DEPRECATED
    HAS_CIRCULAR_MOVEMENT(0x00400), // DEPRECATED
    UNK5(0x00800);


    public final int value;

}
