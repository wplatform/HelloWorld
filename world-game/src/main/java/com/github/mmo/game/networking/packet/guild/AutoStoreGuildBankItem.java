package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;

class AutoStoreGuildBankItem extends ClientPacket
{
    public ObjectGuid banker = ObjectGuid.EMPTY;
	public byte bankTab;
	public byte bankSlot;
	public AutoStoreGuildBankItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        banker = this.readPackedGuid();
        bankTab = this.readUInt8();
        bankSlot = this.readUInt8();
	}
}
