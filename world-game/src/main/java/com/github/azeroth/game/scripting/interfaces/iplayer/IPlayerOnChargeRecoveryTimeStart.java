package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnChargeRecoveryTimeStart extends IScriptObject, IClassRescriction {

    void OnChargeRecoveryTimeStart(Player player, int chargeCategoryId, tangible.RefObject<Integer> chargeRecoveryTime);
}
