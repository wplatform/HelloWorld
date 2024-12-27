package com.github.mmo.game.networking.packet.scene;
import com.github.mmo.game.networking.ServerPacket;
public class CancelScene extends ServerPacket
{
	public int sceneInstanceID;
	public cancelScene()
	{
		super(ServerOpcode.CancelScene, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(sceneInstanceID);
	}
}
