package com.github.mmo.game.battleground.zones;



import java.util.*;

enum EotSProgressBarConsts
{
	PointMaxCapturersCount(5),
	PointRadius(70),
	ProgressBarDontShow(0),
	progressBarShow(1),
	progressBarPercentGrey(40),
	ProgressBarStateMiddle(50),
	ProgressBarHordeControlled(0),
	ProgressBarNeutralLow(30),
	ProgressBarNeutralHigh(70),
	ProgressBarAliControlled(100);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, EotSProgressBarConsts> mappings;
	private static HashMap<Integer, EotSProgressBarConsts> getMappings()
	{
		if (mappings == null)
		{
			synchronized (EotSProgressBarConsts.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, EotSProgressBarConsts>();
				}
			}
		}
		return mappings;
	}

	private EotSProgressBarConsts(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static EotSProgressBarConsts forValue(int value)
	{
		return getMappings().get(value);
	}
}
