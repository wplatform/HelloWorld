package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.entity.*;
import com.github.mmo.game.networking.*;


public class AlterApperance extends ClientPacket
{
	public byte newSex;
	public Array<ChrCustomizationChoice> customizations = new Array<ChrCustomizationChoice>(72);
	public int customizedRace;
	public AlterApperance(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		var customizationCount = this.readUInt();
		newSex = this.readUInt8();
		customizedRace = this.readInt32();

		for (var i = 0; i < customizationCount; ++i)
		{
			ChrCustomizationChoice tempVar = new ChrCustomizationChoice();
			tempVar.chrCustomizationOptionID = this.readUInt();
			tempVar.chrCustomizationChoiceID = this.readUInt();
			customizations.set(i, tempVar);
		}

		collections.sort(customizations);
	}
}
