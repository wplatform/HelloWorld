package com.rainbowland.service.realm;

import lombok.Data;

@Data
public class RealmBuildInfo {

    public static final int HOTFIX_VERSION_LENGTH = 4;
    public static final int AUTH_SEED_LENGTH = 16;

    private int build;
    private int majorVersion;
    private int minorVersion;
    private int bugfixVersion;
    private char[] hotfixVersion;
    private byte[] win64AuthSeed;
    private byte[] mac64AuthSeed;

}
