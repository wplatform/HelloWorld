package com.rainbowland.worldserver.boot;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorldRealmProperties {
    private long id;
    private int type;
    private int zone;
    private int expansion;
}
