package com.github.mmo.game.networking.packet.spell;


class SpellGo extends CombatLogServerPacket
{
	public SpellcastData cast = new spellCastData();
	public SpellGo()
	{
		super(ServerOpcode.SpellGo, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		cast.write(this);

		writeLogDataBit();
        flushBits();

		writeLogData();
	}
}
