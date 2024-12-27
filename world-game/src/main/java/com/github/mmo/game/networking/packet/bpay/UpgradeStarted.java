package com.github.mmo.game.networking.packet.bpay;


public class UpgradeStarted extends ServerPacket
{
	private ObjectGuid characterGUID = ObjectGuid.EMPTY;
	public final ObjectGuid getCharacterGUID()
	{
		return characterGUID;
	}
	public final void setCharacterGUID(ObjectGuid value)
	{
		characterGUID = value;
	}

	public UpgradeStarted()
	{
		super(ServerOpcode.CharacterUpgradeStarted);
	}

	@Override
	public void write()
	{
		this.write(getCharacterGUID());
	}
}
