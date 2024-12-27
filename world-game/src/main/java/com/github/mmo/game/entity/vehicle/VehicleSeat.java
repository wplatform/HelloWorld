package com.github.mmo.game.entity.vehicle;

import game.datastorage.*;
import game.entities.VehicleSeatAddon;







public class VehicleSeat {
    public VehicleSeat seatInfo;
    public VehicleSeatAddon seatAddon;
    public PassengerInfo passenger = new PassengerInfo();

    public VehicleSeat(VehicleSeatRecord seatInfo, VehicleSeatAddon seatAddon) {
        this.seatInfo = seatInfo;
        this.seatAddon = seatAddon;
        passenger.reset();
    }

    public final boolean isEmpty() {
        return passenger.guid.isEmpty();
    }
}