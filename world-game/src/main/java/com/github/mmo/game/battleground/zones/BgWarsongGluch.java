package com.github.mmo.game.battleground.zones;



import com.github.mmo.game.WorldSafeLocsEntry;
import com.github.mmo.game.battleground.*;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.player.Player;

class BgWarsongGluch extends Battleground
{
	private static final int EXPLOITTELEPORTLOCATIONALLIANCE = 3784;
	private static final int EXPLOITTELEPORTLOCATIONHORDE = 3785;

	private final ObjectGuid[] m_FlagKeepers = new ObjectGuid[2]; // 0 - alliance, 1 - horde
	private final ObjectGuid[] m_DroppedFlagGUID = new ObjectGuid[2];
	private final WSGFlagState[] flagState = new WSGFlagState[2]; // for checking flag state
	private final int[] flagsTimer = new int[2];
	private final int[] flagsDropTimer = new int[2];

	private final int[][] honor =
	{
		new int[] {20, 40, 40},
		new int[] {60, 40, 80}
	};

	private int lastFlagCaptureTeam; // Winner is based on this if score is equal

	private int m_ReputationCapture;
	private int m_HonorWinKills;
	private int m_HonorEndKills;
	private int flagSpellForceTimer;
	private boolean bothFlagsKept;
	private byte flagDebuffState; // 0 - no debuffs, 1 - focused assault, 2 - brutal assault

	public BgWarsongGluch(BattlegroundTemplate battlegroundTemplate)
	{
		super(battlegroundTemplate);
		bgObjects = new ObjectGuid[WSGObjectTypes.Max];
		bgCreatures = new ObjectGuid[WSGCreatureTypes.Max];

		StartMessageIds[BattlegroundConst.EventIdSecond] = WSGBroadcastTexts.startOneMinute;
		StartMessageIds[BattlegroundConst.EventIdThird] = WSGBroadcastTexts.startHalfMinute;
		StartMessageIds[BattlegroundConst.EventIdFourth] = WSGBroadcastTexts.battleHasBegun;
	}

	@Override
	public void postUpdateImpl(int diff)
	{
		if (getStatus() == BattlegroundStatus.inProgress)
		{
			if (getElapsedTime() >= 17 * time.Minute * time.InMilliseconds)
			{
				if (getTeamScore(TeamIds.Alliance) == 0)
				{
					if (getTeamScore(TeamIds.Horde) == 0) // No one scored - result is tie
					{
						endBattleground(TeamFaction.other);
					}
					else // Horde has more points and thus wins
					{
						endBattleground(TeamFaction.Horde);
					}
				}
				else if (getTeamScore(TeamIds.Horde) == 0)
				{
					endBattleground(TeamFaction.Alliance); // Alliance has > 0, Horde has 0, alliance wins
				}
				else if (getTeamScore(TeamIds.Horde) == getTeamScore(TeamIds.Alliance)) // Team score equal, winner is team that scored the last flag
				{
					endBattleground(TeamFaction.forValue(lastFlagCaptureTeam));
				}
				else if (getTeamScore(TeamIds.Horde) > getTeamScore(TeamIds.Alliance)) // Last but not least, check who has the higher score
				{
					endBattleground(TeamFaction.Horde);
				}
				else
				{
					endBattleground(TeamFaction.Alliance);
				}
			}

			if (_flagState[TeamIds.Alliance] == WSGFlagState.WaitRespawn)
			{
				_flagsTimer[TeamIds.Alliance] -= (int)diff;

				if (_flagsTimer[TeamIds.Alliance] < 0)
				{
					_flagsTimer[TeamIds.Alliance] = 0;
					respawnFlag(TeamFaction.Alliance, true);
				}
			}

			if (_flagState[TeamIds.Alliance] == WSGFlagState.OnGround)
			{
				_flagsDropTimer[TeamIds.Alliance] -= (int)diff;

				if (_flagsDropTimer[TeamIds.Alliance] < 0)
				{
					_flagsDropTimer[TeamIds.Alliance] = 0;
					respawnFlagAfterDrop(TeamFaction.Alliance);
					bothFlagsKept = false;
				}
			}

			if (_flagState[TeamIds.Horde] == WSGFlagState.WaitRespawn)
			{
				_flagsTimer[TeamIds.Horde] -= (int)diff;

				if (_flagsTimer[TeamIds.Horde] < 0)
				{
					_flagsTimer[TeamIds.Horde] = 0;
					respawnFlag(TeamFaction.Horde, true);
				}
			}

			if (_flagState[TeamIds.Horde] == WSGFlagState.OnGround)
			{
				_flagsDropTimer[TeamIds.Horde] -= (int)diff;

				if (_flagsDropTimer[TeamIds.Horde] < 0)
				{
					_flagsDropTimer[TeamIds.Horde] = 0;
					respawnFlagAfterDrop(TeamFaction.Horde);
					bothFlagsKept = false;
				}
			}

			if (bothFlagsKept)
			{
				flagSpellForceTimer += (int)diff;

				if (flagDebuffState == 0 && flagSpellForceTimer >= 10 * time.Minute * time.InMilliseconds) //10 minutes
				{
					// Apply Stage 1 (Focused Assault)
                    var player = global.getObjAccessor().findPlayer(m_FlagKeepers[0]);

					if (player)
					{
						player.castSpell(player, WSGSpellId.focusedAssault, true);
					}

                    player = global.getObjAccessor().findPlayer(m_FlagKeepers[1]);

					if (player)
					{
						player.castSpell(player, WSGSpellId.focusedAssault, true);
					}

					flagDebuffState = 1;
				}
				else if (flagDebuffState == 1 && flagSpellForceTimer >= 900000) //15 minutes
				{
					// Apply Stage 2 (Brutal Assault)
                    var player = global.getObjAccessor().findPlayer(m_FlagKeepers[0]);

					if (player)
					{
						player.removeAura(WSGSpellId.focusedAssault);
						player.castSpell(player, WSGSpellId.brutalAssault, true);
					}

                    player = global.getObjAccessor().findPlayer(m_FlagKeepers[1]);

					if (player)
					{
						player.removeAura(WSGSpellId.focusedAssault);
						player.castSpell(player, WSGSpellId.brutalAssault, true);
					}

					flagDebuffState = 2;
				}
			}
			else if ((_flagState[TeamIds.Alliance] == WSGFlagState.OnBase || _flagState[TeamIds.Alliance] == WSGFlagState.WaitRespawn) && (_flagState[TeamIds.Horde] == WSGFlagState.OnBase || _flagState[TeamIds.Horde] == WSGFlagState.WaitRespawn))
			{
				// Both flags are in base or awaiting respawn.
				// Remove assault debuffs, reset timers

                var player = global.getObjAccessor().findPlayer(m_FlagKeepers[0]);

				if (player)
				{
					player.removeAura(WSGSpellId.focusedAssault);
					player.removeAura(WSGSpellId.brutalAssault);
				}

                player = global.getObjAccessor().findPlayer(m_FlagKeepers[1]);

				if (player)
				{
					player.removeAura(WSGSpellId.focusedAssault);
					player.removeAura(WSGSpellId.brutalAssault);
				}

				flagSpellForceTimer = 0; //reset timer.
				flagDebuffState = 0;
			}
		}
	}

