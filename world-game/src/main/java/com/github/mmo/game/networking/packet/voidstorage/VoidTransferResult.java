package com.github.mmo.game.networking.packet.voidstorage;
import com.github.mmo.game.networking.ServerPacket;
public class VoidTransferResult extends ServerPacket
{
	public VoidTransferError result = VoidTransferError.values()[0];

	public VoidTransferResult(VoidTransferError result)
	{
		super(ServerOpcode.VoidTransferResult, ConnectionType.instance);
		result = result;
	}

	@Override
	public void write()
	{
        this.writeInt32(result.getValue());
	}
}
