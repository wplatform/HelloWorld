package com.github.mmo.game;


import com.github.mmo.game.entity.unit.Unit;

public class SpellClickInfo {

    public int spellId;

    public byte castFlags;
    public SpellClickUserTypes userType = SpellClickUserTypes.values()[0];

    // helpers
    public final boolean isFitToRequirements(Unit clicker, Unit clickee) {
        var playerClicker = clicker.toPlayer();

        if (playerClicker == null) {
            return true;
        }

        Unit summoner = null;

        // Check summoners for party
        if (clickee.isSummon()) {
            summoner = clickee.toTempSummon().getSummonerUnit();
        }

        if (summoner == null) {
            summoner = clickee;
        }

        // This only applies to players
        switch (userType) {
            case Friend:
                if (!playerClicker.isFriendlyTo(summoner)) {
                    return false;
                }

                break;
            case Raid:
                if (!playerClicker.isInRaidWith(summoner)) {
                    return false;
                }

                break;
            case Party:
                if (!playerClicker.isInPartyWith(summoner)) {
                    return false;
                }

                break;
            default:
                break;
        }

        return true;
    }
}
