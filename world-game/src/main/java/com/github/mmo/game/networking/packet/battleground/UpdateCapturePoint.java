package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ServerPacket;

public class UpdateCapturePoint extends ServerPacket {
    public BattlegroundcapturePointInfo capturePointInfo;

    public updateCapturePoint() {
        super(ServerOpcode.UpdateCapturePoint);
    }

    @Override
    public void write() {
        capturePointInfo.write(this);
    }
}
