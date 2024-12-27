package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.*;
import java.util.*;


public class LFGBlackListPkt
{
	public ObjectGuid playerGuid = null;
	public ArrayList<LFGBlackListslot> slot = new ArrayList<>();

	public final void write(WorldPacket data)
	{
        data.writeBit(playerGuid != null);
        data.writeInt32(slot.size());

		if (playerGuid != null)
		{
            data.writeGuid(playerGuid.getValue());
		}

		for (var slot : slot)
		{
			slot.write(data);
		}
	}
}