	@Override
	public void startingEventCloseDoors()
	{
		for (var i = WSGObjectTypes.DOORA1; i <= WSGObjectTypes.DOORH4; ++i)
		{
			doorClose(i);
			spawnBGObject(i, BattlegroundConst.RespawnImmediately);
		}

		for (var i = WSGObjectTypes.AFlag; i <= WSGObjectTypes.BERSERKBUFF2; ++i)
		{
			spawnBGObject(i, BattlegroundConst.RespawnOneDay);
		}
	}

	@Override
	public void startingEventOpenDoors()
	{
		for (var i = WSGObjectTypes.DOORA1; i <= WSGObjectTypes.DOORA6; ++i)
		{
			doorOpen(i);
		}

		for (var i = WSGObjectTypes.DOORH1; i <= WSGObjectTypes.DOORH4; ++i)
		{
			doorOpen(i);
		}

		for (var i = WSGObjectTypes.AFlag; i <= WSGObjectTypes.BERSERKBUFF2; ++i)
		{
			spawnBGObject(i, BattlegroundConst.RespawnImmediately);
		}

		spawnBGObject(WSGObjectTypes.DOORA5, BattlegroundConst.RespawnOneDay);
		spawnBGObject(WSGObjectTypes.DOORA6, BattlegroundConst.RespawnOneDay);
		spawnBGObject(WSGObjectTypes.DOORH3, BattlegroundConst.RespawnOneDay);
		spawnBGObject(WSGObjectTypes.DOORH4, BattlegroundConst.RespawnOneDay);

		updateWorldState(WSGWorldStates.stateTimerActive, 1);
		updateWorldState(WSGWorldStates.stateTimer, (int)(gameTime.GetGameTime() + 15 * time.Minute));

		// players joining later are not eligibles
		triggerGameEvent(8563);
	}

	@Override
	public void addPlayer(Player player)
	{
        var isInBattleground = isPlayerInBattleground(player.getGUID());
		super.addPlayer(player);

		if (!isInBattleground)
		{
            playerScores.put(player.getGUID(), new BattlegroundWGScore(player.getGUID(), player.getBgTeam()));
		}
	}

	@Override
	public void eventPlayerDroppedFlag(Player player)
	{
        var team = getPlayerTeam(player.getGUID());

		if (getStatus() != BattlegroundStatus.inProgress)
		{
			// if not running, do not cast things at the dropper player (prevent spawning the "dropped" flag), neither send unnecessary messages
			// just take off the aura
			if (team == TeamFaction.Alliance)
			{
				if (!isHordeFlagPickedup())
				{
					return;
				}

				if (Objects.equals(getFlagPickerGUID(TeamIds.Horde), player.getGUID()))
				{
					setHordeFlagPicker(ObjectGuid.Empty);
					player.removeAura(WSGSpellId.warsongFlag);
				}
			}
			else
			{
				if (!isAllianceFlagPickedup())
				{
					return;
				}

				if (Objects.equals(getFlagPickerGUID(TeamIds.Alliance), player.getGUID()))
				{
					setAllianceFlagPicker(ObjectGuid.Empty);
					player.removeAura(WSGSpellId.silverwingFlag);
				}
			}

			return;
		}

		var set = false;

		if (team == TeamFaction.Alliance)
		{
			if (!isHordeFlagPickedup())
			{
				return;
			}

			if (Objects.equals(getFlagPickerGUID(TeamIds.Horde), player.getGUID()))
			{
				setHordeFlagPicker(ObjectGuid.Empty);
				player.removeAura(WSGSpellId.warsongFlag);

				if (flagDebuffState == 1)
				{
					player.removeAura(WSGSpellId.focusedAssault);
				}
				else if (flagDebuffState == 2)
				{
					player.removeAura(WSGSpellId.brutalAssault);
				}

				_flagState[TeamIds.Horde] = WSGFlagState.OnGround;
				player.castSpell(player, WSGSpellId.warsongFlagDropped, true);
				set = true;
			}
		}
		else
		{
			if (!isAllianceFlagPickedup())
			{
				return;
			}

			if (Objects.equals(getFlagPickerGUID(TeamIds.Alliance), player.getGUID()))
			{
				setAllianceFlagPicker(ObjectGuid.Empty);
				player.removeAura(WSGSpellId.silverwingFlag);

				if (flagDebuffState == 1)
				{
					player.removeAura(WSGSpellId.focusedAssault);
				}
				else if (flagDebuffState == 2)
				{
					player.removeAura(WSGSpellId.brutalAssault);
				}

				_flagState[TeamIds.Alliance] = WSGFlagState.OnGround;
				player.castSpell(player, WSGSpellId.silverwingFlagDropped, true);
				set = true;
			}
		}

		if (set)
		{
			player.castSpell(player, BattlegroundConst.SpellRecentlyDroppedFlag, true);
			updateFlagState(team, WSGFlagState.OnGround);

			if (team == TeamFaction.Alliance)
			{
				sendBroadcastText(WSGBroadcastTexts.hordeFlagDropped, ChatMsg.BgSystemHorde, player);
			}
			else
			{
				sendBroadcastText(WSGBroadcastTexts.allianceFlagDropped, ChatMsg.BgSystemAlliance, player);
			}

			_flagsDropTimer[GetTeamIndexByTeamId(getOtherTeam(team))] = WSGTimerOrScore.FLAGDROPTIME;
		}
	}

