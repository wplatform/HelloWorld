package com.github.mmo.game.networking.packet.gameobject;

import com.github.mmo.game.networking.*;

public class GameObjUse extends ClientPacket
{
	public ObjectGuid guid = ObjectGuid.EMPTY;
	public boolean isSoftInteract;
	public GameObjUse(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		guid = this.readPackedGuid();
		isSoftInteract = this.readBit();
	}
}
