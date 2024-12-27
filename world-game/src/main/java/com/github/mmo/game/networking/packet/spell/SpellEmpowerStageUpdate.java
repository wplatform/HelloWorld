package com.github.mmo.game.networking.packet.spell;


import java.util.*;


public class SpellEmpowerStageUpdate extends ServerPacket
{
	public ObjectGuid castID = ObjectGuid.EMPTY;
	public ObjectGuid caster = ObjectGuid.EMPTY;
	public int timeRemaining;
	public boolean unk;
	public ArrayList<Integer> remainingStageDurations = new ArrayList<>();
	public SpellEmpowerStageUpdate()
	{
		super(ServerOpcode.SpellEmpowerUpdate, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(castID);
		this.writeGuid(caster);
		this.write(timeRemaining);
		this.write((int)remainingStageDurations.size());
		this.write(unk);

		for (var stageDuration : remainingStageDurations)
		{
			this.write(stageDuration);
		}
	}
}
