package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnMemberWithDrawMoney extends IScriptObject {
    void OnMemberWitdrawMoney(Guild guild, Player player, long amount, boolean isRepair);
}
