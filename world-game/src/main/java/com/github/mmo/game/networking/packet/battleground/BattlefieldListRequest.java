package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.*;
class BattlefieldListRequest extends ClientPacket
{
	public int listID;
	public BattlefieldListRequest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        listID = this.readInt32();
	}
}
