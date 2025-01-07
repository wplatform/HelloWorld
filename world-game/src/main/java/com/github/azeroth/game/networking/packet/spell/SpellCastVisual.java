package com.github.azeroth.game.networking.packet.spell;

import com.github.azeroth.game.networking.WorldPacket;

public final class SpellCastVisual {
    public int spellXSpellVisualID;
    public int scriptVisualID;

    public SpellCastVisual() {
    }

    public spellCastVisual(int spellXSpellVisualID, int scriptVisualID) {
        spellXSpellVisualID = spellXSpellVisualID;
        scriptVisualID = scriptVisualID;
    }

    public void read(WorldPacket data) {
        spellXSpellVisualID = data.readUInt();
        scriptVisualID = data.readUInt();
    }

    public void write(WorldPacket data) {
        data.writeInt32(spellXSpellVisualID);
        data.writeInt32(scriptVisualID);
    }

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator spellCastVisualField(SpellCastVisual spellCastVisual)
//		{
//			SpellCastVisualField visual = new();
//			visual.spellXSpellVisualID = spellCastVisual.spellXSpellVisualID;
//			visual.scriptVisualID = spellCastVisual.scriptVisualID;
//
//			return visual;
//		}

    public SpellCastVisual clone() {
        SpellCastVisual varCopy = new spellCastVisual();

        varCopy.spellXSpellVisualID = this.spellXSpellVisualID;
        varCopy.scriptVisualID = this.scriptVisualID;

        return varCopy;
    }
}
