package com.github.azeroth.game.domain.creature;


public class TrainerSpell {
    public int trainerId;
    public int spellId;
    public int moneyCost;
    public int reqSkillLine;
    public int reqSkillRank;
    public int[] reqAbility;
    public byte reqLevel;

    public TrainerSpell(int trainerId, int spellId, int moneyCost, int reqSkillLine, int reqSkillRank, int reqAbility1, int reqAbility2, int reqAbility3, byte reqLevel) {
        this.trainerId = trainerId;
        this.spellId = spellId;
        this.moneyCost = moneyCost;
        this.reqSkillLine = reqSkillLine;
        this.reqSkillRank = reqSkillRank;
        this.reqAbility = new int[] {reqAbility1, reqAbility2, reqAbility3};
        this.reqLevel = reqLevel;
    }

}
