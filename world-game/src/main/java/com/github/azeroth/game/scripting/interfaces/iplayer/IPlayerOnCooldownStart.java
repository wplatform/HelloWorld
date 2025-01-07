package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.SpellInfo;

import java.time.Duration;
import java.time.LocalDateTime;


public interface IPlayerOnCooldownStart extends IScriptObject, IClassRescriction {
    void OnCooldownStart(Player player, SpellInfo spellInfo, int itemId, int categoryId, Duration cooldown, tangible.RefObject<LocalDateTime> cooldownEnd, tangible.RefObject<LocalDateTime> categoryEnd, tangible.RefObject<Boolean> onHold);
}
