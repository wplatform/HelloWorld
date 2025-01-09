package com.github.azeroth.game.domain.player;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerCreateInfoAction {
    public byte button;
    private byte type;
    private int action;

}
