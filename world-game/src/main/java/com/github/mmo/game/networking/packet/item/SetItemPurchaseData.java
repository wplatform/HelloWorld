package com.github.mmo.game.networking.packet.item;
import com.github.mmo.game.networking.ServerPacket;
public class SetItemPurchaseData extends ServerPacket
{
	public int purchaseTime;
	public int flags;
	public ItemPurchasecontents contents = new itemPurchaseContents();
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;
	public SetItemPurchaseData()
	{
		super(ServerOpcode.SetItemPurchaseData, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeGuid(itemGUID);
		contents.write(this);
        this.writeInt32(flags);
        this.writeInt32(purchaseTime);
	}
}
