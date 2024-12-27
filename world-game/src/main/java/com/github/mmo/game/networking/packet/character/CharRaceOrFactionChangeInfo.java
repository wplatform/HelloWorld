package com.github.mmo.game.networking.packet.character;


import com.github.mmo.game.entity.ChrCustomizationChoice;

public class CharRaceOrFactionChangeInfo {
    public Race raceID = race.NONE;
    public Race initialRaceID = race.NONE;
    public Gender sexID = gender.NONE;
    public ObjectGuid guid = ObjectGuid.EMPTY;
    public boolean factionChange;
    public String name;
    public Array<ChrCustomizationChoice> customizations = new Array<ChrCustomizationChoice>(72);
}
