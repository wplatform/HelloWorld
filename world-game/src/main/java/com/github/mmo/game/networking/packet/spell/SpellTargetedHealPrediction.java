package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class SpellTargetedHealPrediction {
    public ObjectGuid targetGUID = ObjectGuid.EMPTY;
    public SpellHealprediction predict = new spellHealPrediction();

    public void write(WorldPacket data) {
        data.writeGuid(targetGUID);
        predict.write(data);
    }

    public SpellTargetedHealPrediction clone() {
        SpellTargetedHealPrediction varCopy = new SpellTargetedHealPrediction();

        varCopy.targetGUID = this.targetGUID;
        varCopy.predict = this.predict;

        return varCopy;
    }
}
