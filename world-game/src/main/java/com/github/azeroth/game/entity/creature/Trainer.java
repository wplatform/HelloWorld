package com.github.azeroth.game.entity.creature;


import com.github.azeroth.game.battlepet.BattlePetMgr;
import com.github.azeroth.game.entity.player.Player;

import java.util.ArrayList;
import java.util.Locale;


public class Trainer {
    private final int id;
    private final TrainerType type;
    private final ArrayList<TrainerSpell> spells;
    private final String[] greeting = new String[Locale.Total.getValue()];

    public Trainer(int id, TrainerType type, String greeting, ArrayList<TrainerSpell> spells) {
        id = id;
        type = type;
        spells = spells;

        _greeting[Locale.enUS.getValue()] = greeting;
    }

    public final void sendSpells(Creature npc, Player player, Locale locale) {
        var reputationDiscount = player.getReputationPriceDiscount(npc);

        TrainerList trainerList = new TrainerList();
        trainerList.trainerGUID = npc.getGUID();
        trainerList.trainerType = type.getValue();
        trainerList.trainerID = (int) id;
        trainerList.greeting = getGreeting(locale);

        for (var trainerSpell : spells) {
            if (!player.isSpellFitByClassAndRace(trainerSpell.getSpellId())) {
                continue;
            }

            if (!global.getConditionMgr().isObjectMeetingTrainerSpellConditions(id, trainerSpell.getSpellId(), player)) {
                Log.outDebug(LogFilter.condition, String.format("SendSpells: conditions not met for trainer id %1$s spell %2$s player '%3$s' (%4$s)", id, trainerSpell.getSpellId(), player.getName(), player.getGUID()));

                continue;
            }

            TrainerListSpell trainerListSpell = new TrainerListSpell();
            trainerListSpell.spellID = trainerSpell.getSpellId();
            trainerListSpell.moneyCost = (int) (trainerSpell.getMoneyCost() * reputationDiscount);
            trainerListSpell.reqSkillLine = trainerSpell.getReqSkillLine();
            trainerListSpell.reqSkillRank = trainerSpell.getReqSkillRank();
            trainerListSpell.reqAbility = tangible.IntegerLists.toArray(trainerSpell.getReqAbility());
            trainerListSpell.usable = getSpellState(player, trainerSpell);
            trainerListSpell.reqLevel = trainerSpell.getReqLevel();
            trainerList.spells.add(trainerListSpell);
        }

        player.sendPacket(trainerList);
    }

    public final void teachSpell(Creature npc, Player player, int spellId) {
        var trainerSpell = getSpell(spellId);

        if (trainerSpell == null || !canTeachSpell(player, trainerSpell)) {
            sendTeachFailure(npc, player, spellId, TrainerFailReason.Unavailable);

            return;
        }

        var sendSpellVisual = true;
        var speciesEntry = BattlePetMgr.getBattlePetSpeciesBySpell(trainerSpell.getSpellId());

        if (speciesEntry != null) {
            if (player.getSession().getBattlePetMgr().hasMaxPetCount(speciesEntry, player.getGUID())) {
                // Don't send any error to client (intended)
                return;
            }

            sendSpellVisual = false;
        }

        var reputationDiscount = player.getReputationPriceDiscount(npc);
        var moneyCost = (long) (trainerSpell.getMoneyCost() * reputationDiscount);

        if (!player.hasEnoughMoney(moneyCost)) {
            sendTeachFailure(npc, player, spellId, TrainerFailReason.NotEnoughMoney);

            return;
        }

        player.modifyMoney(-moneyCost);

        if (sendSpellVisual) {
            npc.sendPlaySpellVisualKit(179, 0, 0); // 53 SpellCastDirected
            player.sendPlaySpellVisualKit(362, 1, 0); // 113 EmoteSalute
        }

        // learn explicitly or cast explicitly
        if (trainerSpell.isCastable()) {
            player.castSpell(player, trainerSpell.getSpellId(), true);
        } else {
            var dependent = false;

            if (speciesEntry != null) {
                player.getSession().getBattlePetMgr().addPet(speciesEntry.id, BattlePetMgr.selectPetDisplay(speciesEntry), BattlePetMgr.rollPetBreed(speciesEntry.id), BattlePetMgr.getDefaultPetQuality(speciesEntry.id));
                // If the spell summons a battle pet, we fake that it has been learned and the battle pet is added
                // marking as dependent prevents saving the spell to database (intended)
                dependent = true;
            }

            player.learnSpell(trainerSpell.getSpellId(), dependent);
        }
    }

