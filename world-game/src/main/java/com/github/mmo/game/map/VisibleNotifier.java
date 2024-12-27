package com.github.mmo.game.map;


import com.github.mmo.game.entity.gobject.transport;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.map.interfaces.IGridNotifierWorldObject;

import java.util.ArrayList;
import java.util.list;


public class VisibleNotifier implements IGridNotifierWorldObject
{
	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

    private com.github.mmo.game.entity.player.player player;
	public final Player getPlayer()
	{
		return player;
	}
	public final void setPlayer(Player value)
	{
		player = value;
	}
	private Updatedata data;
	public final UpdateData getData()
	{
		return data;
	}
	public final void setData(UpdateData value)
	{
		data = value;
	}
	private ArrayList<ObjectGuid> visGuids;
	public final ArrayList<ObjectGuid> getVisGuids()
	{
		return visGuids;
	}
	public final void setVisGuids(ArrayList<ObjectGuid> value)
	{
		visGuids = value;
	}
	private ArrayList<Unit> visibleNow;
	public final ArrayList<Unit> getVisibleNow()
	{
		return visibleNow;
	}
	public final void setVisibleNow(ArrayList<Unit> value)
	{
		visibleNow = value;
	}

	public VisibleNotifier(Player pl, GridType gridType)
	{
		setPlayer(pl);
		setData(new UpdateData(pl.getLocation().getMapId()));
		setVisGuids(new ArrayList<ObjectGuid>(pl.getClientGuiDs()));
		setVisibleNow(new ArrayList<Unit>());
		setGridType(gridType);
	}

	public final void visit(list<WorldObject> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var obj = objs.get(i);

            getVisGuids().remove(obj.getGUID());
			getPlayer().updateVisibilityOf(obj, getData(), getVisibleNow());
		}
	}

	public final void sendToSelf()
	{
		// at this moment i_clientGUIDs have guids that not iterate at grid level checks
		// but exist one case when this possible and object not out of range: transports
		var transport = getPlayer().<transport>GetTransport();

		if (transport)
		{
			for (var obj : transport.getPassengers())
			{
				if (getVisGuids().contains(obj.GUID))
				{
					getVisGuids().remove(obj.GUID);

					switch (obj.TypeId)
					{
						case TypeId.GameObject:
							getPlayer().updateVisibilityOf(obj.AsGameObject, getData(), getVisibleNow());

							break;
						case TypeId.PLAYER:
							getPlayer().updateVisibilityOf(obj.AsPlayer, getData(), getVisibleNow());

							if (!obj.isNeedNotify(NotifyFlag.VisibilityChanged))
							{
								obj.AsPlayer.updateVisibilityOf(getPlayer());
							}

							break;
						case TypeId.Unit:
							getPlayer().updateVisibilityOf(obj.AsCreature, getData(), getVisibleNow());

							break;
						case TypeId.DynamicObject:
							getPlayer().updateVisibilityOf(obj.AsDynamicObject, getData(), getVisibleNow());

							break;
						case TypeId.AreaTrigger:
							getPlayer().updateVisibilityOf(obj.AsAreaTrigger, getData(), getVisibleNow());

							break;
						default:
							break;
					}
				}
			}
		}

		for (var guid : getVisGuids())
		{
            getPlayer().getClientGuiDs().remove(guid);
            getData().addOutOfRangeGUID(guid);

			if (guid.isPlayer())
			{
                var pl = global.getObjAccessor().findPlayer(guid);

				if (pl != null && pl.isInWorld() && !pl.isNeedNotify(NotifyFlag.VisibilityChanged))
				{
					pl.updateVisibilityOf(getPlayer());
				}
			}
		}

		if (!getData().hasData())
		{
			return;
		}

        com.github.mmo.game.networking.packet.UpdateObject packet;
        tangible.OutObject<com.github.mmo.game.networking.packet.UpdateObject> tempOut_packet = new tangible.OutObject<com.github.mmo.game.networking.packet.UpdateObject>();
		getData().buildPacket(tempOut_packet);
	packet = tempOut_packet.outArgValue;
		getPlayer().sendPacket(packet);

		for (var obj : getVisibleNow())
		{
			getPlayer().sendInitialVisiblePackets(obj);
		}
	}
}
