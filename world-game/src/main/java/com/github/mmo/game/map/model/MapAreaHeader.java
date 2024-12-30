package com.github.mmo.game.map.model;


public record MapAreaHeader(int fourcc,
                            short flags,
                            short gridArea) {
    static final short FLAG_NONE = 0x0000;
    static final short FLAG_NO_AREA = 0x0001;
}




