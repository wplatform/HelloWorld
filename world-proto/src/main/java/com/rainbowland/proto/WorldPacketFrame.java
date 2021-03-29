package com.rainbowland.proto;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * World Packet Frame
 *    +--------+-------------------------+
 *    | BodyLength(4bytes)| Packet Header|
 *    | Tag(12bytes)      |              |
 *    +--------+-------------------------+
 *    | Opcode(2bytes)    | Packet Body  |
 *    | Payload           |              |
 *    +--------+-------------------------+
 */

public final class WorldPacketFrame {

    public static final Charset PROTOCOL_CHARSET = StandardCharsets.UTF_8;

    public static final int FRAME_LENGTH_FIELD_LENGTH = 4;
    public static final int TAG_BYTE_LENGTH = 12;
    public static final int HEADER_LENGTH = FRAME_LENGTH_FIELD_LENGTH + TAG_BYTE_LENGTH;

    public static final int OPCODE_POSITION = HEADER_LENGTH;






    // Packet header: 4 bytes length + 12 bytes tag data = 16 bytes

    private int length;
    private byte[] tag = new byte[TAG_BYTE_LENGTH];


    private WorldPacket payload;


    public int getOpcode() {
        if (payload instanceof RecvWorldPacket) {
            return ((RecvWorldPacket) payload).getOpcode().value();
        } else if (payload instanceof SendWorldPacket) {
            return ((SendWorldPacket) payload).getOpcode().value();
        } else {
            throw new ProtocolException("impossible!");
        }
    }

    public String getOpcodeName() {
        if (payload instanceof RecvWorldPacket) {
            return ((RecvWorldPacket) payload).getOpcode().name();
        } else if (payload instanceof SendWorldPacket) {
            return ((SendWorldPacket) payload).getOpcode().name();
        } else {
            throw new ProtocolException("impossible!");
        }
    }

    public <T extends WorldPacket> T getPayload() {
        return (T) payload;
    }

    public void setPayload(WorldPacket payload) {
        this.payload = payload;
    }

    public void setTag(byte[] tag) {
        this.tag = tag;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getTag() {
        return tag;
    }

}
