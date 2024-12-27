package com.github.mmo.game.scripting.interfaces.iauctionhouse;

import game.*;
import com.github.mmo.game.scripting.interfaces.*;
public interface IAuctionHouseOnAcutionRemove extends IScriptObject
{
	void OnAuctionRemove(AuctionHouseObject ah, AuctionPosting auction);
}
