package com.github.mmo.game.networking.packet.quest;


public class QuestUpdateAddCredit extends ServerPacket
{
    public ObjectGuid victimGUID = ObjectGuid.EMPTY;
	public int objectID;
	public int questID;
	public short count;
	public short required;
	public byte objectiveType;
	public QuestUpdateAddCredit()
	{
		super(ServerOpcode.QuestUpdateAddCredit, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeGuid(victimGUID);
        this.writeInt32(questID);
        this.writeInt32(objectID);
		this.writeInt16(count);
		this.writeInt16(required);
		this.writeInt8(objectiveType);
	}
}
