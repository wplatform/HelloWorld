package com.github.azeroth.game.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSeatAddon {
    private int seatEntry;
    private float seatOrientation;
    private float exitParamX;
    private float exitParamY;
    private float exitParamZ;
    private float exitParamO;
    private VehicleExitParameter exitParamValue;
}