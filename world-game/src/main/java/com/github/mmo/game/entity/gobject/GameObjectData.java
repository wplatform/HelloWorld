package com.github.mmo.game.entity.gobject;


import com.github.mmo.game.map.SpawnData;

public class GameObjectData extends SpawnData {
    public Quaternion rotation;

    public int animprogress;
    public GOState goState = GOState.values()[0];

    public int artKit;

    public GameObjectData() {
        super(SpawnObjectType.gameObject);
    }
}
