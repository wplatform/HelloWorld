package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnChargeRecoveryTimeStart extends IScriptObject, IClassRescriction {

    void OnChargeRecoveryTimeStart(Player player, int chargeCategoryId, tangible.RefObject<Integer> chargeRecoveryTime);
}
