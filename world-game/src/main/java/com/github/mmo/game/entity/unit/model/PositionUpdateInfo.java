package com.github.mmo.game.entity.unit.model;

import lombok.AllArgsConstructor;
import lombok.data;

@Data
@AllArgsConstructor
public
class PositionUpdateInfo {
    void reset() {
        relocated = false;
        turned = false;
    }

    boolean relocated;
    boolean turned;
}
