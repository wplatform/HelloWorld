package com.github.azeroth.game.domain.scene;


import com.github.azeroth.common.EnumFlag;

public class SceneTemplate {
    public int sceneId;
    public EnumFlag<SceneFlag> playbackFlags;
    public int scenePackageId;
    public boolean encrypted;
    public int scriptId;
}
