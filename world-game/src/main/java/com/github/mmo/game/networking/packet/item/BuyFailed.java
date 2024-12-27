package com.github.mmo.game.networking.packet.item;


public class BuyFailed extends ServerPacket
{
    public ObjectGuid vendorGUID = ObjectGuid.EMPTY;
	public int muid;
	public BuyResult reason = BuyResult.CantFindItem;
	public BuyFailed()
	{
		super(ServerOpcode.BuyFailed);
	}

	@Override
	public void write()
	{
        this.writeGuid(vendorGUID);
        this.writeInt32(muid);
		this.writeInt8((byte)reason.getValue());
	}
}
