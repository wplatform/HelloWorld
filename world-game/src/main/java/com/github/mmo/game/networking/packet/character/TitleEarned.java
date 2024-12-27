package com.github.mmo.game.networking.packet.character;
import com.github.mmo.game.networking.ServerPacket;
public class TitleEarned extends ServerPacket
{
	public int index;
	public TitleEarned(ServerOpCode opcode)
	{
		super(opcode);
	}

	@Override
	public void write()
	{
        this.writeInt32(index);
	}
}