	@Override
	public void eventPlayerClickedOnFlag(Player player, GameObject target_obj)
	{
		if (getStatus() != BattlegroundStatus.inProgress)
		{
			return;
		}

        var team = getPlayerTeam(player.getGUID());

		//alliance flag picked up from base
		if (team == TeamFaction.Horde && getFlagState(TeamFaction.Alliance) == WSGFlagState.OnBase && Objects.equals(BgObjects[WSGObjectTypes.AFlag], target_obj.getGUID()))
		{
			sendBroadcastText(WSGBroadcastTexts.allianceFlagPickedUp, ChatMsg.BgSystemHorde, player);
			playSoundToAll(WSGSound.allianceFlagPickedUp);
			spawnBGObject(WSGObjectTypes.AFlag, BattlegroundConst.RespawnOneDay);
            setAllianceFlagPicker(player.getGUID());
			_flagState[TeamIds.Alliance] = WSGFlagState.OnPlayer;
			//update world state to show correct flag carrier
			updateFlagState(TeamFaction.Horde, WSGFlagState.OnPlayer);
			player.castSpell(player, WSGSpellId.silverwingFlag, true);
			player.startCriteriaTimer(CriteriaStartEvent.BeSpellTarget, WSGSpellId.silverwingFlagPicked);

			if (_flagState[1] == WSGFlagState.OnPlayer)
			{
				bothFlagsKept = true;
			}

			if (flagDebuffState == 1)
			{
				player.castSpell(player, WSGSpellId.focusedAssault, true);
			}
			else if (flagDebuffState == 2)
			{
				player.castSpell(player, WSGSpellId.brutalAssault, true);
			}
		}

		//horde flag picked up from base
		if (team == TeamFaction.Alliance && getFlagState(TeamFaction.Horde) == WSGFlagState.OnBase && Objects.equals(BgObjects[WSGObjectTypes.HFlag], target_obj.getGUID()))
		{
			sendBroadcastText(WSGBroadcastTexts.hordeFlagPickedUp, ChatMsg.BgSystemAlliance, player);
			playSoundToAll(WSGSound.hordeFlagPickedUp);
			spawnBGObject(WSGObjectTypes.HFlag, BattlegroundConst.RespawnOneDay);
            setHordeFlagPicker(player.getGUID());
			_flagState[TeamIds.Horde] = WSGFlagState.OnPlayer;
			//update world state to show correct flag carrier
			updateFlagState(TeamFaction.Alliance, WSGFlagState.OnPlayer);
			player.castSpell(player, WSGSpellId.warsongFlag, true);
			player.startCriteriaTimer(CriteriaStartEvent.BeSpellTarget, WSGSpellId.warsongFlagPicked);

			if (_flagState[0] == WSGFlagState.OnPlayer)
			{
				bothFlagsKept = true;
			}

			if (flagDebuffState == 1)
			{
				player.castSpell(player, WSGSpellId.focusedAssault, true);
			}
			else if (flagDebuffState == 2)
			{
				player.castSpell(player, WSGSpellId.brutalAssault, true);
			}
		}

		//Alliance flag on ground(not in base) (returned or picked up again from ground!)
		if (getFlagState(TeamFaction.Alliance) == WSGFlagState.OnGround && player.isWithinDistInMap(target_obj, 10) && target_obj.getTemplate().entry == WSGObjectEntry.AFlagGround)
		{
			if (team == TeamFaction.Alliance)
			{
				sendBroadcastText(WSGBroadcastTexts.allianceFlagReturned, ChatMsg.BgSystemAlliance, player);
				updateFlagState(TeamFaction.Horde, WSGFlagState.WaitRespawn);
				respawnFlag(TeamFaction.Alliance, false);
				spawnBGObject(WSGObjectTypes.AFlag, BattlegroundConst.RespawnImmediately);
				playSoundToAll(WSGSound.flagReturned);
				updatePlayerScore(player, ScoreType.flagReturns, 1);
				bothFlagsKept = false;

				handleFlagRoomCapturePoint(TeamIds.Horde); // Check Horde flag if it is in capture zone; if so, capture it
			}
			else
			{
				sendBroadcastText(WSGBroadcastTexts.allianceFlagPickedUp, ChatMsg.BgSystemHorde, player);
				playSoundToAll(WSGSound.allianceFlagPickedUp);
				spawnBGObject(WSGObjectTypes.AFlag, BattlegroundConst.RespawnOneDay);
                setAllianceFlagPicker(player.getGUID());
				player.castSpell(player, WSGSpellId.silverwingFlag, true);
				_flagState[TeamIds.Alliance] = WSGFlagState.OnPlayer;
				updateFlagState(TeamFaction.Horde, WSGFlagState.OnPlayer);

				if (flagDebuffState == 1)
				{
					player.castSpell(player, WSGSpellId.focusedAssault, true);
				}
				else if (flagDebuffState == 2)
				{
					player.castSpell(player, WSGSpellId.brutalAssault, true);
				}
			}
			//called in HandleGameObjectUseOpcode:
			//target_obj.delete();
		}

		//Horde flag on ground(not in base) (returned or picked up again)
		if (getFlagState(TeamFaction.Horde) == WSGFlagState.OnGround && player.isWithinDistInMap(target_obj, 10) && target_obj.getTemplate().entry == WSGObjectEntry.HFlagGround)
		{
			if (team == TeamFaction.Horde)
			{
				sendBroadcastText(WSGBroadcastTexts.hordeFlagReturned, ChatMsg.BgSystemHorde, player);
				updateFlagState(TeamFaction.Alliance, WSGFlagState.WaitRespawn);
				respawnFlag(TeamFaction.Horde, false);
				spawnBGObject(WSGObjectTypes.HFlag, BattlegroundConst.RespawnImmediately);
				playSoundToAll(WSGSound.flagReturned);
				updatePlayerScore(player, ScoreType.flagReturns, 1);
				bothFlagsKept = false;

				handleFlagRoomCapturePoint(TeamIds.Alliance); // Check Alliance flag if it is in capture zone; if so, capture it
			}
			else
			{
				sendBroadcastText(WSGBroadcastTexts.hordeFlagPickedUp, ChatMsg.BgSystemAlliance, player);
				playSoundToAll(WSGSound.hordeFlagPickedUp);
				spawnBGObject(WSGObjectTypes.HFlag, BattlegroundConst.RespawnOneDay);
                setHordeFlagPicker(player.getGUID());
				player.castSpell(player, WSGSpellId.warsongFlag, true);
				_flagState[TeamIds.Horde] = WSGFlagState.OnPlayer;
				updateFlagState(TeamFaction.Alliance, WSGFlagState.OnPlayer);

				if (flagDebuffState == 1)
				{
					player.castSpell(player, WSGSpellId.focusedAssault, true);
				}
				else if (flagDebuffState == 2)
				{
					player.castSpell(player, WSGSpellId.brutalAssault, true);
				}
			}
			//called in HandleGameObjectUseOpcode:
			//target_obj.delete();
		}

		player.removeAurasWithInterruptFlags(SpellAuraInterruptFlags.PvPActive);
	}

