package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.entity.object.WorldObject;

public interface ISpellObjectTargetSelectHandler extends ITargetHookHandler
{
	void targetSelect(WorldObject targets);
}
