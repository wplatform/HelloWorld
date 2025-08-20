package com.github.azeroth.game.domain.vehicle;

import game.datastorage.*;


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