package com.github.mmo.game.networking.packet.loot;
import com.github.mmo.game.networking.ServerPacket;
public class LootAllPassed extends ServerPacket
{
    public ObjectGuid lootObj = ObjectGuid.EMPTY;
	public LootitemData item = new lootItemData();
	public LootAllPassed()
	{
		super(ServerOpcode.LootAllPassed);
	}

	@Override
	public void write()
	{
        this.writeGuid(lootObj);
		item.write(this);
	}
}
