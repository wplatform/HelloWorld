package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.*;

final class GarrisonBuildingMapData
{
	public GarrisonBuildingMapData()
	{
	}

	public GarrisonBuildingMapData(int buildingPlotInstId, Position pos)
	{
		garrBuildingPlotInstID = buildingPlotInstId;
		pos = pos;
	}

	public void write(WorldPacket data)
	{
        data.writeInt32(garrBuildingPlotInstID);
        data.writeXYZ(pos);
	}

	public int garrBuildingPlotInstID;
	public position pos;

	public GarrisonBuildingMapData clone()
	{
		GarrisonBuildingMapData varCopy = new GarrisonBuildingMapData();

		varCopy.garrBuildingPlotInstID = this.garrBuildingPlotInstID;
		varCopy.pos = this.pos;

		return varCopy;
	}
}
