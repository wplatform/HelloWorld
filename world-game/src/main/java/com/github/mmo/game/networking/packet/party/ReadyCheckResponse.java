package com.github.mmo.game.networking.packet.party;
import com.github.mmo.game.networking.ServerPacket;
public class ReadyCheckResponse extends ServerPacket
{
	public ObjectGuid partyGUID = ObjectGuid.EMPTY;
	public ObjectGuid player = ObjectGuid.EMPTY;
	public boolean isReady;
	public ReadyCheckResponse()
	{
		super(ServerOpcode.ReadyCheckResponse);
	}

	@Override
	public void write()
	{
		this.writeGuid(partyGUID);
		this.writeGuid(player);

		this.writeBit(isReady);
		this.flushBits();
	}
}
