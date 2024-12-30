package com.github.mmo.game.networking.packet.query;

public final class DBQueryRecord {
    public int recordID;

    public DBQueryRecord clone() {
        DBQueryRecord varCopy = new DBQueryRecord();

        varCopy.recordID = this.recordID;

        return varCopy;
    }
}
