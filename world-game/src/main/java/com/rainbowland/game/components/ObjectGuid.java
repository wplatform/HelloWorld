package com.rainbowland.game.components;


import com.rainbowland.core.Component;

public class ObjectGuid extends Component {

    private static int NUM_CLIENT_OBJECT_TYPES = 14;


    public static final int TYPEMASK_OBJECT                 = 0x0001;
    public static final int TYPEMASK_ITEM                   = 0x0002;
    public static final int TYPEMASK_CONTAINER              = 0x0004;
    public static final int TYPEMASK_AZERITE_EMPOWERED_ITEM = 0x0008;
    public static final int TYPEMASK_AZERITE_ITEM           = 0x0010;
    public static final int TYPEMASK_UNIT                   = 0x0020;
    public static final int TYPEMASK_PLAYER                 = 0x0040;
    public static final int TYPEMASK_ACTIVE_PLAYER          = 0x0080;
    public static final int TYPEMASK_GAMEOBJECT             = 0x0100;
    public static final int TYPEMASK_DYNAMICOBJECT          = 0x0200;
    public static final int TYPEMASK_CORPSE                 = 0x0400;
    public static final int TYPEMASK_AREATRIGGER            = 0x0800;
    public static final int TYPEMASK_SCENEOBJECT            = 0x1000;
    public static final int TYPEMASK_CONVERSATION           = 0x2000;
    public static final int TYPEMASK_SEER                   = TYPEMASK_PLAYER | TYPEMASK_UNIT | TYPEMASK_DYNAMICOBJECT;

    enum TypeID {
        OBJECT,
        ITEM,
        CONTAINER,
        AZERITE_EMPOWERED_ITEM,
        AZERITE_ITEM,
        UNIT,
        PLAYER,
        ACTIVE_PLAYER,
        GAMEOBJECT,
        DYNAMICOBJECT,
        CORPSE,
        AREATRIGGER,
        SCENEOBJECT,
        CONVERSATION
    }
}
