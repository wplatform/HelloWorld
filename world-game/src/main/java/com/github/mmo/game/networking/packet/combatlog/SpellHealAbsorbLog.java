package com.github.mmo.game.networking.packet.combatlog;
import com.github.mmo.game.networking.ServerPacket;
public class SpellHealAbsorbLog extends ServerPacket
{
	public ObjectGuid healer = ObjectGuid.EMPTY;
	public ObjectGuid target = ObjectGuid.EMPTY;
	public ObjectGuid absorbCaster = ObjectGuid.EMPTY;
	public int absorbSpellID;
	public int absorbedSpellID;
	public int absorbed;
	public int originalHeal;
	public contentTuningParams contentTuning;
	public SpellHealAbsorbLog()
	{
		super(ServerOpcode.SpellHealAbsorbLog, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(target);
		this.writeGuid(absorbCaster);
		this.writeGuid(healer);
		this.writeInt32(absorbSpellID);
		this.writeInt32(absorbedSpellID);
		this.writeInt32(absorbed);
		this.writeInt32(originalHeal);
		this.writeBit(contentTuning != null);
		this.flushBits();

		if (contentTuning != null)
		{
			contentTuning.write(this);
		}
	}
}
