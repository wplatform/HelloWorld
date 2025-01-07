package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum PhaseEntryFlags implements EnumFlag.FlagValue {
    ReadOnly(0x001),
    InternalPhase(0x002),
    Normal(0x008),
    Cosmetic(0x010),
    Personal(0x020),
    Expensive(0x040),
    EventsAreObservable(0x080),
    UsesPreloadConditions(0x100),
    UnshareablePersonal(0x200),
    ObjectsAreVisible(0x400);

    public final int value;
}
