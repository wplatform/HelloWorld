package com.github.mmo.game.networking.packet.combatlog;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;

import java.util.ArrayList;


public class SpellMissLog extends ServerPacket {
    public int spellID;
    public ObjectGuid caster = ObjectGuid.EMPTY;
    public ArrayList<SpellLogMissEntry> entries = new ArrayList<>();

    public SpellMissLog() {
        super(ServerOpCode.SMSG_SPELL_MISS_LOG);
    }

    public void write() {
        writeInt32(spellID);
        writeGuid(caster);
        writeInt32(entries.size());

        for (var missEntry : entries) {
            missEntry.write(this);
        }
    }
}
