package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;
import com.github.mmo.game.spell.SpellInfo;

public interface IPlayerOnDealDamage extends IScriptObject, IClassRescriction {
    void OnDamage(Player caster, Unit target, tangible.RefObject<Double> damage, SpellInfo spellProto);
}
