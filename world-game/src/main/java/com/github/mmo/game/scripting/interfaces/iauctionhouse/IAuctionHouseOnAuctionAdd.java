package com.github.mmo.game.scripting.interfaces.iauctionhouse;

import com.github.mmo.game.scripting.interfaces.IScriptObject;
import game.*;

public interface IAuctionHouseOnAuctionAdd extends IScriptObject {
    void OnAuctionAdd(AuctionHouseObject ah, AuctionPosting auction);
}