	@Override
	public void removePlayer(Player player, ObjectGuid guid, TeamFaction team)
	{
		// sometimes flag aura not removed :(
		if (isAllianceFlagPickedup() && Objects.equals(m_FlagKeepers[TeamIds.Alliance], guid))
		{
			if (!player)
			{
				Log.outError(LogFilter.Battleground, "BattlegroundWS: Removing offline player who has the FLAG!!");
				setAllianceFlagPicker(ObjectGuid.Empty);
				respawnFlag(TeamFaction.Alliance, false);
			}
			else
			{
				eventPlayerDroppedFlag(player);
			}
		}

		if (isHordeFlagPickedup() && Objects.equals(m_FlagKeepers[TeamIds.Horde], guid))
		{
			if (!player)
			{
				Log.outError(LogFilter.Battleground, "BattlegroundWS: Removing offline player who has the FLAG!!");
				setHordeFlagPicker(ObjectGuid.Empty);
				respawnFlag(TeamFaction.Horde, false);
			}
			else
			{
				eventPlayerDroppedFlag(player);
			}
		}
	}

	@Override
	public void handleAreaTrigger(Player player, int trigger, boolean entered)
	{
		//uint spellId = 0;
		//uint64 buff_guid = 0;
		switch (trigger)
		{
			case 8965: // Horde Start
			case 8966: // Alliance Start
				if (getStatus() == BattlegroundStatus.WaitJoin && !entered)
				{
					teleportPlayerToExploitLocation(player);
				}

				break;
			case 3686: // Alliance elixir of speed spawn. Trigger not working, because located inside other areatrigger, can be replaced by isWithinDist(object, dist) in Battleground.update().
				//buff_guid = BgObjects[BG_WS_OBJECT_SPEEDBUFF_1];
				break;
			case 3687: // Horde elixir of speed spawn. Trigger not working, because located inside other areatrigger, can be replaced by isWithinDist(object, dist) in Battleground.update().
				//buff_guid = BgObjects[BG_WS_OBJECT_SPEEDBUFF_2];
				break;
			case 3706: // Alliance elixir of regeneration spawn
				//buff_guid = BgObjects[BG_WS_OBJECT_REGENBUFF_1];
				break;
			case 3708: // Horde elixir of regeneration spawn
				//buff_guid = BgObjects[BG_WS_OBJECT_REGENBUFF_2];
				break;
			case 3707: // Alliance elixir of berserk spawn
				//buff_guid = BgObjects[BG_WS_OBJECT_BERSERKBUFF_1];
				break;
			case 3709: // Horde elixir of berserk spawn
				//buff_guid = BgObjects[BG_WS_OBJECT_BERSERKBUFF_2];
				break;
			case 3646: // Alliance Flag spawn
				if (_flagState[TeamIds.Horde] != 0 && _flagState[TeamIds.Alliance] == 0)
				{
					if (Objects.equals(getFlagPickerGUID(TeamIds.Horde), player.getGUID()))
					{
						eventPlayerCapturedFlag(player);
					}
				}

				break;
			case 3647: // Horde Flag spawn
				if (_flagState[TeamIds.Alliance] != 0 && _flagState[TeamIds.Horde] == 0)
				{
					if (Objects.equals(getFlagPickerGUID(TeamIds.Alliance), player.getGUID()))
					{
						eventPlayerCapturedFlag(player);
					}
				}

				break;
			case 3649: // unk1
			case 3688: // unk2
			case 4628: // unk3
			case 4629: // unk4
				break;
			default:
				super.handleAreaTrigger(player, trigger, entered);

				break;
		}

		//if (buff_guid)
		//    handleTriggerBuff(buff_guid, player);
	}

