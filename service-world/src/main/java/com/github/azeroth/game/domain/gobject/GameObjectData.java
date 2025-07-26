package com.github.azeroth.game.domain.gobject;


import com.github.azeroth.defines.GOState;
import com.github.azeroth.game.domain.spawn.SpawnData;
import com.github.azeroth.game.domain.spawn.SpawnObjectType;

public class GameObjectData extends SpawnData {

    public QuaternionData rotation;

    public int animProgress;
    public GOState goState;

    public int artKit;

    public GameObjectData() {
        type = SpawnObjectType.GAME_OBJECT;
    }


}
