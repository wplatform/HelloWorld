package com.github.azeroth.defines;

// Diminishing Returns Types
public enum DiminishingReturnsType {
    DRTYPE_NONE,                                // this spell is not diminished, but may have its duration limited
    DRTYPE_PLAYER,                                // this spell is diminished only when applied on players
    DRTYPE_ALL                                           // this spell is diminished in every case
}
