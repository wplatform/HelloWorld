package com.github.mmo.game.networking.packet.npc;


import java.util.*;


public class TrainerList extends ServerPacket
{
    public ObjectGuid trainerGUID = ObjectGuid.EMPTY;
	public int trainerType;
	public int trainerID = 1;
	public ArrayList<TrainerListSpell> spells = new ArrayList<>();
	public String greeting;
	public TrainerList()
	{
		super(ServerOpcode.TrainerList, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeGuid(trainerGUID);
        this.writeInt32(trainerType);
        this.writeInt32(trainerID);

        this.writeInt32(spells.size());

		for (var spell : spells)
		{
            this.writeInt32(spell.spellID);
            this.writeInt32(spell.moneyCost);
            this.writeInt32(spell.reqSkillLine);
            this.writeInt32(spell.reqSkillRank);

			for (int i = 0; i < SharedConst.MaxTrainerspellAbilityReqs; ++i)
			{
                this.writeInt32(spell.ReqAbility[i]);
			}

			this.writeInt8((byte)spell.usable.getValue());
			this.writeInt8(spell.reqLevel);
		}

        this.writeBits(greeting.GetByteCount(), 11);
        this.flushBits();
        this.writeString(greeting);
	}
}
