package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

// Called when a player takes damage
public interface IPlayerOnTakeDamage extends IScriptObject, IClassRescriction {
    void OnPlayerTakeDamage(Player player, double amount, SpellSchoolMask schoolMask);
}
