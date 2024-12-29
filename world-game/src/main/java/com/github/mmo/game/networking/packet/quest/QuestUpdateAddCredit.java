package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;

public class QuestUpdateAddCredit extends ServerPacket {
    public ObjectGuid victimGUID = ObjectGuid.EMPTY;
    public int objectID;
    public int questID;
    public short count;
    public short required;
    public byte objectiveType;

    public QuestUpdateAddCredit() {
        super(ServerOpCode.SMSG_QUEST_UPDATE_ADD_CREDIT);
    }

    @Override
    public void write() {
        this.writeGuid(victimGUID);
        this.writeInt32(questID);
        this.writeInt32(objectID);
        this.writeInt16(count);
        this.writeInt16(required);
        this.writeInt8(objectiveType);
    }
}
