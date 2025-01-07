package com.github.azeroth.game.domain.misc;

import com.github.azeroth.defines.SharedDefine;

public class NpcText {

    public int id;
    public NpcTextData[] data = new NpcTextData[SharedDefine.MAX_NPC_TEXT_OPTIONS];

}
