package com.github.azeroth.game.scripting.interfaces.iauctionhouse;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import game.*;

public interface IAuctionHouseOnAcutionRemove extends IScriptObject {
    void OnAuctionRemove(AuctionHouseObject ah, AuctionPosting auction);
}
