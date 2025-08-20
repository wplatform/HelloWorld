package com.github.azeroth.game.domain.transport;

import java.util.ArrayList;


public class TransportPathLeg {
    public ArrayList<TransportPathSegment> segments = new ArrayList<>();
    private int mapId;
    private spline<Double> spline;
    private int startTimestamp;
    private int duration;

    public final int getMapId() {
        return mapId;
    }

    public final void setMapId(int value) {
        mapId = value;
    }

    public final spline<Double> getSpline() {
        return spline;
    }

    public final void setSpline(spline<Double> value) {
        spline = value;
    }

    public final int getStartTimestamp() {
        return startTimestamp;
    }

    public final void setStartTimestamp(int value) {
        startTimestamp = value;
    }

    public final int getDuration() {
        return duration;
    }

    public final void setDuration(int value) {
        duration = value;
    }
}
