package com.github.mmo.game.networking.packet.character;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.entity.player.enums.PlayerLogXPReason;
import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;

public class LogXPGain extends ServerPacket {
    public ObjectGuid victim = ObjectGuid.EMPTY;
    public int original;
    public PlayerLogXPReason reason;
    public int amount;
    public float groupBonus;

    public LogXPGain() {
        super(ServerOpCode.SMSG_LOG_XP_GAIN);
    }

    @Override
    public void write() {
        this.writeGuid(victim);
        this.writeInt32(original);
        this.writeInt8((byte) reason.ordinal());
        this.writeInt32(amount);
        this.writeFloat(groupBonus);
    }
}
