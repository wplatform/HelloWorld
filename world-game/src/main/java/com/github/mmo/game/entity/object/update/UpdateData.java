package com.github.mmo.game.entity.object.update;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.WorldPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class UpdateData {
    private final ArrayList<ObjectGuid> destroyGUIDs = new ArrayList<>();
    private final ArrayList<ObjectGuid> outOfRangeGUIDs = new ArrayList<>();
    private final int mapId;
    CompositeByteBuf compositeByteBuf = ByteBufAllocator.DEFAULT.compositeBuffer();
    private int blockCount;

    public final void addDestroyObject(ObjectGuid guid) {
        destroyGUIDs.add(guid);
    }

    public final void addOutOfRangeGUID(ArrayList<ObjectGuid> guids) {
        outOfRangeGUIDs.addAll(guids);
    }

    public final void addOutOfRangeGUID(ObjectGuid guid) {
        outOfRangeGUIDs.add(guid);
    }

    public final void addUpdateBlock(WorldPacket block) {
        compositeByteBuf.addComponent(block.content());
        ++blockCount;
    }

    public WorldPacket buildPacket() {

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(200);
        WorldPacket head = WorldPacket.wrap(byteBuf);

        head.writeInt32(blockCount);
        head.writeInt16(mapId);

        if (head.writeBit(!outOfRangeGUIDs.isEmpty() || !destroyGUIDs.isEmpty())) {
            head.writeInt16(destroyGUIDs.size());
            head.writeInt32(destroyGUIDs.size() + outOfRangeGUIDs.size());

            for (var destroyGuid : destroyGUIDs) {
                head.writeGuid(destroyGuid);
            }

            for (var outOfRangeGuid : outOfRangeGUIDs) {
                head.writeGuid(outOfRangeGuid);
            }
        }
        head.writeInt32(compositeByteBuf.writerIndex());
        compositeByteBuf.addComponent(0, head.content());
        return WorldPacket.newServerToClient(ServerOpCode.SMSG_UPDATE_OBJECT, compositeByteBuf);
    }

    public final void clear() {
        compositeByteBuf.clear();
        destroyGUIDs.clear();
        outOfRangeGUIDs.clear();
        blockCount = 0;

    }

    public final boolean hasData() {
        return blockCount > 0 || !outOfRangeGUIDs.isEmpty() || !destroyGUIDs.isEmpty();
    }

    public final ArrayList<ObjectGuid> getOutOfRangeGUIDs() {
        return outOfRangeGUIDs;
    }


    public void close() {
        compositeByteBuf.release();
    }
}
