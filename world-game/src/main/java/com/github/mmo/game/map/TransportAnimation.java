package com.github.mmo.game.map;



import java.util.*;


public class TransportAnimation
{
	private ArrayList<Integer> path;
	private ArrayList<Integer> rotation;
	private int totalTime;
	public final int getTotalTime()
	{
		return totalTime;
	}
	public final void setTotalTime(int value)
	{
		totalTime = value;
	}
	private final HashMap<Integer, TransportAnimationRecord> path = new HashMap<Integer, TransportAnimationRecord>();
	public final HashMap<Integer, TransportAnimationRecord> getPath()
	{
		return path;
	}
	private final HashMap<Integer, TransportRotationRecord> rotations = new HashMap<Integer, TransportRotationRecord>();
	public final HashMap<Integer, TransportRotationRecord> getRotations()
	{
		return rotations;
	}

	public final TransportAnimationRecord getPrevAnimNode(int time)
	{
		if (getPath().isEmpty())
		{
			return null;
		}

		if (path == null)
		{
			path = getPath().keySet().ToList();
		}

		var reqIndex = path.indexOf(time) - 1;

		if (reqIndex != -2 && reqIndex != -1)
		{
			return getPath().get(path.get(reqIndex));
		}

		return getPath().LastOrDefault().value;
	}

	public final TransportRotationRecord getPrevAnimRotation(int time)
	{
		if (getRotations().isEmpty())
		{
			return null;
		}

		if (rotation == null)
		{
			rotation = getRotations().keySet().ToList();
		}

		var reqIndex = rotation.indexOf(time) - 1; // indexof returns -1 if index is not found, - 1 from that is -2

		if (reqIndex != -2 && reqIndex != -1)
		{
			return getRotations().get(rotation.get(reqIndex));
		}

		return getRotations().LastOrDefault().value;
	}

	public final TransportAnimationRecord getNextAnimNode(int time)
	{
		if (getPath().isEmpty())
		{
			return null;
		}

		if (getPath().containsKey(time) && (var record = getPath().get(time)) == var record)
		{
			return record;
		}

		return getPath().FirstOrDefault().value;
	}

	public final TransportRotationRecord getNextAnimRotation(int time)
	{
		if (getRotations().isEmpty())
		{
			return null;
		}

		if (getRotations().containsKey(time) && (var record = getRotations().get(time)) == var record)
		{
			return record;
		}

		return getRotations().FirstOrDefault().value;
	}
}
