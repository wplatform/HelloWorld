package com.github.mmo.game.networking.packet.spell;
import com.github.mmo.game.networking.ServerPacket;
public class CancelSpellVisualKit extends ServerPacket
{
	public ObjectGuid source = ObjectGuid.EMPTY;
	public int spellVisualKitID;
	public boolean mountedVisual;
	public CancelSpellVisualKit()
	{
		super(ServerOpcode.CancelSpellVisualKit);
	}

	@Override
	public void write()
	{
		this.writeGuid(source);
		this.writeInt32(spellVisualKitID);
		this.writeBit(mountedVisual);
		this.flushBits();
	}
}
