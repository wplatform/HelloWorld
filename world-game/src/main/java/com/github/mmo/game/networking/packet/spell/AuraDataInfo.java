package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.WorldPacket;
import com.github.mmo.game.spell.AuraFlags;

import java.util.ArrayList;
import java.util.HashSet;


public class AuraDataInfo
{
    public ObjectGuid castID = ObjectGuid.EMPTY;
	public int spellID;
	public SpellCastvisual visual = new spellCastVisual();
	public Auraflags flags = AuraFlags.values()[0];
	public HashSet<Integer> activeFlags;
	public short castLevel = 1;
	public byte applications = 1;
	public int contentTuningID;
	public ObjectGuid castUnit = null;
	public Integer duration = null;
	public Integer remaining = null;
	public ArrayList<Double> points = new ArrayList<>();
	public ArrayList<Double> estimatedPoints = new ArrayList<>();
	private final ContentTuningParams contentTuning;
	private final Float timeMod;

	public final void write(WorldPacket data)
	{
        data.writeGuid(castID);
        data.writeInt32(spellID);

		visual.write(data);

		data.writeInt16((short)flags.getValue());
        data.writeInt32(activeFlags.ToUMask());
		data.writeInt16(castLevel);
		data.writeInt8(applications);
        data.writeInt32(contentTuningID);
        data.writeBit(castUnit != null);
        data.writeBit(duration != null);
        data.writeBit(remaining != null);
        data.writeBit(timeMod != null);
        data.writeBits(points.size(), 6);
        data.writeBits(estimatedPoints.size(), 6);
        data.writeBit(contentTuning != null);

		if (contentTuning != null)
		{
			contentTuning.write(data);
		}

		if (castUnit != null)
		{
            data.writeGuid(castUnit.getValue());
		}

		if (duration != null)
		{
            data.writeInt32(duration.intValue());
		}

		if (remaining != null)
		{
            data.writeInt32(remaining.intValue());
		}

		if (timeMod != null)
		{
            data.writeFloat(timeMod.floatValue());
		}

		for (var point : points)
		{
            data.writeFloat((float) point);
		}

		for (var point : estimatedPoints)
		{
            data.writeFloat((float) point);
		}
	}
}
