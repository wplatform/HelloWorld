package com.github.mmo.game.entity;
public interface IHasChangesMask
{
	void clearChangesMask();
	UpdateMask getUpdateMask();
}
