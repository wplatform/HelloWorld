package com.github.mmo.game.entity.creature;



import java.util.*;public class CreatureAddon {

    public int pathId;

    public int mount;

    public byte standState;

    public byte animTier;

    public byte sheathState;

    public byte pvpFlags;

    public byte visFlags;

    public int emote;

    public short aiAnimKit;

    public short movementAnimKit;

    public short meleeAnimKit;

    public ArrayList<Integer> auras = new ArrayList<>();
    public visibilityDistanceType visibilityDistanceType = Framework.Constants.visibilityDistanceType.values()[0];
}