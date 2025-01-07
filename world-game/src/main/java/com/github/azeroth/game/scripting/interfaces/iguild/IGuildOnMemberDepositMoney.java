package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnMemberDepositMoney extends IScriptObject {
    void OnMemberDepositMoney(Guild guild, Player player, long amount);
}
