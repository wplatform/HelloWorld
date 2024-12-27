package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;

class SplitGuildBankItemToInventory extends ClientPacket
{
    public ObjectGuid banker = ObjectGuid.EMPTY;
	public byte bankTab;
	public byte bankSlot;
	public Byte containerSlot = null;
	public byte containerItemSlot;
	public int stackCount;
	public SplitGuildBankItemToInventory(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        banker = this.readPackedGuid();
        bankTab = this.readUInt8();
        bankSlot = this.readUInt8();
		;
        containerItemSlot = this.readUInt8();
        stackCount = this.readUInt();

        if (this.readBit())
		{
            containerSlot = this.readUInt8();
		}
	}
}
