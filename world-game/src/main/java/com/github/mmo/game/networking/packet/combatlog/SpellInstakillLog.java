package com.github.mmo.game.networking.packet.combatlog;


public class SpellInstakillLog extends ServerPacket
{
	public ObjectGuid target = ObjectGuid.EMPTY;
	public ObjectGuid caster = ObjectGuid.EMPTY;
	public int spellID;
	public SpellInstakillLog()
	{
		super(ServerOpcode.SpellInstakillLog, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(target);
		this.writeGuid(caster);
		this.writeInt32(spellID);
	}
}
