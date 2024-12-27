package com.github.mmo.game.dungeonfinding;


import com.github.mmo.game.networking.packet.rideTicket;

import java.util.ArrayList;


public class LFGPlayerData
{
	// General
	private RideTicket m_Ticket;
	private LfgState m_State = LfgState.values()[0];

	private LfgState m_OldState = LfgState.values()[0];

	// Player
	private TeamFaction m_Team = TeamFaction.values()[0];
    private ObjectGuid m_Group = ObjectGuid.EMPTY;

	// Queue
	private LfgRoles m_Roles = LfgRoles.values()[0];
	private ArrayList<Integer> m_SelectedDungeons = new ArrayList<>();

	// Achievement-related
	private byte m_NumberOfPartyMembersAtJoin;

	public LFGPlayerData()
	{
		m_State = LfgState.NONE;
		m_OldState = LfgState.NONE;
	}

	public final void setTicket(RideTicket ticket)
	{
		m_Ticket = ticket;
	}

	public final void setState(LfgState state)
	{
		switch (state)
		{
			case None:
			case FinishedDungeon:
				m_Roles = LfgRoles.forValue(0);
				m_SelectedDungeons.clear();
			case Dungeon:
				m_OldState = state;

				break;
		}

		m_State = state;
	}

	public final void restoreState()
	{
		if (m_OldState == LfgState.NONE)
		{
			m_SelectedDungeons.clear();
			m_Roles = LfgRoles.forValue(0);
		}

		m_State = m_OldState;
	}

	public final void setTeam(TeamFaction team)
	{
		m_Team = team;
	}

	public final void setGroup(ObjectGuid group)
	{
        m_Group = group;
	}

	public final void setRoles(LfgRoles roles)
	{
		m_Roles = roles;
	}

	public final void setSelectedDungeons(ArrayList<Integer> dungeons)
	{
		m_SelectedDungeons = dungeons;
	}

	public final RideTicket getTicket()
	{
		return m_Ticket;
	}

	public final LfgState getState()
	{
		return m_State;
	}

	public final LfgState getOldState()
	{
		return m_OldState;
	}

	public final TeamFaction getTeam()
	{
		return m_Team;
	}

	public final ObjectGuid getGroup()
	{
        return m_Group;
	}

	public final LfgRoles getRoles()
	{
		return m_Roles;
	}

	public final ArrayList<Integer> getSelectedDungeons()
	{
		return m_SelectedDungeons;
	}

	public final void setNumberOfPartyMembersAtJoin(byte count)
	{
		m_NumberOfPartyMembersAtJoin = count;
	}

	public final byte getNumberOfPartyMembersAtJoin()
	{
		return m_NumberOfPartyMembersAtJoin;
	}
}
