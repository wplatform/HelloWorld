package com.github.azeroth.game.entity.creature;


public class TrainerSpell {
    private int spellId;
    private int moneyCost;
    private int reqSkillLine;
    private int reqSkillRank;
    private Array<Integer> reqAbility = new Array<Integer>(3);
    private byte reqLevel;

    public final int getSpellId() {
        return spellId;
    }

    public final void setSpellId(int value) {
        spellId = value;
    }

    public final int getMoneyCost() {
        return moneyCost;
    }

    public final void setMoneyCost(int value) {
        moneyCost = value;
    }

    public final int getReqSkillLine() {
        return reqSkillLine;
    }

    public final void setReqSkillLine(int value) {
        reqSkillLine = value;
    }

    public final int getReqSkillRank() {
        return reqSkillRank;
    }

    public final void setReqSkillRank(int value) {
        reqSkillRank = value;
    }

    public final Array<Integer> getReqAbility() {
        return reqAbility;
    }

    public final void setReqAbility(Array<Integer> value) {
        reqAbility = value;
    }

    public final byte getReqLevel() {
        return reqLevel;
    }

    public final void setReqLevel(byte value) {
        reqLevel = value;
    }

    public final boolean isCastable() {
        return global.getSpellMgr().getSpellInfo(getSpellId(), Difficulty.NONE).hasEffect(SpellEffectName.LearnSpell);
    }
}
