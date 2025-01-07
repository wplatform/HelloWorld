package com.github.azeroth.game.domain.unit;

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
