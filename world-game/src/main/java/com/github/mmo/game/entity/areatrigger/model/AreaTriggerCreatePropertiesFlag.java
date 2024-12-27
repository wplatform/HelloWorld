package com.github.mmo.game.entity.areatrigger.model;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
@Getter
@RequiredArgsConstructor
public enum AreaTriggerCreatePropertiesFlag implements EnumFlag.FlagValue {
    None(0x00000),
    HasAbsoluteOrientation(0x00001),
    HasDynamicShape(0x00002),
    HasAttached(0x00004),
    HasFaceMovementDir(0x00008),
    HasFollowsTerrain(0x00010), // NYI
    Unk1(0x00020),
    HasTargetRollPitchYaw(0x00040), // NYI
    HasAnimId(0x00080), // DEPRECATED
    Unk3(0x00100),
    HasAnimKitId(0x00200), // DEPRECATED
    HasCircularMovement(0x00400), // DEPRECATED
    Unk5(0x00800);


    public final int value;

}
