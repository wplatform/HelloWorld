package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.*;
public class GetUndeleteCharacterCooldownStatus extends ClientPacket
{
	public GetUndeleteCharacterCooldownStatus(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
