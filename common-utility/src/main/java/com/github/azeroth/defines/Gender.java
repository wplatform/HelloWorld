package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Gender {
    GENDER_UNKNOWN(-1), GENDER_MALE(0), GENDER_FEMALE(1), GENDER_NONE(2);

    public final int value;

    public int getValue() {
        return value;
    }
}
