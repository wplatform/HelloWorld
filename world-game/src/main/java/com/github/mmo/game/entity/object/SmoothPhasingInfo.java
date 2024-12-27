package com.github.mmo.game.entity.object;

public class SmoothPhasingInfo
{
	// Fields visible on client
	public ObjectGuid replaceObject = null;

	private boolean replaceActive = true;
	public final boolean getReplaceActive()
	{
		return replaceActive;
	}
	public final void setReplaceActive(boolean value)
	{
		replaceActive = value;
	}
	private boolean stopAnimKits = true;
	public final boolean getStopAnimKits()
	{
		return stopAnimKits;
	}
	public final void setStopAnimKits(boolean value)
	{
		stopAnimKits = value;
	}

	// Serverside fields
	private boolean disabled = false;
	public final boolean getDisabled()
	{
		return disabled;
	}
	public final void setDisabled(boolean value)
	{
		disabled = value;
	}

	public SmoothPhasingInfo(ObjectGuid replaceObject, boolean replaceActive, boolean stopAnimKits)
	{
        this.replaceObject = replaceObject;
		setReplaceActive(replaceActive);
		setStopAnimKits(stopAnimKits);
	}
}
