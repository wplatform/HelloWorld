package com.github.mmo.game.service.model.gossip;




import com.github.mmo.common.LocalizedString;
import lombok.AllArgsConstructor;

import java.util.*;
@AllArgsConstructor
public class GossipMenuOption {

    public int menuId;
    public int gossipOptionId;

    public int orderIndex;
    public GossipOptionNpc optionNpc;
    public LocalizedString optionText;

    public int optionBroadcastTextId;

    public int language;
    public GossipOptionFlag flags;

    public int actionMenuId;

    public int actionPoiId;
    public Integer gossipNpcOptionId = null;
    public boolean boxCoded;

    public int boxMoney;
    public LocalizedString boxText;

    public int boxBroadcastTextId;
    public Integer spellId = null;
    public Integer overrideIconId = null;



}
