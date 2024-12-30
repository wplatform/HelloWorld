package com.github.mmo.game.entity.vehicle;

import Framework.Constants.*;


public class VehicleSeatAddon {
    public float seatOrientationOffset;
    public float exitParameterX;
    public float exitParameterY;
    public float exitParameterZ;
    public float exitParameterO;
    public VehicleExitParameters exitParameter = VehicleExitParameters.values()[0];

    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public VehicleSeatAddon(float orientatonOffset, float exitX, float exitY, float exitZ, float exitO, byte param)
    public VehicleSeatAddon(float orientatonOffset, float exitX, float exitY, float exitZ, float exitO, byte param) {
        seatOrientationOffset = orientatonOffset;
        exitParameterX = exitX;
        exitParameterY = exitY;
        exitParameterZ = exitZ;
        exitParameterO = exitO;
        exitParameter = VehicleExitParameters.forValue(param);
    }
}