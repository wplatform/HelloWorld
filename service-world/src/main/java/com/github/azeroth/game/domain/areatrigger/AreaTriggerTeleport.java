package com.github.azeroth.game.domain.areatrigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaTriggerTeleport {
    private int id;
    private int portLocId;
}