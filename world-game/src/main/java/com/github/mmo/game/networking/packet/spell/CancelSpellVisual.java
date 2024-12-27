package com.github.mmo.game.networking.packet.spell;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;

public class CancelSpellVisual extends ServerPacket
{
	public ObjectGuid source = ObjectGuid.EMPTY;
	public int spellVisualID;
	public CancelSpellVisual()
	{
		super(ServerOpCode.SMSG_CANCEL_SPELL_VISUAL);
	}

	@Override
	public void write()
	{
		this.writeGuid(source);
		this.writeInt32(spellVisualID);
	}
}
