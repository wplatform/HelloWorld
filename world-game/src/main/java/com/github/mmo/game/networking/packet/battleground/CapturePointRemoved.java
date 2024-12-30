package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ServerPacket;

public class CapturePointRemoved extends ServerPacket {
    public ObjectGuid capturePointGUID = ObjectGuid.EMPTY;

    public CapturePointRemoved() {
        super(ServerOpcode.CapturePointRemoved);
    }

    public CapturePointRemoved(ObjectGuid capturePointGUID) {
        super(ServerOpcode.CapturePointRemoved);
        capturePointGUID = capturePointGUID;
    }

    @Override
    public void write() {
        this.writeGuid(capturePointGUID);
    }
}
