package com.github.mmo.game.networking.packet.warden;


import com.github.mmo.game.networking.*;class WardenData extends ClientPacket {
    public ByteBuffer data;

    public WardenData(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var size = this.readUInt();

        if (size != 0) {
            data = new byteBuffer(this.readBytes(size));
        }
    }
}
