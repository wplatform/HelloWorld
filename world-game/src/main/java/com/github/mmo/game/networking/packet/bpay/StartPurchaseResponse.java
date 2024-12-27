package com.github.mmo.game.networking.packet.bpay;


public class StartPurchaseResponse extends ServerPacket
{
	private long purchaseID = 0;
	public final long getPurchaseID()
	{
		return purchaseID;
	}
	public final void setPurchaseID(long value)
	{
		purchaseID = value;
	}
	private int clientToken = 0;
	public final int getClientToken()
	{
		return clientToken;
	}
	public final void setClientToken(int value)
	{
		clientToken = value;
	}
	private int purchaseResult = 0;
	public final int getPurchaseResult()
	{
		return purchaseResult;
	}
	public final void setPurchaseResult(int value)
	{
		purchaseResult = value;
	}

	public StartPurchaseResponse()
	{
		super(ServerOpcode.BattlePayStartPurchaseResponse);
	}

	@Override
	public void write()
	{
		this.write(getPurchaseID());
		this.write(getPurchaseResult());
		this.write(getClientToken());
	}
}
