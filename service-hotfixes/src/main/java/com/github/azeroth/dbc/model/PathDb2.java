package com.github.azeroth.dbc.model;

import com.github.azeroth.dbc.domain.PathProperty;

import java.util.List;

public record PathDb2(int id, List<DBCPosition3D> locations, List<PathProperty> properties) {

    public static PathDb2 of(int id, List<DBCPosition3D> locations, List<PathProperty> properties) {
        return new PathDb2(id, locations, properties);
    }
}
