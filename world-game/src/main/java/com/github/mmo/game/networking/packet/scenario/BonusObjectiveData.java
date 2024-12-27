package com.github.mmo.game.networking.packet.scenario;

import com.github.mmo.game.networking.*;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
final class BonusObjectiveData {
    public int bonusObjectiveID;
    public boolean objectiveComplete;

    public void write(WorldPacket data) {
        data.writeInt32(bonusObjectiveID);
        data.writeBit(objectiveComplete);
        data.flushBits();
    }

    public BonusObjectiveData clone() {
        BonusObjectiveData varCopy = new BonusObjectiveData();

        varCopy.bonusObjectiveID = this.bonusObjectiveID;
        varCopy.objectiveComplete = this.objectiveComplete;

        return varCopy;
    }
}
