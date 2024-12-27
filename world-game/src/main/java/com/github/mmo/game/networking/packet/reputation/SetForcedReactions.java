package com.github.mmo.game.networking.packet.reputation;


import com.github.mmo.game.networking.*;
import com.github.mmo.game.networking.opcode.ServerOpCode;

import java.util.*;

public class SetForcedReactions extends ServerPacket {
    public ArrayList<ForcedReaction> reactions = new ArrayList<>();

    public SetForcedReactions() {
        super(ServerOpCode.SMSG_SET_FORCED_REACTIONS);
    }

    @Override
    public void write() {
        this.writeInt32(reactions.size());

        for (var reaction : reactions) {
            reaction.write(this);
        }
    }
}
