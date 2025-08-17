package com.github.azeroth.game.domain.map;


public record MapAreaHeader(int fourcc,
                            short flags,
                            short gridArea) {
    public static final short FLAG_NONE = 0x0000;
    public static final short FLAG_NO_AREA = 0x0001;
}




