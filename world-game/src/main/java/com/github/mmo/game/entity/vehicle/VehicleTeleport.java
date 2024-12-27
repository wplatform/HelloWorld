package com.github.mmo.game.entity.vehicle;


//C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
//ORIGINAL LINE: public struct VehicleTeleport
public final class VehicleTeleport {
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte VehicleSeatIndex;
    public byte vehicleSeatIndex;
    public boolean vehicleExitVoluntary;
    public boolean vehicleExitTeleport;

    public VehicleTeleport clone() {
        VehicleTeleport varCopy = new VehicleTeleport();

        varCopy.VehicleSeatIndex = this.VehicleSeatIndex;
        varCopy.VehicleExitVoluntary = this.VehicleExitVoluntary;
        varCopy.VehicleExitTeleport = this.VehicleExitTeleport;

        return varCopy;
    }
}