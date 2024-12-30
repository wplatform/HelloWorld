package com.github.mmo.game.networking.packet.misc;


public class PlayMusic extends ServerPacket {
    private final int soundKitID;

    public PlayMusic(int soundKitID) {
        super(ServerOpcode.PlayMusic);
        soundKitID = soundKitID;
    }

    @Override
    public void write() {
        this.writeInt32(soundKitID);
    }
}
