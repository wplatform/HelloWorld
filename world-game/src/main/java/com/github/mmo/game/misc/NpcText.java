package com.github.mmo.game.misc;

public class NpcText {
    private NpcTextdata[] data = new NpcTextData[SharedConst.MaxNpcTextOptions];

    public final NpcTextData[] getData() {
        return data;
    }

    public final void setData(NpcTextData[] value) {
        data = value;
    }
}
