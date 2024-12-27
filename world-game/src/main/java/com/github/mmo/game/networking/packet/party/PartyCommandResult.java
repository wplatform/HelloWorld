package com.github.mmo.game.networking.packet.party;
import com.github.mmo.game.networking.ServerPacket;
public class PartyCommandResult extends ServerPacket
{
	public String name;
	public byte command;
	public byte result;
	public int resultData;
    public ObjectGuid resultGUID = ObjectGuid.EMPTY;
	public PartyCommandResult()
	{
		super(ServerOpcode.PartyCommandResult);
	}

	@Override
	public void write()
	{
        this.writeBits(name.GetByteCount(), 9);
        this.writeBits(command, 4);
        this.writeBits(result, 6);

        this.writeInt32(resultData);
        this.writeGuid(resultGUID);
        this.writeString(name);
	}
}

//Structs

