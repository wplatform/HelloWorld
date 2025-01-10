package com.github.azeroth.game.domain.misc;


public class SkillTiersEntry {
    public static final byte MAX_SKILL_STEP = 16;
    public int id;
    public int[] value = new int[MAX_SKILL_STEP];
}
