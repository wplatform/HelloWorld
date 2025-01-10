package com.github.azeroth.dbc;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.domain.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GameTables {
    ArmorMitigationByLvl("ArmorMitigationByLvl.txt"),
    ArtifactKnowledgeMultiplier("ArtifactKnowledgeMultiplier.txt"),
    ArtifactLevelXP("ArtifactLevelXP.txt"),
    BarberShopCostBase("BarberShopCostBase.txt"),
    BaseMP("BaseMp.txt"),
    BattlePetXP("BattlePetXP.txt"),
    CombatRatings("CombatRatings.txt"),
    CombatRatingsMultByILvl("CombatRatingsMultByILvl.txt"),
    ItemSocketCostPerLevel("ItemSocketCostPerLevel.txt"),
    HonorLevel("HonorLevel.txt"),
    HpPerSta("HpPerSta.txt"),
    NpcDamageByClass_0("NpcDamageByClass.txt"),
    NpcDamageByClass_1("NpcDamageByClassExp1.txt"),
    NpcDamageByClass_2("NpcDamageByClassExp2.txt"),
    NpcDamageByClass_3("NpcDamageByClassExp3.txt"),
    NpcDamageByClass_4("NpcDamageByClassExp4.txt"),
    NpcDamageByClass_5("NpcDamageByClassExp5.txt"),
    NpcDamageByClass_6("NpcDamageByClassExp6.txt"),
    NpcManaCostScaler("NPCManaCostScaler.txt"),
    NpcTotalHp_0("NpcTotalHp.txt"),
    NpcTotalHp_1("NpcTotalHpExp1.txt"),
    NpcTotalHp_2("NpcTotalHpExp2.txt"),
    NpcTotalHp_3("NpcTotalHpExp3.txt"),
    NpcTotalHp_4("NpcTotalHpExp4.txt"),
    NpcTotalHp_5("NpcTotalHpExp5.txt"),
    NpcTotalHp_6("NpcTotalHpExp6.txt"),
    SpellScaling("SpellScaling.txt"),
    Xp("xp.txt");
    
    public final String tableFileName;

}