package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE(0), FEMALE(1), NONE(2);

    public final int value;

    public static Gender valueOf(int value) {
        return switch (value) {
            case 0 -> MALE;
            case 1 -> FEMALE;
            case 2 -> NONE;
            default -> throw new NoSuchElementException("No such element for value " + value);
        };
    }
}
