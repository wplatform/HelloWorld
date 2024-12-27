package com.github.mmo.game.networking.packet.party;
import com.github.mmo.game.networking.ServerPacket;
public class BroadcastSummonCast extends ServerPacket
{
    public ObjectGuid target = ObjectGuid.EMPTY;

	public BroadcastSummonCast()
	{
		super(ServerOpcode.BroadcastSummonCast);
	}

	@Override
	public void write()
	{
        this.writeGuid(target);
	}
}
