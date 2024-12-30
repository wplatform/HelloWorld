package com.github.mmo.game.spell;


public class SpellLearnSkillNode {
    public skillType skill = SkillType.values()[0];
    public short step;
    public short value; // 0  - max skill value for player level
    public short maxvalue; // 0  - max skill value for player level
}
