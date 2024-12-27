package com.github.mmo.game.networking.packet.guild;


import com.github.mmo.game.networking.*;

public class GuildSetRankPermissions extends ClientPacket
{
	public byte rankID;
	public int rankOrder;
	public int withdrawGoldLimit;
	public int flags;
	public int oldFlags;
	public int[] tabFlags = new int[GuildConst.MaxBankTabs];
	public int[] tabWithdrawItemLimit = new int[GuildConst.MaxBankTabs];
	public String rankName;
	public GuildSetRankPermissions(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        rankID = this.readUInt8();
        rankOrder = this.readInt32();
        flags = this.readUInt();
        withdrawGoldLimit = this.readUInt();

		for (byte i = 0; i < GuildConst.MaxBankTabs; i++)
		{
            TabFlags[i] = this.readUInt();
            TabWithdrawItemLimit[i] = this.readUInt();
		}

		this.resetBitPos();
        var rankNameLen = this.<Integer>readBit(7);

        rankName = this.readString(rankNameLen);

        oldFlags = this.readUInt();
	}
}
