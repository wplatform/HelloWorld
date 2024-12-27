package com.github.mmo.game.scripting.interfaces.iauctionhouse;

import game.*;
import com.github.mmo.game.scripting.interfaces.*;public interface IAuctionHouseOnAuctionExpire extends IScriptObject {
    void OnAuctionExpire(AuctionHouseObject ah, AuctionPosting auction);
}
