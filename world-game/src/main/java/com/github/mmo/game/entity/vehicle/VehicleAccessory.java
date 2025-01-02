package com.github.mmo.game.entity.vehicle;


//C# TO JAVA CONVERTER WARNING: Java does not allow user-defined second types. The behavior of this class may differ from the original:
//ORIGINAL LINE: public struct VehicleAccessory
public final class VehicleAccessory {
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint AccessoryEntry;
    public int accessoryEntry;
    public boolean isMinion;
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint SummonTime;
    public int summonTime;
    public byte seatId;
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte SummonedType;
    public byte summonedType;
    public VehicleAccessory() {
    }
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public VehicleAccessory(uint entry, sbyte seatId, bool isMinion, byte summonType, uint summonTime)
    public VehicleAccessory(int entry, byte seatId, boolean isMinion, byte summonType, int summonTime) {
        accessoryEntry = entry;
        this.isMinion = isMinion;
        this.summonTime = summonTime;
        this.seatId = seatId;
        summonedType = summonType;
    }

    public VehicleAccessory clone() {
        VehicleAccessory varCopy = new VehicleAccessory();

        varCopy.AccessoryEntry = this.AccessoryEntry;
        varCopy.IsMinion = this.IsMinion;
        varCopy.SummonTime = this.SummonTime;
        varCopy.SeatId = this.SeatId;
        varCopy.SummonedType = this.SummonedType;

        return varCopy;
    }
}