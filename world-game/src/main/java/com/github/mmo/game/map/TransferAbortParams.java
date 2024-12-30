package com.github.mmo.game.map;


public class TransferAbortParams {
    private TransferAbortreason reason = TransferAbortReason.values()[0];
    private byte arg;
    private int mapDifficultyXConditionId;

    public TransferAbortParams(TransferAbortReason reason, byte arg) {
        this(reason, arg, 0);
    }

    public TransferAbortParams(TransferAbortReason reason) {
        this(reason, 0, 0);
    }

    public TransferAbortParams() {
        this(TransferAbortReason.NONE, 0, 0);
    }

    public TransferAbortParams(TransferAbortReason reason, byte arg, int mapDifficultyXConditionId) {
        setReason(reason);
        setArg(arg);
        setMapDifficultyXConditionId(mapDifficultyXConditionId);
    }

    public final TransferAbortReason getReason() {
        return reason;
    }

    public final void setReason(TransferAbortReason value) {
        reason = value;
    }

    public final byte getArg() {
        return arg;
    }

    public final void setArg(byte value) {
        arg = value;
    }

    public final int getMapDifficultyXConditionId() {
        return mapDifficultyXConditionId;
    }

    public final void setMapDifficultyXConditionId(int value) {
        mapDifficultyXConditionId = value;
    }
}
