package com.github.azeroth.game.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSeatAddon {
    private int seatEntry;
    private int seatOrientation;
    private float exitParamX;
    private float exitParamY;
    private float exitParamZ;
    private float exitParamO;
    private int exitParamValue;
}