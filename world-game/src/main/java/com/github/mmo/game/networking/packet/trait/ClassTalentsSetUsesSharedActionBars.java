package com.github.mmo.game.networking.packet.trait;

import com.github.mmo.game.networking.*;
class ClassTalentsSetUsesSharedActionBars extends ClientPacket
{
	public int configID;
	public boolean usesShared;
	public boolean isLastSelectedSavedConfig;

	public ClassTalentsSetUsesSharedActionBars(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		configID = this.readInt32();
		usesShared = this.readBit();
		isLastSelectedSavedConfig = this.readBit();
	}
}
