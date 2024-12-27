package com.github.mmo.game.entity.unit.enums;

public enum ReactStates {
    REACT_PASSIVE,
    REACT_DEFENSIVE,
    REACT_AGGRESSIVE,
    REACT_ASSIST;

    public String describeReactState()
    {
        return switch (this) {
            case REACT_PASSIVE -> "PASSIVE";
            case REACT_DEFENSIVE -> "DEFENSIVE";
            case REACT_AGGRESSIVE -> "AGGRESSIVE";
            case REACT_ASSIST -> "ASSIST";
            default -> "<Invalid react state>";
        };
    }
}
