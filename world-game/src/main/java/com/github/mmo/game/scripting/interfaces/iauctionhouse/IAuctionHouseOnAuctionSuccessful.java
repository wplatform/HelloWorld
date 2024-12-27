package com.github.mmo.game.scripting.interfaces.iauctionhouse;

import game.*;
import com.github.mmo.game.scripting.interfaces.*;
public interface IAuctionHouseOnAuctionSuccessful extends IScriptObject
{
	void OnAuctionSuccessful(AuctionHouseObject ah, AuctionPosting auction);
}
