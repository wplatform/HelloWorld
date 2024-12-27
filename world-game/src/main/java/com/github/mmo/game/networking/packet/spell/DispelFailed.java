package com.github.mmo.game.networking.packet.spell;


import java.util.*;import com.github.mmo.game.networking.ServerPacket;
public class DispelFailed extends ServerPacket {
    public ObjectGuid casterGUID = ObjectGuid.EMPTY;
    public ObjectGuid victimGUID = ObjectGuid.EMPTY;

    public int spellID;

    public ArrayList<Integer> failedSpells = new ArrayList<>();

    public DispelFailed() {
        super(ServerOpcode.DispelFailed);
    }

    @Override
    public void write() {
        this.writeGuid(casterGUID);
        this.writeGuid(victimGUID);
        this.writeInt32(spellID);
        this.writeInt32(failedSpells.size());

        failedSpells.forEach(FailedSpellID -> this.writeInt32(FailedSpellID));
    }
}
