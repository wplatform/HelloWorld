package com.github.mmo.game.networking.packet.character;


import com.github.mmo.game.entity.*;

public class CharCustomizeInfo
{
    public ObjectGuid charGUID = ObjectGuid.EMPTY;
	public Gender sexID = gender.NONE;
	public String charName;
	public Array<ChrCustomizationChoice> customizations = new Array<ChrCustomizationChoice>(72);
}
