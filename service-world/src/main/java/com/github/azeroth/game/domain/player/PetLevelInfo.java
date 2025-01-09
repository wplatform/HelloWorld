package com.github.azeroth.game.domain.player;


import com.github.azeroth.defines.SharedDefine;

public class PetLevelInfo {
    public int[] stats = new int[SharedDefine.MAX_STATS];
    public int health;
    public int mana;
    public int armor;
}
