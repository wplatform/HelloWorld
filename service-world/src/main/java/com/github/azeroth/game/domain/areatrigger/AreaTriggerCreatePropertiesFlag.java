package com.github.azeroth.game.domain.areatrigger;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
@Getter
@RequiredArgsConstructor
public enum AreaTriggerCreatePropertiesFlag implements EnumFlag.FlagValue {
    NONE(0x00000),
    ABSOLUTE_ORIENTATION(0x00001),
    DYNAMIC_SHAPE(0x00002),
    ATTACHED(0x00004),
    FACE_MOVEMENT_DIR(0x00008),
    FOLLOWS_TERRAIN(0x00010), // NYI
    UNK1(0x00020),
    TARGET_ROLL_PITCH_YAW(0x00040), // NYI
    ANIM_ID(0x00080), // DEPRECATED
    VISUAL_ANIM_IS_DECAY(0x00100),
    ANIM_KIT_ID(0x00200), // DEPRECATED
    CIRCULAR_MOVEMENT(0x00400), // DEPRECATED
    UNK5(0x00800);


    public final int value;

}
