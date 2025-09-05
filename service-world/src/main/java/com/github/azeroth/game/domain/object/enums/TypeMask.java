package com.github.azeroth.game.domain.object.enums;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TypeMask implements EnumFlag.FlagValue {

    OBJECT(0x0001),
    ITEM(0x0002),
    CONTAINER(0x0004),
    UNIT(0x0008),
    PLAYER(0x0010),
    GAME_OBJECT(0x0020),
    DYNAMIC_OBJECT(0x0040),
    CORPSE(0x0080),
    AREA_TRIGGER(0x0100),
    SCENE_OBJECT(0x0200),
    CONVERSATION(0x0400),
    SEER(PLAYER.value | UNIT.value | DYNAMIC_OBJECT.value),
    WORLD_OBJECT(UNIT.value | GAME_OBJECT.value | DYNAMIC_OBJECT.value | CORPSE.value | AREA_TRIGGER.value | SCENE_OBJECT.value | CONVERSATION.value);

    public final int value;

}
