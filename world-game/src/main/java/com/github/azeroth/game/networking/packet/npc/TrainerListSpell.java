package com.github.azeroth.game.networking.packet.npc;


public class TrainerListSpell {
    public int spellID;
    public int moneyCost;
    public int reqSkillLine;
    public int reqSkillRank;
    public int[] reqAbility = new int[SharedConst.MaxTrainerspellAbilityReqs];
    public TrainerSpellState usable = TrainerSpellState.values()[0];
    public byte reqLevel;
}
