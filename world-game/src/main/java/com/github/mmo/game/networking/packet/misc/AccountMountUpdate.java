package com.github.mmo.game.networking.packet.misc;


import java.util.HashMap;
import com.github.mmo.game.networking.ServerPacket;
public class AccountMountUpdate extends ServerPacket
{
	public boolean isFullUpdate = false;
	public HashMap<Integer, MountStatusFlags> mounts = new HashMap<Integer, MountStatusFlags>();
	public AccountMountUpdate()
	{
		super(ServerOpcode.AccountMountUpdate, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeBit(isFullUpdate);
        this.writeInt32(mounts.size());

		for (var spell : mounts.entrySet())
		{
            this.writeInt32(spell.getKey());
            this.writeBits(spell.getValue(), 2);
		}

        this.flushBits();
	}
}
