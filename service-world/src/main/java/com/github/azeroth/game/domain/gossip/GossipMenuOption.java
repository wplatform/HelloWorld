package com.github.azeroth.game.domain.gossip;




import com.github.azeroth.common.LocalizedString;
import lombok.AllArgsConstructor;

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
