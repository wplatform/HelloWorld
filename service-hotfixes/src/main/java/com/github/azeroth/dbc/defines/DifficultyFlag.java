package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum DifficultyFlag implements EnumFlag.FlagValue {
    HEROIC_STYLE_LOCKOUTS(0x01),
    DEFAULT(0x02),
    CAN_SELECT(0x04), // Player can select this difficulty in dropdown menu
    //CHALLENGE_MODE        (0x08), // deprecated since Legion expansion
    LFG_ONLY(0x10),
    LEGACY(0x20),
    DISPLAY_HEROIC(0x40), // Controls icon displayed on minimap when inside the instance
    DISPLAY_MYTHIC(0x80);  // Controls icon displayed on minimap when inside the instance
    public final int value;
}