	@Override
	public boolean setupBattleground()
	{
		var result = true;
		result &= addObject(WSGObjectTypes.AFlag, WSGObjectEntry.AFlag, 1540.423f, 1481.325f, 351.8284f, 3.089233f, 0, 0, 0.9996573f, 0.02617699f, WSGTimerOrScore.FlagRespawnTime / 1000);
		result &= addObject(WSGObjectTypes.HFlag, WSGObjectEntry.HFlag, 916.0226f, 1434.405f, 345.413f, 0.01745329f, 0, 0, 0.008726535f, 0.9999619f, WSGTimerOrScore.FlagRespawnTime / 1000);

		if (!result)
		{
			Log.outError(LogFilter.Sql, "BgWarsongGluch: Failed to spawn flag object!");

			return false;
		}

		// buffs
		result &= addObject(WSGObjectTypes.SPEEDBUFF1, Buff_Entries[0], 1449.93f, 1470.71f, 342.6346f, -1.64061f, 0, 0, 0.7313537f, -0.6819983f, BattlegroundConst.BuffRespawnTime);
		result &= addObject(WSGObjectTypes.SPEEDBUFF2, Buff_Entries[0], 1005.171f, 1447.946f, 335.9032f, 1.64061f, 0, 0, 0.7313537f, 0.6819984f, BattlegroundConst.BuffRespawnTime);
		result &= addObject(WSGObjectTypes.REGENBUFF1, Buff_Entries[1], 1317.506f, 1550.851f, 313.2344f, -0.2617996f, 0, 0, 0.1305263f, -0.9914448f, BattlegroundConst.BuffRespawnTime);
		result &= addObject(WSGObjectTypes.REGENBUFF2, Buff_Entries[1], 1110.451f, 1353.656f, 316.5181f, -0.6806787f, 0, 0, 0.333807f, -0.9426414f, BattlegroundConst.BuffRespawnTime);
		result &= addObject(WSGObjectTypes.BERSERKBUFF1, Buff_Entries[2], 1320.09f, 1378.79f, 314.7532f, 1.186824f, 0, 0, 0.5591929f, 0.8290376f, BattlegroundConst.BuffRespawnTime);
		result &= addObject(WSGObjectTypes.BERSERKBUFF2, Buff_Entries[2], 1139.688f, 1560.288f, 306.8432f, -2.443461f, 0, 0, 0.9396926f, -0.3420201f, BattlegroundConst.BuffRespawnTime);

		if (!result)
		{
			Log.outError(LogFilter.Sql, "BgWarsongGluch: Failed to spawn buff object!");

			return false;
		}

		// alliance gates
		result &= addObject(WSGObjectTypes.DOORA1, WSGObjectEntry.DOORA1, 1503.335f, 1493.466f, 352.1888f, 3.115414f, 0, 0, 0.9999143f, 0.01308903f, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORA2, WSGObjectEntry.DOORA2, 1492.478f, 1457.912f, 342.9689f, 3.115414f, 0, 0, 0.9999143f, 0.01308903f, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORA3, WSGObjectEntry.DOORA3, 1468.503f, 1494.357f, 351.8618f, 3.115414f, 0, 0, 0.9999143f, 0.01308903f, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORA4, WSGObjectEntry.DOORA4, 1471.555f, 1458.778f, 362.6332f, 3.115414f, 0, 0, 0.9999143f, 0.01308903f, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORA5, WSGObjectEntry.DOORA5, 1492.347f, 1458.34f, 342.3712f, -0.03490669f, 0, 0, 0.01745246f, -0.9998477f, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORA6, WSGObjectEntry.DOORA6, 1503.466f, 1493.367f, 351.7352f, -0.03490669f, 0, 0, 0.01745246f, -0.9998477f, BattlegroundConst.RespawnImmediately);
		// horde gates
		result &= addObject(WSGObjectTypes.DOORH1, WSGObjectEntry.DOORH1, 949.1663f, 1423.772f, 345.6241f, -0.5756807f, -0.01673368f, -0.004956111f, -0.2839723f, 0.9586737f, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORH2, WSGObjectEntry.DOORH2, 953.0507f, 1459.842f, 340.6526f, -1.99662f, -0.1971825f, 0.1575096f, -0.8239487f, 0.5073641f, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORH3, WSGObjectEntry.DOORH3, 949.9523f, 1422.751f, 344.9273f, 0.0f, 0, 0, 0, 1, BattlegroundConst.RespawnImmediately);
		result &= addObject(WSGObjectTypes.DOORH4, WSGObjectEntry.DOORH4, 950.7952f, 1459.583f, 342.1523f, 0.05235988f, 0, 0, 0.02617695f, 0.9996573f, BattlegroundConst.RespawnImmediately);

		if (!result)
		{
			Log.outError(LogFilter.Sql, "BgWarsongGluch: Failed to spawn door object Battleground not created!");

			return false;
		}

		var sg = global.getObjectMgr().getWorldSafeLoc(WSGGraveyards.mainAlliance);

		if (sg == null || !addSpiritGuide(WSGCreatureTypes.SPIRITMAINALLIANCE, sg.loc.getX(), sg.loc.getY(), sg.loc.getZ(), 3.124139f, TeamIds.Alliance))
		{
			Log.outError(LogFilter.Sql, "BgWarsongGluch: Failed to spawn Alliance spirit guide! Battleground not created!");

			return false;
		}

		sg = global.getObjectMgr().getWorldSafeLoc(WSGGraveyards.mainHorde);

		if (sg == null || !addSpiritGuide(WSGCreatureTypes.SPIRITMAINHORDE, sg.loc.getX(), sg.loc.getY(), sg.loc.getZ(), 3.193953f, TeamIds.Horde))
		{
			Log.outError(LogFilter.Sql, "BgWarsongGluch: Failed to spawn Horde spirit guide! Battleground not created!");

			return false;
		}

		return true;
	}

