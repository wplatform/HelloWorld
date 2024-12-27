package com.github.mmo.game.entity.player.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public
enum ActionButtonType {
    SPELL(0x00),
    C(0x01),                         // click?
    EQSET(0x20),
    DROPDOWN(0x30),
    MACRO(0x40),
    CMACRO(C.value | MACRO.value),
    COMPANION(0x50),
    MOUNT(0x60),
    ITEM(0x80);
    public final int value;
}
