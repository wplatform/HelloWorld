package com.github.mmo.game.networking.packet.spell;


public class SpellEmpowerSetStage extends ServerPacket
{
	public ObjectGuid castID = ObjectGuid.EMPTY;
	public ObjectGuid caster = ObjectGuid.EMPTY;
	public int stage;
	public SpellEmpowerSetStage()
	{
		super(ServerOpcode.SpellEmpowerSetStage, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(castID);
		this.writeGuid(caster);
		this.write(stage);
	}
}