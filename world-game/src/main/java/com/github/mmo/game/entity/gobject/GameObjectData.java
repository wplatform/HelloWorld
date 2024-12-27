package com.github.mmo.game.entity.gobject;


import com.github.mmo.game.map.*;// From `gameobject_template_addon`, `gameobject_overrides`

public class GameObjectData extends SpawnData {
    public Quaternion rotation;

    public int animprogress;
    public GOState goState = GOState.values()[0];

    public int artKit;

    public GameObjectData() {
        super(SpawnObjectType.gameObject);
    }
}
