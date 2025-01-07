package com.github.azeroth.game.scripting.interfaces.iauctionhouse;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import game.*;

public interface IAuctionHouseOnAuctionAdd extends IScriptObject {
    void OnAuctionAdd(AuctionHouseObject ah, AuctionPosting auction);
}
