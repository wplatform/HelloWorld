package com.github.azeroth.game.map.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WmoLocation {
    private int groupId;
    private int nameSetId;
    private int rootId;
    private int uniqueId;
}
