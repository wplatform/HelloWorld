package com.github.mmo.game.networking.packet.scenario;
import com.github.mmo.game.networking.ServerPacket;
public class ScenarioCompleted extends ServerPacket
{
	public int scenarioID;

	public ScenarioCompleted(int scenarioId)
	{
		super(ServerOpcode.ScenarioCompleted, ConnectionType.instance);
		scenarioID = scenarioId;
	}

	@Override
	public void write()
	{
		this.writeInt32(scenarioID);
	}
}