	@Override
	public void reset()
	{
		//call parent's class reset
		super.reset();

		m_FlagKeepers[TeamIds.Alliance].clear();
		m_FlagKeepers[TeamIds.Horde].clear();
		m_DroppedFlagGUID[TeamIds.Alliance] = ObjectGuid.Empty;
		m_DroppedFlagGUID[TeamIds.Horde] = ObjectGuid.Empty;
		_flagState[TeamIds.Alliance] = WSGFlagState.OnBase;
		_flagState[TeamIds.Horde] = WSGFlagState.OnBase;
		m_TeamScores[TeamIds.Alliance] = 0;
		m_TeamScores[TeamIds.Horde] = 0;

		if (global.getBattlegroundMgr().isBGWeekend(getTypeID()))
		{
			m_ReputationCapture = 45;
			m_HonorWinKills = 3;
			m_HonorEndKills = 4;
		}
		else
		{
			m_ReputationCapture = 35;
			m_HonorWinKills = 1;
			m_HonorEndKills = 2;
		}

		lastFlagCaptureTeam = 0;
		bothFlagsKept = false;
		flagDebuffState = 0;
		flagSpellForceTimer = 0;
		_flagsDropTimer[TeamIds.Alliance] = 0;
		_flagsDropTimer[TeamIds.Horde] = 0;
		_flagsTimer[TeamIds.Alliance] = 0;
		_flagsTimer[TeamIds.Horde] = 0;
	}

	@Override
	public void endBattleground(TeamFaction winner)
	{
		// Win reward
		if (winner == TeamFaction.Alliance)
		{
			rewardHonorToTeam(getBonusHonorFromKill(m_HonorWinKills), TeamFaction.Alliance);
		}

		if (winner == TeamFaction.Horde)
		{
			rewardHonorToTeam(getBonusHonorFromKill(m_HonorWinKills), TeamFaction.Horde);
		}

		// Complete map_end rewards (even if no team wins)
		rewardHonorToTeam(getBonusHonorFromKill(m_HonorEndKills), TeamFaction.Alliance);
		rewardHonorToTeam(getBonusHonorFromKill(m_HonorEndKills), TeamFaction.Horde);

		super.endBattleground(winner);
	}

	@Override
	public void handleKillPlayer(Player victim, Player killer)
	{
		if (getStatus() != BattlegroundStatus.inProgress)
		{
			return;
		}

		eventPlayerDroppedFlag(victim);

		super.handleKillPlayer(victim, killer);
	}


	@Override
	public boolean updatePlayerScore(Player player, ScoreType type, int value)
	{
		return updatePlayerScore(player, type, value, true);
	}

	@Override
	public boolean updatePlayerScore(Player player, ScoreType type, int value, boolean doAddHonor)
	{
		if (!super.updatePlayerScore(player, type, value, doAddHonor))
		{
			return false;
		}

		switch (type)
		{
			case FlagCaptures: // flags captured
				player.updateCriteria(CriteriaType.TrackedWorldStateUIModified, WSObjectives.CAPTUREFLAG);

				break;
			case FlagReturns: // flags returned
				player.updateCriteria(CriteriaType.TrackedWorldStateUIModified, WSObjectives.RETURNFLAG);

				break;
			default:
				break;
		}

		return true;
	}

	@Override
	public WorldSafeLocsEntry getClosestGraveYard(Player player)
	{
		//if status in progress, it returns main graveyards with spiritguides
		//else it will return the graveyard in the flagroom - this is especially good
		//if a player dies in preparation phase - then the player can't cheat
		//and teleport to the graveyard outside the flagroom
		//and start running around, while the doors are still closed
        if (getPlayerTeam(player.getGUID()) == TeamFaction.Alliance)
		{
			if (getStatus() == BattlegroundStatus.inProgress)
			{
				return global.getObjectMgr().getWorldSafeLoc(WSGGraveyards.mainAlliance);
			}
			else
			{
				return global.getObjectMgr().getWorldSafeLoc(WSGGraveyards.flagRoomAlliance);
			}
		}
		else
		{
			if (getStatus() == BattlegroundStatus.inProgress)
			{
				return global.getObjectMgr().getWorldSafeLoc(WSGGraveyards.mainHorde);
			}
			else
			{
				return global.getObjectMgr().getWorldSafeLoc(WSGGraveyards.flagRoomHorde);
			}
		}
	}

