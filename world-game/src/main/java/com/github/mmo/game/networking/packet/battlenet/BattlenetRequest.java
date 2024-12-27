package com.github.mmo.game.networking.packet.battlenet;

import com.github.mmo.game.networking.*;
class BattlenetRequest extends ClientPacket
{
	public methodCall method = new methodCall();
	public byte[] data;
	public BattlenetRequest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		method.read(this);
		var protoSize = this.readUInt();

		data = this.readBytes(protoSize);
	}
}
