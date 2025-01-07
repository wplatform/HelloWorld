package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CharacterFlags4 {
    CHARACTER_FLAG_4_TRIAL_BOOST(0x00000080),
    CHARACTER_FLAG_4_TRIAL_BOOST_LOCKED(0x00040000);
    public final int value;

}