	@Override
	public WorldSafeLocsEntry getExploitTeleportLocation(TeamFaction team)
	{
		return global.getObjectMgr().getWorldSafeLoc(team == TeamFaction.Alliance ? ExploitTeleportLocationAlliance : EXPLOITTELEPORTLOCATIONHORDE);
	}

	@Override
	public TeamFaction getPrematureWinner()
	{
		if (getTeamScore(TeamIds.Alliance) > getTeamScore(TeamIds.Horde))
		{
			return TeamFaction.Alliance;
		}
		else if (getTeamScore(TeamIds.Horde) > getTeamScore(TeamIds.Alliance))
		{
			return TeamFaction.Horde;
		}

		return super.getPrematureWinner();
	}


	@Override
	public ObjectGuid getFlagPickerGUID()
	{
		return getFlagPickerGUID(-1);
	}

	@Override
	public ObjectGuid getFlagPickerGUID(int team)
	{
		if (team == TeamIds.Alliance || team == TeamIds.Horde)
		{
            return m_FlagKeepers[team];
		}

		return ObjectGuid.Empty;
	}


	@Override
	public void setDroppedFlagGUID(ObjectGuid guid)
	{
		setDroppedFlagGUID(guid, -1);
	}

	@Override
	public void setDroppedFlagGUID(ObjectGuid guid, int team)
	{
		if (team == TeamIds.Alliance || team == TeamIds.Horde)
		{
            m_DroppedFlagGUID[team] = guid;
		}
	}

	private void respawnFlag(TeamFaction team, boolean captured)
	{
		if (team == TeamFaction.Alliance)
		{
			Log.outDebug(LogFilter.Battleground, "Respawn Alliance flag");
			_flagState[TeamIds.Alliance] = WSGFlagState.OnBase;
		}
		else
		{
			Log.outDebug(LogFilter.Battleground, "Respawn Horde flag");
			_flagState[TeamIds.Horde] = WSGFlagState.OnBase;
		}

		if (captured)
		{
			//when map_update will be allowed for Battlegrounds this code will be useless
			spawnBGObject(WSGObjectTypes.HFlag, BattlegroundConst.RespawnImmediately);
			spawnBGObject(WSGObjectTypes.AFlag, BattlegroundConst.RespawnImmediately);
			sendBroadcastText(WSGBroadcastTexts.flagsPlaced, ChatMsg.BgSystemNeutral);
			playSoundToAll(WSGSound.flagsRespawned); // flag respawned sound...
		}

		bothFlagsKept = false;
	}

	private void respawnFlagAfterDrop(TeamFaction team)
	{
		if (getStatus() != BattlegroundStatus.inProgress)
		{
			return;
		}

		respawnFlag(team, false);

		if (team == TeamFaction.Alliance)
		{
			spawnBGObject(WSGObjectTypes.AFlag, BattlegroundConst.RespawnImmediately);
		}
		else
		{
			spawnBGObject(WSGObjectTypes.HFlag, BattlegroundConst.RespawnImmediately);
		}

		sendBroadcastText(WSGBroadcastTexts.flagsPlaced, ChatMsg.BgSystemNeutral);
		playSoundToAll(WSGSound.flagsRespawned);

        var obj = getBgMap().getGameObject(getDroppedFlagGUID(team));

		if (obj)
		{
			obj.delete();
		}
		else
		{
			Log.outError(LogFilter.Battleground, "unknown droped flag ({0})", getDroppedFlagGUID(team).toString());
		}

		setDroppedFlagGUID(ObjectGuid.Empty, getTeamIndexByTeamId(team));
		bothFlagsKept = false;
		// Check opposing flag if it is in capture zone; if so, capture it
		handleFlagRoomCapturePoint(team == TeamFaction.Alliance ? TeamIds.Horde : TeamIds.Alliance);
	}

