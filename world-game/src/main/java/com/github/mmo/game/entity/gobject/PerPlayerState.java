package com.github.mmo.game.entity.gobject;



import java.time.*;


public class PerPlayerState
{
	public GOState state = null;
	private LocalDateTime validUntil = LocalDateTime.MIN;
	public final LocalDateTime getValidUntil()
	{
		return validUntil;
	}
	public final void setValidUntil(LocalDateTime value)
	{
		validUntil = value;
	}
	private boolean despawned;
	public final boolean getDespawned()
	{
		return despawned;
	}
	public final void setDespawned(boolean value)
	{
		despawned = value;
	}
}
