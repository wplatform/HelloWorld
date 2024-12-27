package com.github.mmo.game.map;

public class SpawnGroupTemplateData {

    private int groupId;
    private String name;

    private int mapId;
    private SpawnGroupflags flags = SpawnGroupFlags.values()[0];


    public final int getGroupId() {
        return groupId;
    }


    public final void setGroupId(int value) {
        groupId = value;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String value) {
        name = value;
    }


    public final int getMapId() {
        return mapId;
    }


    public final void setMapId(int value) {
        mapId = value;
    }

    public final SpawnGroupFlags getFlags() {
        return flags;
    }

    public final void setFlags(SpawnGroupFlags value) {
        flags = value;
    }
}
