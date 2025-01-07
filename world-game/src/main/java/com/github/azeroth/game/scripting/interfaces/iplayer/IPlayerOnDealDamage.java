package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.SpellInfo;

public interface IPlayerOnDealDamage extends IScriptObject, IClassRescriction {
    void OnDamage(Player caster, Unit target, tangible.RefObject<Double> damage, SpellInfo spellProto);
}
