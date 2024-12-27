package com.github.mmo.game.networking.packet.movement;
import com.github.mmo.game.networking.ServerPacket;
public class ResumeToken extends ServerPacket
{
	public int sequenceIndex = 1;
	public int reason = 1;
	public ResumeToken()
	{
		super(ServerOpcode.ResumeToken, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(sequenceIndex);
		this.writeBits(reason, 2);
		this.flushBits();
	}
}
