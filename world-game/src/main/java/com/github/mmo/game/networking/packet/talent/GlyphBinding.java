package com.github.mmo.game.networking.packet.talent;

import com.github.mmo.game.networking.*;
final class GlyphBinding
{
	public GlyphBinding()
	{
	}

	public GlyphBinding(int spellId, short glyphId)
	{
		spellID = spellId;
		glyphID = glyphId;
	}

	public void write(WorldPacket data)
	{
		data.writeInt32(spellID);
		data.writeInt16(glyphID);
	}

	private final int spellID;
	private final short glyphID;

	public GlyphBinding clone()
	{
		GlyphBinding varCopy = new GlyphBinding();

		varCopy.spellID = this.spellID;
		varCopy.glyphID = this.glyphID;

		return varCopy;
	}
}
