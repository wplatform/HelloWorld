package com.github.mmo.game.entity.player;



public class ActionButton
{
	public ActionButtonUpdateState UState = ActionButtonUpdateState.values()[0];

	private long packedData;
	public final long getPackedData()
	{
		return packedData;
	}
	public final void setPackedData(long value)
	{
		packedData = value;
	}

	public ActionButton()
	{
		setPackedData(0);
		UState = ActionButtonUpdateState.New;
	}

	public final ActionButtonType getButtonType()
	{
		return ActionButtonType.forValue((getPackedData() & 0xFF00000000000000) >>> 56);
	}

	public final long getAction()
	{
		return (getPackedData() & 0x00FFFFFFFFFFFFFF);
	}

	public final void setActionAndType(long action, ActionButtonType type)
	{
		var newData = action | ((long)type.getValue() << 56);

		if (newData != getPackedData() || UState == ActionButtonUpdateState.Deleted)
		{
			setPackedData(newData);

			if (UState != ActionButtonUpdateState.New)
			{
				UState = ActionButtonUpdateState.changed;
			}
		}
	}
}
