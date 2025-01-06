package com.github.mmo.game.domain.scene;


import com.github.mmo.common.EnumFlag;

public class SceneTemplate {
    public int sceneId;
    public EnumFlag<SceneFlag> playbackFlags;
    public int scenePackageId;
    public boolean encrypted;
    public int scriptId;
}
