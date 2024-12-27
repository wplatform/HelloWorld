package com.github.mmo.game.map;



public class TransferAbortParams
{
	private TransferAbortreason reason = TransferAbortReason.values()[0];
	public final TransferAbortReason getReason()
	{
		return reason;
	}
	public final void setReason(TransferAbortReason value)
	{
		reason = value;
	}
	private byte arg;
	public final byte getArg()
	{
		return arg;
	}
	public final void setArg(byte value)
	{
		arg = value;
	}
	private int mapDifficultyXConditionId;
	public final int getMapDifficultyXConditionId()
	{
		return mapDifficultyXConditionId;
	}
	public final void setMapDifficultyXConditionId(int value)
	{
		mapDifficultyXConditionId = value;
	}


	public TransferAbortParams(TransferAbortReason reason, byte arg)
	{
		this(reason, arg, 0);
	}

	public TransferAbortParams(TransferAbortReason reason)
	{
		this(reason, 0, 0);
	}

	public TransferAbortParams()
	{
		this(TransferAbortReason.NONE, 0, 0);
	}

	public TransferAbortParams(TransferAbortReason reason, byte arg, int mapDifficultyXConditionId)
	{
		setReason(reason);
		setArg(arg);
		setMapDifficultyXConditionId(mapDifficultyXConditionId);
	}
}
