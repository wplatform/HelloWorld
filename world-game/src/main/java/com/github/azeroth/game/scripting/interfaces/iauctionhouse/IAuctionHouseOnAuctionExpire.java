package com.github.azeroth.game.scripting.interfaces.iauctionhouse;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import game.*;

public interface IAuctionHouseOnAuctionExpire extends IScriptObject {
    void OnAuctionExpire(AuctionHouseObject ah, AuctionPosting auction);
}
