package com.github.mmo.game.networking.packet.transmogification;

import com.github.mmo.game.networking.*;
final class TransmogrifyItem
{
	public void read(WorldPacket data)
	{
		itemModifiedAppearanceID = data.readInt32();
		slot = data.readUInt();
		spellItemEnchantmentID = data.readInt32();
		secondaryItemModifiedAppearanceID = data.readInt32();
	}

	public int itemModifiedAppearanceID;
	public int slot;
	public int spellItemEnchantmentID;
	public int secondaryItemModifiedAppearanceID;

	public TransmogrifyItem clone()
	{
		TransmogrifyItem varCopy = new TransmogrifyItem();

		varCopy.itemModifiedAppearanceID = this.itemModifiedAppearanceID;
		varCopy.slot = this.slot;
		varCopy.spellItemEnchantmentID = this.spellItemEnchantmentID;
		varCopy.secondaryItemModifiedAppearanceID = this.secondaryItemModifiedAppearanceID;

		return varCopy;
	}
}