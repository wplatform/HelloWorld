package com.github.azeroth.game.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAccessory {
    private int entry;
    private int accessoryEntry;
    private byte seatId;
    private boolean isMinion;
    private byte summonType;
    private int summonTimer;
}