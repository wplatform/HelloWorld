package com.github.azeroth.game.domain.object;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class WorldLocation extends Position {


    public static final int MAP_ID_INVALID = 0xFFFFFFFF;

    private int mapId;

    public WorldLocation() {
        super(0.f, 0.f, 0.f, 0.f);
        this.mapId = MAP_ID_INVALID;
    }

    public WorldLocation(int mapId) {
        super(0.f, 0.f, 0.f, 0.f);
        this.mapId = mapId;
    }

    public WorldLocation(int mapId, Position position) {
        super(position.getX(), position.getY(), position.getZ(), position.getO());
        this.mapId = mapId;
    }

    public WorldLocation(int mapId, float x, float y) {
        super(x, y, 0f, 0f);
        this.mapId = mapId;
    }

    public WorldLocation(int mapId, float x, float y, float z) {
        super(x, y, z);
        this.mapId = mapId;
    }

    public WorldLocation(int mapId, float x, float y, float z, float o) {
        super(x, y, z, o);
        this.mapId = mapId;
    }


    public void worldRelocate(WorldLocation loc) {
        mapId = loc.getMapId();
        relocate(loc);
    }

    public void worldRelocate(int mapId, Position pos) {
        this.mapId = mapId;
        relocate(pos);
    }

    public void worldRelocate(int mapId, float x, float y, float z, float o) {
        this.mapId = mapId;
        relocate(x, y, z, o);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorldLocation that)) return false;
        if (!super.equals(o)) return false;

        return mapId == that.mapId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mapId);
    }

    @Override
    public String toString() {
        return "WorldLocation{mapId=%d, position=%s}".formatted(mapId, super.toString());
    }
}
