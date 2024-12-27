package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnRemoveMember extends IScriptObject
{
	void onRemoveMember(Guild guild, Player player, boolean isDisbanding, boolean isKicked);
}
