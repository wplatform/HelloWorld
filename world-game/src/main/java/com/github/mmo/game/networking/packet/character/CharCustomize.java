package com.github.mmo.game.networking.packet.character;


import com.github.mmo.game.entity.*;
import com.github.mmo.game.networking.*;


public class CharCustomize extends ClientPacket
{
	public CharcustomizeInfo customizeInfo;
	public CharCustomize(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		customizeInfo = new CharCustomizeInfo();
		customizeInfo.charGUID = this.readPackedGuid();
		customizeInfo.sexID = gender.forValue((byte)this.readUInt8());
		var customizationCount = this.readUInt();

		for (var i = 0; i < customizationCount; ++i)
		{
			ChrCustomizationChoice tempVar = new ChrCustomizationChoice();
			tempVar.chrCustomizationOptionID = this.readUInt();
			tempVar.chrCustomizationChoiceID = this.readUInt();
			customizeInfo.customizations.set(i, tempVar);
		}

		collections.sort(customizeInfo.customizations);

		customizeInfo.charName = this.readString(this.<Integer>readBit(6));
	}
}