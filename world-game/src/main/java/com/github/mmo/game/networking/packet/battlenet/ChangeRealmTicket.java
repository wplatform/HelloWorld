package com.github.mmo.game.networking.packet.battlenet;

import com.github.mmo.game.networking.*;

class ChangeRealmTicket extends ClientPacket
{
	public int token;
	public Array<Byte> secret = new Array<Byte>(32);
	public ChangeRealmTicket(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		token = this.readUInt();

		for (var i = 0; i < secret.GetLimit(); ++i)
		{
			secret.set(i, this.readUInt8());
		}
	}
}