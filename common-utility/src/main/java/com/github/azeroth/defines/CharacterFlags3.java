package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CharacterFlags3 {
    CHARACTER_FLAG_3_LOCKED_BY_REVOKED_VAS_TRANSACTION(0x00100000),
    CHARACTER_FLAG_3_LOCKED_BY_REVOKED_CHARACTER_UPGRADE(0x80000000);
    public final int value;

}
