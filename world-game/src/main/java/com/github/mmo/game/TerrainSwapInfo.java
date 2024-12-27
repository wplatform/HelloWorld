package com.github.mmo.game;


import java.util.ArrayList;

public class TerrainSwapInfo {

    public int id;

    public ArrayList<Integer> uiMapPhaseIDs = new ArrayList<>();

    public TerrainSwapInfo() {
    }


    public TerrainSwapInfo(int id) {
        id = id;
    }
}
