package com.github.azeroth.game.domain.vehicle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum VehicleSpell {
    RIDE_HARDCODED(46598),
    PARACHUTE(45472);
    private final int value;

}
