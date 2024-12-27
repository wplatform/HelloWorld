package com.github.mmo.game.scripting.interfaces.iauctionhouse;

import game.*;
import com.github.mmo.game.scripting.interfaces.*;
public interface IAuctionHouseOnAuctionAdd extends IScriptObject
{
	void OnAuctionAdd(AuctionHouseObject ah, AuctionPosting auction);
}
