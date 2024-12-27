package com.github.mmo.dbc.defines;

public enum CriteriaFailEvent {
    None,
    Death,    // Death
    Hours24WithoutCompletingDailyQuest,    // 24 hours without completing a daily quest
    LeaveBattleground,    // Leave a battleground
    LoseRankedArenaMatchWithTeamSize,    // Lose a ranked arena match with team size {#Team Size}
    LoseAura,    // Lose aura "{Spell}"
    GainAura,    // Gain aura "{Spell}"
    GainAuraEffect,    // Gain aura effect "{SpellAuraNames.EnumID}"
    CastSpell,    // Cast spell "{Spell}"
    BeSpellTarget,    // Have spell "{Spell}" cast on you
    ModifyPartyStatus,   // Modify your party status
    LosePetBattle,   // Lose a pet battle
    BattlePetDies,   // Battle pet dies
    DailyQuestsCleared,   // Daily quests cleared
    SendEvent,   // Send event "{GameEvents}" (player-sent/instance only)

}