	private void eventPlayerCapturedFlag(Player player)
	{
		if (getStatus() != BattlegroundStatus.inProgress)
		{
			return;
		}

		TeamFaction winner = TeamFaction.forValue(0);

		player.removeAurasWithInterruptFlags(SpellAuraInterruptFlags.PvPActive);
        var team = getPlayerTeam(player.getGUID());

		if (team == TeamFaction.Alliance)
		{
			if (!isHordeFlagPickedup())
			{
				return;
			}

			setHordeFlagPicker(ObjectGuid.Empty); // must be before aura remove to prevent 2 events (drop+capture) at the same time
			// horde flag in base (but not respawned yet)
			_flagState[TeamIds.Horde] = WSGFlagState.WaitRespawn;
			// Drop Horde Flag from Player
			player.removeAura(WSGSpellId.warsongFlag);

			if (flagDebuffState == 1)
			{
				player.removeAura(WSGSpellId.focusedAssault);
			}
			else if (flagDebuffState == 2)
			{
				player.removeAura(WSGSpellId.brutalAssault);
			}

			if (getTeamScore(TeamIds.Alliance) < WSGTimerOrScore.maxTeamScore)
			{
				addPoint(TeamFaction.Alliance, 1);
			}

			playSoundToAll(WSGSound.flagCapturedAlliance);
			rewardReputationToTeam(890, m_ReputationCapture, TeamFaction.Alliance);
		}
		else
		{
			if (!isAllianceFlagPickedup())
			{
				return;
			}

			setAllianceFlagPicker(ObjectGuid.Empty); // must be before aura remove to prevent 2 events (drop+capture) at the same time
			// alliance flag in base (but not respawned yet)
			_flagState[TeamIds.Alliance] = WSGFlagState.WaitRespawn;
			// Drop Alliance Flag from Player
			player.removeAura(WSGSpellId.silverwingFlag);

			if (flagDebuffState == 1)
			{
				player.removeAura(WSGSpellId.focusedAssault);
			}
			else if (flagDebuffState == 2)
			{
				player.removeAura(WSGSpellId.brutalAssault);
			}

			if (getTeamScore(TeamIds.Horde) < WSGTimerOrScore.maxTeamScore)
			{
				addPoint(TeamFaction.Horde, 1);
			}

			playSoundToAll(WSGSound.flagCapturedHorde);
			rewardReputationToTeam(889, m_ReputationCapture, TeamFaction.Horde);
		}

		//for flag capture is reward 2 honorable kills
		rewardHonorToTeam(getBonusHonorFromKill(2), team);

		spawnBGObject(WSGObjectTypes.HFlag, WSGTimerOrScore.FLAGRESPAWNTIME);
		spawnBGObject(WSGObjectTypes.AFlag, WSGTimerOrScore.FLAGRESPAWNTIME);

		if (team == TeamFaction.Alliance)
		{
			sendBroadcastText(WSGBroadcastTexts.capturedHordeFlag, ChatMsg.BgSystemAlliance, player);
		}
		else
		{
			sendBroadcastText(WSGBroadcastTexts.capturedAllianceFlag, ChatMsg.BgSystemHorde, player);
		}

		updateFlagState(team, WSGFlagState.WaitRespawn); // flag state none
		updateTeamScore(getTeamIndexByTeamId(team));
		// only flag capture should be updated
		updatePlayerScore(player, ScoreType.flagCaptures, 1); // +1 flag captures

		// update last flag capture to be used if teamscore is equal
		setLastFlagCapture(team);

		if (getTeamScore(TeamIds.Alliance) == WSGTimerOrScore.maxTeamScore)
		{
			winner = TeamFaction.Alliance;
		}

		if (getTeamScore(TeamIds.Horde) == WSGTimerOrScore.maxTeamScore)
		{
			winner = TeamFaction.Horde;
		}

		if (winner != 0)
		{
			updateWorldState(WSGWorldStates.flagStateAlliance, 1);
			updateWorldState(WSGWorldStates.flagStateHorde, 1);
			updateWorldState(WSGWorldStates.stateTimerActive, 0);

			rewardHonorToTeam(Honor[m_HonorMode.getValue()][WSGRewards.Win.getValue()], winner);
			endBattleground(winner);
		}
		else
		{
			_flagsTimer[GetTeamIndexByTeamId(team)] = WSGTimerOrScore.FLAGRESPAWNTIME;
		}
	}

	private void handleFlagRoomCapturePoint(int team)
	{
        var flagCarrier = global.getObjAccessor().getPlayer(getBgMap(), getFlagPickerGUID(team));
		var areaTrigger = team == TeamIds.Alliance ? 3647 : 3646;

		if (flagCarrier != null && flagCarrier.isInAreaTriggerRadius(CliDB.AreaTriggerStorage.get(areaTrigger)))
		{
			eventPlayerCapturedFlag(flagCarrier);
		}
	}

	private void updateFlagState(TeamFaction team, WSGFlagState value)
	{
// C# TO JAVA CONVERTER TASK: Local functions are not converted by C# to Java Converter:
//		int transformValueToOtherTeamControlWorldState(WSGFlagState value)
//			{
//				switch (value)
//				{
//					case WSGFlagState.OnBase:
//					case WSGFlagState.OnGround:
//					case WSGFlagState.WaitRespawn:
//						return 1;
//					case WSGFlagState.OnPlayer:
//						return 2;
//					default:
//						return 0;
//				}
//			}

		;

		if (team == TeamFaction.Horde)
		{
			updateWorldState(WSGWorldStates.flagStateAlliance, value.getValue());
			updateWorldState(WSGWorldStates.flagControlHorde, transformValueToOtherTeamControlWorldState(value));
		}
		else
		{
			updateWorldState(WSGWorldStates.flagStateHorde, value.getValue());
			updateWorldState(WSGWorldStates.flagControlAlliance, transformValueToOtherTeamControlWorldState(value));
		}
	}

	private void updateTeamScore(int team)
	{
		if (team == TeamIds.Alliance)
		{
			updateWorldState(WSGWorldStates.flagCapturesAlliance, (int)getTeamScore(team));
		}
		else
		{
			updateWorldState(WSGWorldStates.flagCapturesHorde, (int)getTeamScore(team));
		}
	}

	private void setAllianceFlagPicker(ObjectGuid guid)
	{
        m_FlagKeepers[TeamIds.Alliance] = guid;
	}

	private void setHordeFlagPicker(ObjectGuid guid)
	{
        m_FlagKeepers[TeamIds.Horde] = guid;
	}

	private boolean isAllianceFlagPickedup()
	{
		return !m_FlagKeepers[TeamIds.Alliance].isEmpty();
	}

	private boolean isHordeFlagPickedup()
	{
		return !m_FlagKeepers[TeamIds.Horde].isEmpty();
	}

	private WSGFlagState getFlagState(TeamFaction team)
	{
		return _flagState[GetTeamIndexByTeamId(team)];
	}

	private void setLastFlagCapture(TeamFaction team)
	{
		lastFlagCaptureTeam = (int)team.getValue();
	}

	private ObjectGuid getDroppedFlagGUID(TeamFaction team)
	{
        return m_DroppedFlagGUID[GetTeamIndexByTeamId(team)];
	}


	private void addPoint(TeamFaction team)
	{
		addPoint(team, 1);
	}

	private void addPoint(TeamFaction team, int points)
	{
		m_TeamScores[GetTeamIndexByTeamId(team)] += points;
	}
}
