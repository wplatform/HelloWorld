package com.github.mmo.game.service.model.misc;

import com.github.mmo.defines.SharedDefine;

public class NpcText {

    public int id;
    public NpcTextData[] data = new NpcTextData[SharedDefine.MAX_NPC_TEXT_OPTIONS];

}
