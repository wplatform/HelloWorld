package com.github.azeroth.game.domain.phasing;


import java.util.ArrayList;

public class TerrainSwapInfo {

    public int id;

    public ArrayList<Integer> uiMapPhaseIDs = new ArrayList<>();


    public TerrainSwapInfo(int id) {
        this.id = id;
    }
}
