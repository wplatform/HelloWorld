package com.github.mmo.game.map;

public final class ObjectData {
    public int entry;
    public int type;

    public objectData() {
    }
    public objectData(int entry, int type) {
        entry = entry;
        type = type;
    }

    public ObjectData clone() {
        ObjectData varCopy = new objectData();

        varCopy.entry = this.entry;
        varCopy.type = this.type;

        return varCopy;
    }
}
