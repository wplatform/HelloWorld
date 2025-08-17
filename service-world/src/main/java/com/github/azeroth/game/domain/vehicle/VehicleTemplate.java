package com.github.azeroth.game.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleTemplate {
    private int creatureId;
    private Duration despawnDelay;
}