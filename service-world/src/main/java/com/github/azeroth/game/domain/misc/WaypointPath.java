package com.github.azeroth.game.domain.misc;


import java.util.ArrayList;

public class WaypointPath {
    public ArrayList<WaypointNode> nodes = new ArrayList<>();
    public int id;

    public WaypointPath() {
    }

    public WaypointPath(int id, ArrayList<WaypointNode> nodes) {
        id = id;
        nodes = nodes;
    }
}
