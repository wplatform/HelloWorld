package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;

class MoveGuildBankItem extends ClientPacket
{
    public ObjectGuid banker = ObjectGuid.EMPTY;
	public byte bankTab;
	public byte bankSlot;
	public byte bankTab1;
	public byte bankSlot1;
	public MoveGuildBankItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        banker = this.readPackedGuid();
        bankTab = this.readUInt8();
        bankSlot = this.readUInt8();
        bankTab1 = this.readUInt8();
        bankSlot1 = this.readUInt8();
	}
}