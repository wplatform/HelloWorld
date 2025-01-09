package com.github.azeroth.game.service.mapper;

import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.common.Locale;
import com.github.azeroth.defines.*;
import com.github.azeroth.game.domain.creature.*;
import com.github.azeroth.game.domain.misc.NpcText;
import com.github.azeroth.game.domain.player.PlayerInfo;
import com.github.azeroth.game.domain.reputation.RepSpilloverTemplate;
import com.github.azeroth.game.domain.unit.NPCFlag;
import com.github.azeroth.game.domain.unit.UnitFlag;
import com.github.azeroth.game.domain.unit.UnitFlag2;
import com.github.azeroth.game.domain.unit.UnitFlag3;
import org.springframework.jdbc.core.RowMapper;

public interface RowMappers {

    RowMapper<RepSpilloverTemplate> REP_SPILLOVER_TEMPLATE_RESULT_SET_EXTRACTOR = (rs, rowNum) -> {
        RepSpilloverTemplate repTemplate = new RepSpilloverTemplate();
        int index = 1;
        repTemplate.factionId = rs.getInt(index++);
        repTemplate.faction[0] = rs.getInt(index++);
        repTemplate.factionRate[0] = rs.getFloat(index++);
        repTemplate.factionRank[0] = rs.getInt(index++);
        repTemplate.faction[1] = rs.getInt(index++);
        repTemplate.factionRate[1] = rs.getFloat(index++);
        repTemplate.factionRank[1] = rs.getInt(index++);
        repTemplate.faction[2] = rs.getInt(index++);
        repTemplate.factionRate[2] = rs.getFloat(index++);
        repTemplate.factionRank[2] = rs.getInt(index++);
        repTemplate.faction[3] = rs.getInt(index++);
        repTemplate.factionRate[3] = rs.getFloat(index++);
        repTemplate.factionRank[3] = rs.getInt(index++);
        repTemplate.faction[4] = rs.getInt(index++);
        repTemplate.factionRate[4] = rs.getFloat(index++);
        repTemplate.factionRank[4] = rs.getInt(index++);
        return repTemplate;
    };


    RowMapper<NpcText> NPC_TEXT_SET_EXTRACTOR = (rs, rowNum) -> {
        NpcText npcText = new NpcText();
        npcText.id = rs.getInt(1);
        for (int i = 0; i < SharedDefine.MAX_NPC_TEXT_OPTIONS; ++i) {
            npcText.data[i].probability = rs.getFloat(2 + i);
            npcText.data[i].broadcastTextID = rs.getInt(2 + SharedDefine.MAX_NPC_TEXT_OPTIONS + i);
        }
        return npcText;
    };


    RowMapper<CreatureTemplate> CREATURE_TEMPLATE_ROW_MAPPER = (rs, rowNum) -> {

        CreatureTemplate creature = new CreatureTemplate();

        creature.entry = rs.getInt(1);

        for (int i = 0; i < CreatureTemplate.MAX_KILL_CREDIT; ++i)
            creature.killCredit[i]      = rs.getInt(2 + i);

        creature.name                   .set(Locale.enUS, rs.getString(4));
        creature.femaleName             .set(Locale.enUS, rs.getString(5));
        creature.subName                .set(Locale.enUS, rs.getString(6));
        creature.titleAlt               .set(Locale.enUS, rs.getString(7));
        creature.iconName               .set(Locale.enUS, rs.getString(8));
        creature.requiredExpansion      = rs.getInt(9);
        creature.vignetteID             = rs.getInt(10);
        creature.faction                = rs.getInt(11);
        creature.npcFlag                = EnumFlag.of(NPCFlag.class, rs.getInt(12));
        creature.speedWalk             = rs.getFloat(13);
        creature.speedRun              = rs.getFloat(14);
        creature.scale                  = rs.getFloat(15);
        creature.classification         = CreatureClassification.values()[rs.getByte(16)];
        creature.dmgSchool              = rs.getInt(17);
        creature.baseAttackTime         = rs.getInt(18);
        creature.rangeAttackTime        = rs.getInt(19);
        creature.baseVariance           = rs.getFloat(20);
        creature.rangeVariance          = rs.getFloat(21);
        creature.unitClass             = rs.getInt(22);
        creature.unitFlags             = EnumFlag.of(UnitFlag.class, rs.getInt(23));
        creature.unitFlags2            = EnumFlag.of(UnitFlag2.class, rs.getInt(24));
        creature.unitFlags3            = EnumFlag.of(UnitFlag3.class, rs.getInt(25));
        creature.family                 = CreatureFamily.values()[rs.getInt(26)];
        creature.trainerClass          = PlayerClass.values()[rs.getInt(27)];
        creature.type                   = CreatureType.values()[rs.getInt(28)];

        creature.vehicleId              = rs.getInt(29);
        creature.aiName                 = rs.getString(30);
        creature.movementType           = rs.getInt(31);

        int ground = rs.getInt(32);
        if (!rs.wasNull())
            creature.movement.ground = CreatureGroundMovementType.values()[ground];

        boolean swim = rs.getBoolean(33);
        if (!rs.wasNull())
            creature.movement.swim = swim;

        int flight = rs.getByte(34);
        if (!rs.wasNull())
            creature.movement.flight = CreatureFlightMovementType.values()[flight];

        boolean rooted = rs.getBoolean(35);
        if (!rs.wasNull())
            creature.movement.rooted = rooted;

        int chase = rs.getByte(36);
        if (!rs.wasNull())
            creature.movement.chase = CreatureChaseMovementType.values()[chase];

        int random = rs.getByte(37);
        if (!rs.wasNull())
            creature.movement.random = CreatureRandomMovementType.values()[random];

        int interactionPauseTimer = rs.getInt(38);
        if (!rs.wasNull())
            creature.movement.interactionPauseTimer = interactionPauseTimer;

        creature.modExperience          = rs.getFloat(39);
        creature.racialLeader           = rs.getBoolean(40);
        creature.movementId             = rs.getInt(41);
        creature.regenHealth            = rs.getBoolean(42);
        creature.creatureImmunitiesId   = rs.getInt(43);
        creature.flagsExtra            = EnumFlag.of(CreatureFlagExtra.class, rs.getInt(44));
        creature.script               = rs.getString(45);
        creature.stringId               = rs.getString(46);

        return creature;
    };


    RowMapper<PlayerInfo> PLAYER_INFO_ROW_MAPPER = (rs, rowNum) -> {
        PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.race = Race.values()[rs.getByte(1)];
        playerInfo.playClass = PlayerClass.values()[rs.getByte(2)];
        playerInfo.mapId = rs.getInt(3);
        playerInfo.x = rs.getFloat(4);
        playerInfo.y = rs.getFloat(5);
        playerInfo.z = rs.getFloat(6);
        playerInfo.o = rs.getFloat(7);

        int introMovieId = rs.getInt(8);
        if(!rs.wasNull()) {
            playerInfo.introMovieId = introMovieId;
        }
        return playerInfo;
    };

}
