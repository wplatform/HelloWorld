package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.entity.object.Position;
import com.github.mmo.game.networking.WorldPacket;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class GarrisonPlotInfo {

    public int garrPlotInstanceID;
    public Position plotPos;

    public int plotType;

    public void write(WorldPacket data) {
        data.writeInt32(garrPlotInstanceID);
        data.writeXYZO(plotPos);
        data.writeInt32(plotType);
    }

    public GarrisonPlotInfo clone() {
        GarrisonPlotInfo varCopy = new garrisonPlotInfo();

        varCopy.garrPlotInstanceID = this.garrPlotInstanceID;
        varCopy.plotPos = this.plotPos;
        varCopy.plotType = this.plotType;

        return varCopy;
    }
}
