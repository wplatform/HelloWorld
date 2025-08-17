package com.github.azeroth.game.domain.areatrigger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class AreaTriggerId {
    public int id;
    public boolean isServerSide;
}
