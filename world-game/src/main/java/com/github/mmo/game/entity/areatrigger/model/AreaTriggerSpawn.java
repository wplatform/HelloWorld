package com.github.mmo.game.entity.areatrigger.model;


import com.github.mmo.game.map.*;

public class AreaTriggerSpawn extends SpawnData
{
	public AreatriggerId triggerId = new areaTriggerId();
	public AreaTriggershapeInfo shape = new areaTriggerShapeInfo();

	public AreaTriggerSpawn()
	{
		super(SpawnObjectType.areaTrigger);
	}
}
