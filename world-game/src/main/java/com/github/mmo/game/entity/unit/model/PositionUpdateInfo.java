package com.github.mmo.game.entity.unit.model;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public
class PositionUpdateInfo {
    boolean relocated;
    boolean turned;

    void reset() {
        relocated = false;
        turned = false;
    }
}
