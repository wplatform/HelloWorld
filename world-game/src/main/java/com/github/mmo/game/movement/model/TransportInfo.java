package com.github.mmo.game.movement.model;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.entity.object.Position;
import lombok.Data;
@Data
public class TransportInfo {

    private ObjectGuid guid;
    private Position pos;
    private byte seat;
    private int time;
    private int prevTime;
    private int vehicleId;

    void reset() {
        guid.clear();
        pos.relocate(0.0f, 0.0f, 0.0f, 0.0f);
        seat = -1;
        time = 0;
        prevTime = 0;
        vehicleId = 0;
    }
}
