package com.github.azeroth.game.domain.vehicle;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum PowerType implements EnumFlag.FlagValue {
    STEAM(61),
    PYRITE(41),
    HEAT(101),
    OOZE(121),
    BLOOD(141),
    WRATH(142),
    ARCANE_ENERGY(143),
    LIFE_ENERGY(144),
    SUN_ENERGY(145),
    SWING_VELOCITY(146),
    SHADOW_FLAME_ENERGY(147),
    BLUE_POWER(148),
    PURPLE_POWER(149),
    GREEN_POWER(150),
    ORANGE_POWER(151),
    ENERGY_2(153),
    ARCANEENERGY(161),
    WIND_POWER_1(162),
    WIND_POWER_2(163),
    WIND_POWER_3(164),
    FUEL(165),
    SUN_POWER(166),
    TWILIGHT_ENERGY(169),
    VENOM(174),
    ORANGE_POWER_2(176),
    CONSUMING_FLAME(177),
    PYROCLASTIC_FRENZY(178),
    FLASHFIRE(179);

    private final int value;
}
