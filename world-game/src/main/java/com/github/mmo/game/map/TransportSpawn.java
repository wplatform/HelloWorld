package com.github.mmo.game.map;


public class TransportSpawn {
    private long spawnId;
    private int transportGameObjectId;
    private phaseUseFlagsValues phaseUseFlags = PhaseUseFlagsValues.values()[0];
    private int phaseId;
    private int phaseGroup;

    public final long getSpawnId() {
        return spawnId;
    }

    public final void setSpawnId(long value) {
        spawnId = value;
    }

    public final int getTransportGameObjectId() {
        return transportGameObjectId;
    }

    public final void setTransportGameObjectId(int value) {
        transportGameObjectId = value;
    }

    public final PhaseUseFlagsValues getPhaseUseFlags() {
        return phaseUseFlags;
    }

    public final void setPhaseUseFlags(PhaseUseFlagsValues value) {
        phaseUseFlags = value;
    }

    public final int getPhaseId() {
        return phaseId;
    }

    public final void setPhaseId(int value) {
        phaseId = value;
    }

    public final int getPhaseGroup() {
        return phaseGroup;
    }

    public final void setPhaseGroup(int value) {
        phaseGroup = value;
    }
}
