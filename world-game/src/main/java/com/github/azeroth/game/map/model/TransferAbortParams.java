package com.github.azeroth.game.map.model;

import com.github.azeroth.world.map.enums.TransferAbortReason;

public record TransferAbortParams(TransferAbortReason reason, byte arg, int mapDifficultyXConditionId) {

    public static final TransferAbortParams ABORT_NONE = new TransferAbortParams(TransferAbortReason.TRANSFER_ABORT_NONE);

    public TransferAbortParams(TransferAbortReason reason) {
        this(reason, (byte) 0, 0);
    }


}
