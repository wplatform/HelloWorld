package com.github.mmo.game.entity.creature;


public class CreatureMovementData {
    public CreaturegroundMovementType ground = CreatureGroundMovementType.values()[0];
    public CreatureflightMovementType flight = CreatureFlightMovementType.values()[0];
    public boolean swim;
    public boolean rooted;
    public CreaturechaseMovementType chase = CreatureChaseMovementType.values()[0];
    public CreaturerandomMovementType random = CreatureRandomMovementType.values()[0];

    public int interactionPauseTimer;

    public creatureMovementData() {
        ground = CreatureGroundMovementType.run;
        flight = CreatureFlightMovementType.NONE;
        swim = true;
        rooted = false;
        chase = CreatureChaseMovementType.run;
        random = CreatureRandomMovementType.Walk;
        interactionPauseTimer = WorldConfig.getUIntValue(WorldCfg.CreatureStopForPlayer);
    }

    public final boolean isGroundAllowed() {
        return ground != CreatureGroundMovementType.NONE;
    }

    public final boolean isSwimAllowed() {
        return swim;
    }

    public final boolean isFlightAllowed() {
        return flight != CreatureFlightMovementType.NONE;
    }

    public final boolean isRooted() {
        return rooted;
    }

    public final CreatureChaseMovementType getChase() {
        return chase;
    }

    public final CreatureRandomMovementType getRandom() {
        return random;
    }


    public final int getInteractionPauseTimer() {
        return interactionPauseTimer;
    }

    @Override
    public String toString() {
        return String.format("Ground: %1$s, Swim: %2$s, Flight: %3$s %4$s, Chase: %5$s, Random: %6$s, InteractionPauseTimer: %7$s", ground, swim, flight, (Rooted ? ", Rooted" : ""), chase, random, interactionPauseTimer);
    }
}
