package com.github.mmo.game.networking.packet.character;
import com.github.mmo.game.networking.ServerPacket;
public class SetPlayerDeclinedNamesResult extends ServerPacket
{
	public ObjectGuid player = ObjectGuid.EMPTY;
	public DeclinedNameResult resultCode = DeclinedNameResult.values()[0];
	public SetPlayerDeclinedNamesResult()
	{
		super(ServerOpcode.SetPlayerDeclinedNamesResult);
	}

	@Override
	public void write()
	{
		this.writeInt32(resultCode.getValue());
		this.writeGuid(player);
	}
}
