package com.github.azeroth.game.map.collision.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Distance {

    public float distance;
    public boolean hit;


    public Distance(float distance) {
        this.distance = distance;
    }
}
