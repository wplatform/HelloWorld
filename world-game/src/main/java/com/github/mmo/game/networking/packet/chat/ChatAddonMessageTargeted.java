package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import io.netty.buffer.ByteBuf;

class ChatAddonMessageTargeted extends ClientPacket {
    public String target;
    public ChatAddonMessageParams params = new ChatAddonMessageParams();
    public ObjectGuid channelGUID = null; // not optional in the packet. Optional for api reasons

    public ChatAddonMessageTargeted(ByteBuf packet) {
        super(packet);
    }

    @Override
    public void read() {
        var targetLen = this.<Integer>readBit(9);
        params.read(this);
        channelGUID = this.readPackedGuid();
        target = this.readString(targetLen);
    }
}
