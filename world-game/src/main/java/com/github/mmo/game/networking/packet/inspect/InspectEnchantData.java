package com.github.mmo.game.networking.packet.inspect;

import com.github.mmo.game.networking.*;
/** RespondInspectAchievements in AchievementPackets
*/

//Structs
public final class InspectEnchantData
{
	public InspectEnchantData()
	{
	}

	public InspectEnchantData(int id, byte index)
	{
		id = id;
		index = index;
	}

	public void write(WorldPacket data)
	{
		data.writeInt32(id);
		data.writeInt8(index);
	}

	public int id;
	public byte index;

	public InspectEnchantData clone()
	{
		InspectEnchantData varCopy = new InspectEnchantData();

		varCopy.id = this.id;
		varCopy.index = this.index;

		return varCopy;
	}
}
