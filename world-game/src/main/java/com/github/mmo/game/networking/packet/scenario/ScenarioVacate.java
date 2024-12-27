package com.github.mmo.game.networking.packet.scenario;
import com.github.mmo.game.networking.ServerPacket;
public class ScenarioVacate extends ServerPacket
{
	public int scenarioID;
	public int unk1;
	public byte unk2;
	public ScenarioVacate()
	{
		super(ServerOpcode.ScenarioVacate, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(scenarioID);
        this.writeInt32(unk1);
        this.writeBits(unk2, 2);
        this.flushBits();
	}
}
