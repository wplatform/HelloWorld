package com.github.mmo.game.networking.packet.trait;

import com.github.mmo.game.networking.*;
class TraitsCommitConfig extends ClientPacket
{
	public TraitconfigPacket config = new traitConfigPacket();
	public int savedConfigID;
	public int savedLocalIdentifier;

	public TraitsCommitConfig(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		config.read(this);
		savedConfigID = this.readInt32();
		savedLocalIdentifier = this.readInt32();
	}
}
