package com.github.azeroth.game.scripting.interfaces.iauctionhouse;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import game.*;

public interface IAuctionHouseOnAuctionSuccessful extends IScriptObject {
    void OnAuctionSuccessful(AuctionHouseObject ah, AuctionPosting auction);
}
