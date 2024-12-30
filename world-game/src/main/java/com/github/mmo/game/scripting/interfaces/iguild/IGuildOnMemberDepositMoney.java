package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnMemberDepositMoney extends IScriptObject {
    void OnMemberDepositMoney(Guild guild, Player player, long amount);
}
