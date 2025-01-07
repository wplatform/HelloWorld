package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player takes damage
public interface IPlayerOnTakeDamage extends IScriptObject, IClassRescriction {
    void OnPlayerTakeDamage(Player player, double amount, SpellSchoolMask schoolMask);
}
