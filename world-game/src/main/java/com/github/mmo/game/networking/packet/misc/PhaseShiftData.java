package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.*;

import java.util.*;
public class PhaseShiftData {

    public int PhaseShiftFlag;
    public ArrayList<PhaseShiftDataPhase> phases = new ArrayList<>();
    public ObjectGuid personalGUID = ObjectGuid.EMPTY;

    public final void write(WorldPacket data) {
        data.writeInt32(PhaseShiftFlag);
        data.writeInt32(phases.size());
        data.writeGuid(personalGUID);

        for (var phaseShiftDataPhase : phases) {
            phaseShiftDataPhase.write(data);
        }
    }
}