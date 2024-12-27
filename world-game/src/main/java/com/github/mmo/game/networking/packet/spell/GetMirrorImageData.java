package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;

class GetMirrorImageData extends ClientPacket
{
	public ObjectGuid unitGUID = ObjectGuid.EMPTY;
	public GetMirrorImageData(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		unitGUID = this.readPackedGuid();
	}
}
