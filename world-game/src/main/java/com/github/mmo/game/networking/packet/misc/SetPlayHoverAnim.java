package com.github.mmo.game.networking.packet.misc;
import com.github.mmo.game.networking.ServerPacket;
public class SetPlayHoverAnim extends ServerPacket
{
	public ObjectGuid unitGUID = ObjectGuid.EMPTY;
	public boolean playHoverAnim;
	public setPlayHoverAnim()
	{
		super(ServerOpcode.SetPlayHoverAnim, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(unitGUID);
		this.writeBit(playHoverAnim);
		this.flushBits();
	}
}
