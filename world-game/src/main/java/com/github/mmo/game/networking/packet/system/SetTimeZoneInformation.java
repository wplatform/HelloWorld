package com.github.mmo.game.networking.packet.system;


public class SetTimeZoneInformation extends ServerPacket
{
	public String serverTimeTZ;
	public String gameTimeTZ;
	public String serverRegionalTZ;
	public SetTimeZoneInformation()
	{
		super(ServerOpcode.SetTimeZoneInformation);
	}

	@Override
	public void write()
	{
		this.writeBits(serverTimeTZ.GetByteCount(), 7);
		this.writeBits(gameTimeTZ.GetByteCount(), 7);
		this.writeBits(serverRegionalTZ.GetByteCount(), 7);
		this.flushBits();

		this.writeString(serverTimeTZ);
		this.writeString(gameTimeTZ);
		this.writeString(serverRegionalTZ);
	}
}
