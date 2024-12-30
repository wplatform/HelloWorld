package com.github.mmo.game.entity.areatrigger.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class AreaTriggerId {
    public int id;
    public boolean isServerSide;
}
