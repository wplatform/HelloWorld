package com.github.mmo.game.networking.packet.combatlog;


import com.github.mmo.game.networking.WorldPacket;

class AttackerStateUpdate extends CombatLogServerPacket
{
	public HitInfo hitInfo = hitInfo.values()[0]; // Flags
    public ObjectGuid attackerGUID = ObjectGuid.EMPTY;
    public ObjectGuid victimGUID = ObjectGuid.EMPTY;
	public int damage;
	public int originalDamage;
	public int overDamage = -1; // (damage - health) or -1 if unit is still alive
	public SubDamage subDmg = null;
	public byte victimState;
	public int attackerState;
	public int meleeSpellID;
	public int blockAmount;
	public int rageGained;
	public unkAttackerState unkState = new unkAttackerState();
	public float unk;
	public contentTuningParams contentTuning = new contentTuningParams();
	public attackerStateUpdate()
	{
		super(ServerOpcode.AttackerStateUpdate, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		WorldPacket attackRoundInfo = new WorldPacket();
        attackRoundInfo.writeInt32((int) hitInfo.getValue());
        attackRoundInfo.writeGuid(attackerGUID);
        attackRoundInfo.writeGuid(victimGUID);
        attackRoundInfo.writeInt32(damage);
        attackRoundInfo.writeInt32(originalDamage);
        attackRoundInfo.writeInt32(overDamage);
		attackRoundInfo.writeInt8((byte)(subDmg != null ? 1 : 0));

		if (subDmg != null)
		{
            attackRoundInfo.writeInt32(subDmg.getValue().schoolMask);
            attackRoundInfo.writeFloat(subDmg.getValue().FDamage);
            attackRoundInfo.writeInt32(subDmg.getValue().damage);

			if (hitInfo.HasAnyFlag(hitInfo.FullAbsorb.getValue() | hitInfo.PartialAbsorb.getValue()))
			{
                attackRoundInfo.writeInt32(subDmg.getValue().absorbed);
			}

			if (hitInfo.HasAnyFlag(hitInfo.FullResist.getValue() | hitInfo.PartialResist.getValue()))
			{
                attackRoundInfo.writeInt32(subDmg.getValue().resisted);
			}
		}

		attackRoundInfo.writeInt8(victimState);
        attackRoundInfo.writeInt32(attackerState);
        attackRoundInfo.writeInt32(meleeSpellID);

		if (hitInfo.HasAnyFlag(hitInfo.Block))
		{
            attackRoundInfo.writeInt32(blockAmount);
		}

		if (hitInfo.HasAnyFlag(hitInfo.RageGain))
		{
            attackRoundInfo.writeInt32(rageGained);
		}

		if (hitInfo.HasAnyFlag(hitInfo.unk1))
		{
            attackRoundInfo.writeInt32(unkState.state1);
            attackRoundInfo.writeFloat(unkState.state2);
            attackRoundInfo.writeFloat(unkState.state3);
            attackRoundInfo.writeFloat(unkState.state4);
            attackRoundInfo.writeFloat(unkState.state5);
            attackRoundInfo.writeFloat(unkState.state6);
            attackRoundInfo.writeFloat(unkState.state7);
            attackRoundInfo.writeFloat(unkState.state8);
            attackRoundInfo.writeFloat(unkState.state9);
            attackRoundInfo.writeFloat(unkState.state10);
            attackRoundInfo.writeFloat(unkState.state11);
            attackRoundInfo.writeInt32(unkState.state12);
		}

		if (hitInfo.HasAnyFlag(hitInfo.Block.getValue() | hitInfo.Unk12.getValue()))
		{
            attackRoundInfo.writeFloat(unk);
		}

		attackRoundInfo.writeInt8((byte)contentTuning.tuningType.getValue());
		attackRoundInfo.writeInt8(contentTuning.targetLevel);
		attackRoundInfo.writeInt8(contentTuning.expansion);
        attackRoundInfo.writeInt16(contentTuning.playerLevelDelta);
        attackRoundInfo.writeInt8(contentTuning.targetScalingLevelDelta);
        attackRoundInfo.writeFloat(contentTuning.playerItemLevel);
        attackRoundInfo.writeFloat(contentTuning.targetItemLevel);
		attackRoundInfo.writeInt16(contentTuning.scalingHealthItemLevelCurveID);
        attackRoundInfo.writeInt32(contentTuning.flags.getValue());
        attackRoundInfo.writeInt32(contentTuning.playerContentTuningID);
        attackRoundInfo.writeInt32(contentTuning.targetContentTuningID);

		writeLogDataBit();
        flushBits();
		writeLogData();

        this.writeInt32(attackRoundInfo.getSize());
        this.writeBytes(attackRoundInfo);
	}
}
