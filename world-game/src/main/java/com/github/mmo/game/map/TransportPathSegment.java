package com.github.mmo.game.map;
public class TransportPathSegment
{
	private int segmentEndArrivalTimestamp;
	public final int getSegmentEndArrivalTimestamp()
	{
		return segmentEndArrivalTimestamp;
	}
	public final void setSegmentEndArrivalTimestamp(int value)
	{
		segmentEndArrivalTimestamp = value;
	}
	private int delay;
	public final int getDelay()
	{
		return delay;
	}
	public final void setDelay(int value)
	{
		delay = value;
	}
	private double distanceFromLegStartAtEnd;
	public final double getDistanceFromLegStartAtEnd()
	{
		return distanceFromLegStartAtEnd;
	}
	public final void setDistanceFromLegStartAtEnd(double value)
	{
		distanceFromLegStartAtEnd = value;
	}
}