    public final void addGreetingLocale(Locale locale, String greeting) {
        _greeting[locale.getValue()] = greeting;
    }

    private TrainerSpell getSpell(int spellId) {
        return tangible.ListHelper.find(spells, trainerSpell -> trainerSpell.spellId == spellId);
    }

    private boolean canTeachSpell(Player player, TrainerSpell trainerSpell) {
        var state = getSpellState(player, trainerSpell);

        if (state != TrainerSpellState.Available) {
            return false;
        }

        var trainerSpellInfo = global.getSpellMgr().getSpellInfo(trainerSpell.getSpellId(), Difficulty.NONE);

        if (trainerSpellInfo.isPrimaryProfessionFirstRank() && player.getFreePrimaryProfessionPoints() == 0) {
            return false;
        }

        for (var effect : trainerSpellInfo.getEffects()) {
            if (!effect.isEffect(SpellEffectName.LearnSpell)) {
                continue;
            }

            var learnedSpellInfo = global.getSpellMgr().getSpellInfo(effect.triggerSpell, Difficulty.NONE);

            if (learnedSpellInfo != null && learnedSpellInfo.isPrimaryProfessionFirstRank() && player.getFreePrimaryProfessionPoints() == 0) {
                return false;
            }
        }

        return true;
    }

    private TrainerSpellState getSpellState(Player player, TrainerSpell trainerSpell) {
        if (player.hasSpell(trainerSpell.getSpellId())) {
            return TrainerSpellState.Known;
        }

        // check race/class requirement
        if (!player.isSpellFitByClassAndRace(trainerSpell.getSpellId())) {
            return TrainerSpellState.Unavailable;
        }

        // check skill requirement
        if (trainerSpell.getReqSkillLine() != 0 && player.getBaseSkillValue(SkillType.forValue(trainerSpell.getReqSkillLine())).getValue() < trainerSpell.getReqSkillRank()) {
            return TrainerSpellState.Unavailable;
        }

        for (var reqAbility : trainerSpell.getReqAbility()) {
            if (reqAbility != 0 && !player.hasSpell(reqAbility)) {
                return TrainerSpellState.Unavailable;
            }
        }

        // check level requirement
        if (player.getLevel() < trainerSpell.getReqLevel()) {
            return TrainerSpellState.Unavailable;
        }

        // check ranks
        var hasLearnSpellEffect = false;
        var knowsAllLearnedSpells = true;

        for (var spellEffectInfo : global.getSpellMgr().getSpellInfo(trainerSpell.getSpellId(), Difficulty.NONE).getEffects()) {
            if (!spellEffectInfo.isEffect(SpellEffectName.LearnSpell)) {
                continue;
            }

            hasLearnSpellEffect = true;

            if (!player.hasSpell(spellEffectInfo.triggerSpell)) {
                knowsAllLearnedSpells = false;
            }
        }

        if (hasLearnSpellEffect && knowsAllLearnedSpells) {
            return TrainerSpellState.Known;
        }

        return TrainerSpellState.Available;
    }

    private void sendTeachFailure(Creature npc, Player player, int spellId, TrainerFailReason reason) {
        TrainerBuyFailed trainerBuyFailed = new TrainerBuyFailed();
        trainerBuyFailed.trainerGUID = npc.getGUID();
        trainerBuyFailed.spellID = spellId;
        trainerBuyFailed.trainerFailedReason = reason;
        player.sendPacket(trainerBuyFailed);
    }

    private String getGreeting(Locale locale) {
        if (_greeting[locale.getValue()].isEmpty()) {
            return _greeting[Locale.enUS.getValue()];
        }

        return _greeting[locale.getValue()];
    }
}
