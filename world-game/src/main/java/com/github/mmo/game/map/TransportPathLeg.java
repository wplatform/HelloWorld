package com.github.mmo.game.map;

import java.util.*;


public class TransportPathLeg
{
	public ArrayList<TransportPathSegment> segments = new ArrayList<>();
	private int mapId;
	public final int getMapId()
	{
		return mapId;
	}
	public final void setMapId(int value)
	{
		mapId = value;
	}
	private spline<Double> spline;
	public final spline<Double> getSpline()
	{
		return spline;
	}
	public final void setSpline(spline<Double> value)
	{
		spline = value;
	}
	private int startTimestamp;
	public final int getStartTimestamp()
	{
		return startTimestamp;
	}
	public final void setStartTimestamp(int value)
	{
		startTimestamp = value;
	}
	private int duration;
	public final int getDuration()
	{
		return duration;
	}
	public final void setDuration(int value)
	{
		duration = value;
	}
}
