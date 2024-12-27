package com.github.mmo.game.networking.packet.combat;


import com.github.mmo.game.entity.unit.Unit;

public class SAttackStop extends ServerPacket
{
    public ObjectGuid attacker = ObjectGuid.EMPTY;
    public ObjectGuid victim = ObjectGuid.EMPTY;
	public boolean nowDead;

	public SAttackStop(Unit attacker, Unit victim)
	{
		super(ServerOpcode.AttackStop, ConnectionType.instance);
        attacker = attacker.getGUID();

		if (victim)
		{
            victim = victim.getGUID();
			nowDead = !victim.isAlive(); // using isAlive instead of isDead to catch JUST_DIED death states as well
		}
	}

	@Override
	public void write()
	{
        this.writeGuid(attacker);
        this.writeGuid(victim);
        this.writeBit(nowDead);
        this.flushBits();
	}
}
