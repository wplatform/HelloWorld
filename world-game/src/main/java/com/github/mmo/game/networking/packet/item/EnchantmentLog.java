package com.github.mmo.game.networking.packet.item;
import com.github.mmo.game.networking.ServerPacket;
public class EnchantmentLog extends ServerPacket
{
    public ObjectGuid owner = ObjectGuid.EMPTY;
    public ObjectGuid caster = ObjectGuid.EMPTY;
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;
	public int itemID;
	public int enchantment;
	public int enchantSlot;
	public EnchantmentLog()
	{
		super(ServerOpcode.EnchantmentLog, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeGuid(owner);
        this.writeGuid(caster);
        this.writeGuid(itemGUID);
        this.writeInt32(itemID);
        this.writeInt32(enchantment);
        this.writeInt32(enchantSlot);
	}
}
