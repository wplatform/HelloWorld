package com.github.azeroth.game.domain.creature;


public class CreatureMovementData {
    public int spawnId;
    public CreatureGroundMovementType ground;
    public CreatureFlightMovementType flight;
    public boolean swim;
    public boolean rooted;
    public CreatureChaseMovementType chase;
    public CreatureRandomMovementType random;

    public int interactionPauseTimer;

    public CreatureMovementData() {
        ground = CreatureGroundMovementType.Run;
        flight = CreatureFlightMovementType.None;
        swim = true;
        rooted = false;
        chase = CreatureChaseMovementType.Run;
        random = CreatureRandomMovementType.Walk;
    }

    public final boolean isGroundAllowed() {
        return ground != CreatureGroundMovementType.None;
    }

    public final boolean isSwimAllowed() {
        return swim;
    }

    public final boolean isFlightAllowed() {
        return flight != CreatureFlightMovementType.None;
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
        return String.format("Ground: %1$s, Swim: %2$s, Flight: %3$s %4$s, Chase: %5$s, Random: %6$s, InteractionPauseTimer: %7$s", ground, swim, flight, (rooted ? ", Rooted" : ""), chase, random, interactionPauseTimer);
    }
}
