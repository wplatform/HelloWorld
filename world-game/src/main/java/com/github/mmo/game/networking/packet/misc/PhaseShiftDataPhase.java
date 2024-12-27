package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.WorldPacket;

public final class PhaseShiftDataPhase {

	public PhaseShiftDataPhase(int flags, int id) {
		this.phaseFlags = (short) flags;
		this.id = (short) id;
	}

    public void write(WorldPacket data) {
        data.writeInt16(phaseFlags);
        data.writeInt16(id);
    }

	public short phaseFlags;
	public short id;

}
