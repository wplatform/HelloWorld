package com.github.mmo.dbc.defines;

public enum CriteriaStartEvent {
    None, // - NONE -
    ReachLevel, // Reach level {#Level}
    CompleteDailyQuest, // Complete daily quest "{QuestV2}"
    StartBattleground, // Start battleground "{Map}"
    WinRankedArenaMatchWithTeamSize, // Win a ranked arena match with team size {#Team Size}
    GainAura, // Gain aura "{Spell}"
    GainAuraEffect, // Gain aura effect "{SpellAuraNames.EnumID}"
    CastSpell, // Cast spell "{Spell}"
    BeSpellTarget, // Have spell "{Spell}" cast on you
    AcceptQuest, // Accept quest "{QuestV2}"
    KillNPC, // Kill NPC "{Creature}"
    KillPlayer, // Kill player
    UseItem, // Use item "{Item}"
    SendEvent, // Send event "{GameEvents}" (player-sent/instance only)
    BeginScenarioStep, // Begin scenario step "{#Step}" (for use with "Player on Scenario" modifier only)

}
