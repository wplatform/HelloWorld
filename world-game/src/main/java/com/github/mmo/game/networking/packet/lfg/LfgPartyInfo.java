package com.github.mmo.game.networking.packet.lfg;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class LfgPartyInfo extends ServerPacket
{
	public ArrayList<LFGBlackList> player = new ArrayList<>();
	public LfgPartyInfo()
	{
		super(ServerOpcode.LfgPartyInfo, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(player.size());

		for (var blackList : player)
		{
			blackList.write(this);
		}
	}
}
