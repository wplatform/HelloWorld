package com.github.mmo.game.networking.packet.loot;
import com.github.mmo.game.networking.ServerPacket;
public class LootRollsComplete extends ServerPacket
{
    public ObjectGuid lootObj = ObjectGuid.EMPTY;
	public byte lootListID;
	public LootRollsComplete()
	{
		super(ServerOpcode.LootRollsComplete);
	}

	@Override
	public void write()
	{
        this.writeGuid(lootObj);
		this.writeInt8(lootListID);
	}
}
