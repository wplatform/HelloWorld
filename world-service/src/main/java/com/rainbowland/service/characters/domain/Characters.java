package com.rainbowland.service.characters.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("characters")
public class Characters {

    @Column("guid")
    private Long guid;
    @Column("account")
    private Integer account;
    @Column("name")
    private String name;
    @Column("slot")
    private Integer slot;
    @Column("race")
    private Integer race;
    @Column("class")
    private Integer klass;
    @Column("gender")
    private Integer gender;
    @Column("level")
    private Integer level;
    @Column("xp")
    private Integer xp;
    @Column("money")
    private Long money;
    @Column("inventorySlots")
    private Integer inventorySlots;
    @Column("bankSlots")
    private Integer bankSlots;
    @Column("restState")
    private Integer restState;
    @Column("playerFlags")
    private Integer playerFlags;
    @Column("playerFlagsEx")
    private Integer playerFlagsEx;
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("map")
    private Integer map;
    @Column("instance_id")
    private Integer instanceId;
    @Column("dungeonDifficulty")
    private Integer dungeonDifficulty;
    @Column("raidDifficulty")
    private Integer raidDifficulty;
    @Column("legacyRaidDifficulty")
    private Integer legacyRaidDifficulty;
    @Column("orientation")
    private Double orientation;
    @Column("taximask")
    private String taximask;
    @Column("online")
    private Integer online;
    @Column("cinematic")
    private Integer cinematic;
    @Column("totaltime")
    private Integer totaltime;
    @Column("leveltime")
    private Integer leveltime;
    @Column("logout_time")
    private Long logoutTime;
    @Column("is_logout_resting")
    private Integer isLogoutResting;
    @Column("rest_bonus")
    private Double restBonus;
    @Column("resettalents_cost")
    private Integer resettalentsCost;
    @Column("resettalents_time")
    private Long resettalentsTime;
    @Column("numRespecs")
    private Integer numRespecs;
    @Column("primarySpecialization")
    private Integer primarySpecialization;
    @Column("trans_x")
    private Double transX;
    @Column("trans_y")
    private Double transY;
    @Column("trans_z")
    private Double transZ;
    @Column("trans_o")
    private Double transO;
    @Column("transguid")
    private Long transguid;
    @Column("extra_flags")
    private Integer extraFlags;
    @Column("stable_slots")
    private Integer stableSlots;
    @Column("at_login")
    private Integer atLogin;
    @Column("zone")
    private Integer zone;
    @Column("death_expire_time")
    private Long deathExpireTime;
    @Column("taxi_path")
    private String taxiPath;
    @Column("totalKills")
    private Integer totalKills;
    @Column("todayKills")
    private Integer todayKills;
    @Column("yesterdayKills")
    private Integer yesterdayKills;
    @Column("chosenTitle")
    private Integer chosenTitle;
    @Column("watchedFaction")
    private Integer watchedFaction;
    @Column("drunk")
    private Integer drunk;
    @Column("health")
    private Integer health;
    @Column("power1")
    private Integer power1;
    @Column("power2")
    private Integer power2;
    @Column("power3")
    private Integer power3;
    @Column("power4")
    private Integer power4;
    @Column("power5")
    private Integer power5;
    @Column("power6")
    private Integer power6;
    @Column("latency")
    private Integer latency;
    @Column("activeTalentGroup")
    private Integer activeTalentGroup;
    @Column("lootSpecId")
    private Integer lootSpecId;
    @Column("exploredZones")
    private String exploredZones;
    @Column("equipmentCache")
    private String equipmentCache;
    @Column("knownTitles")
    private String knownTitles;
    @Column("actionBars")
    private Integer actionBars;
    @Column("deleteInfos_Account")
    private Integer deleteInfosAccount;
    @Column("deleteInfos_Name")
    private String deleteInfosName;
    @Column("deleteDate")
    private Long deleteDate;
    @Column("honor")
    private Integer honor;
    @Column("honorLevel")
    private Integer honorLevel;
    @Column("honorRestState")
    private Integer honorRestState;
    @Column("honorRestBonus")
    private Double honorRestBonus;
    @Column("lastLoginBuild")
    private Integer lastLoginBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Characters> {

        public Characters convert(Row row) {
            Characters domain = new Characters();
            domain.setGuid(row.get("guid", Long.class));
            domain.setAccount(row.get("account", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setSlot(row.get("slot", Integer.class));
            domain.setRace(row.get("race", Integer.class));
            domain.setKlass(row.get("class", Integer.class));
            domain.setGender(row.get("gender", Integer.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setXp(row.get("xp", Integer.class));
            domain.setMoney(row.get("money", Long.class));
            domain.setInventorySlots(row.get("inventorySlots", Integer.class));
            domain.setBankSlots(row.get("bankSlots", Integer.class));
            domain.setRestState(row.get("restState", Integer.class));
            domain.setPlayerFlags(row.get("playerFlags", Integer.class));
            domain.setPlayerFlagsEx(row.get("playerFlagsEx", Integer.class));
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setMap(row.get("map", Integer.class));
            domain.setInstanceId(row.get("instance_id", Integer.class));
            domain.setDungeonDifficulty(row.get("dungeonDifficulty", Integer.class));
            domain.setRaidDifficulty(row.get("raidDifficulty", Integer.class));
            domain.setLegacyRaidDifficulty(row.get("legacyRaidDifficulty", Integer.class));
            domain.setOrientation(row.get("orientation", Double.class));
            domain.setTaximask(row.get("taximask", String.class));
            domain.setOnline(row.get("online", Integer.class));
            domain.setCinematic(row.get("cinematic", Integer.class));
            domain.setTotaltime(row.get("totaltime", Integer.class));
            domain.setLeveltime(row.get("leveltime", Integer.class));
            domain.setLogoutTime(row.get("logout_time", Long.class));
            domain.setIsLogoutResting(row.get("is_logout_resting", Integer.class));
            domain.setRestBonus(row.get("rest_bonus", Double.class));
            domain.setResettalentsCost(row.get("resettalents_cost", Integer.class));
            domain.setResettalentsTime(row.get("resettalents_time", Long.class));
            domain.setNumRespecs(row.get("numRespecs", Integer.class));
            domain.setPrimarySpecialization(row.get("primarySpecialization", Integer.class));
            domain.setTransX(row.get("trans_x", Double.class));
            domain.setTransY(row.get("trans_y", Double.class));
            domain.setTransZ(row.get("trans_z", Double.class));
            domain.setTransO(row.get("trans_o", Double.class));
            domain.setTransguid(row.get("transguid", Long.class));
            domain.setExtraFlags(row.get("extra_flags", Integer.class));
            domain.setStableSlots(row.get("stable_slots", Integer.class));
            domain.setAtLogin(row.get("at_login", Integer.class));
            domain.setZone(row.get("zone", Integer.class));
            domain.setDeathExpireTime(row.get("death_expire_time", Long.class));
            domain.setTaxiPath(row.get("taxi_path", String.class));
            domain.setTotalKills(row.get("totalKills", Integer.class));
            domain.setTodayKills(row.get("todayKills", Integer.class));
            domain.setYesterdayKills(row.get("yesterdayKills", Integer.class));
            domain.setChosenTitle(row.get("chosenTitle", Integer.class));
            domain.setWatchedFaction(row.get("watchedFaction", Integer.class));
            domain.setDrunk(row.get("drunk", Integer.class));
            domain.setHealth(row.get("health", Integer.class));
            domain.setPower1(row.get("power1", Integer.class));
            domain.setPower2(row.get("power2", Integer.class));
            domain.setPower3(row.get("power3", Integer.class));
            domain.setPower4(row.get("power4", Integer.class));
            domain.setPower5(row.get("power5", Integer.class));
            domain.setPower6(row.get("power6", Integer.class));
            domain.setLatency(row.get("latency", Integer.class));
            domain.setActiveTalentGroup(row.get("activeTalentGroup", Integer.class));
            domain.setLootSpecId(row.get("lootSpecId", Integer.class));
            domain.setExploredZones(row.get("exploredZones", String.class));
            domain.setEquipmentCache(row.get("equipmentCache", String.class));
            domain.setKnownTitles(row.get("knownTitles", String.class));
            domain.setActionBars(row.get("actionBars", Integer.class));
            domain.setDeleteInfosAccount(row.get("deleteInfos_Account", Integer.class));
            domain.setDeleteInfosName(row.get("deleteInfos_Name", String.class));
            domain.setDeleteDate(row.get("deleteDate", Long.class));
            domain.setHonor(row.get("honor", Integer.class));
            domain.setHonorLevel(row.get("honorLevel", Integer.class));
            domain.setHonorRestState(row.get("honorRestState", Integer.class));
            domain.setHonorRestBonus(row.get("honorRestBonus", Double.class));
            domain.setLastLoginBuild(row.get("lastLoginBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Characters, OutboundRow> {

        public OutboundRow convert(Characters source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getAccount()).ifPresent(e -> row.put("account", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("slot", Parameter.from(e)));
            Optional.ofNullable(source.getRace()).ifPresent(e -> row.put("race", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("class", Parameter.from(e)));
            Optional.ofNullable(source.getGender()).ifPresent(e -> row.put("gender", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getXp()).ifPresent(e -> row.put("xp", Parameter.from(e)));
            Optional.ofNullable(source.getMoney()).ifPresent(e -> row.put("money", Parameter.from(e)));
            Optional.ofNullable(source.getInventorySlots()).ifPresent(e -> row.put("inventorySlots", Parameter.from(e)));
            Optional.ofNullable(source.getBankSlots()).ifPresent(e -> row.put("bankSlots", Parameter.from(e)));
            Optional.ofNullable(source.getRestState()).ifPresent(e -> row.put("restState", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerFlags()).ifPresent(e -> row.put("playerFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerFlagsEx()).ifPresent(e -> row.put("playerFlagsEx", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getMap()).ifPresent(e -> row.put("map", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceId()).ifPresent(e -> row.put("instance_id", Parameter.from(e)));
            Optional.ofNullable(source.getDungeonDifficulty()).ifPresent(e -> row.put("dungeonDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getRaidDifficulty()).ifPresent(e -> row.put("raidDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getLegacyRaidDifficulty()).ifPresent(e -> row.put("legacyRaidDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            Optional.ofNullable(source.getTaximask()).ifPresent(e -> row.put("taximask", Parameter.from(e)));
            Optional.ofNullable(source.getOnline()).ifPresent(e -> row.put("online", Parameter.from(e)));
            Optional.ofNullable(source.getCinematic()).ifPresent(e -> row.put("cinematic", Parameter.from(e)));
            Optional.ofNullable(source.getTotaltime()).ifPresent(e -> row.put("totaltime", Parameter.from(e)));
            Optional.ofNullable(source.getLeveltime()).ifPresent(e -> row.put("leveltime", Parameter.from(e)));
            Optional.ofNullable(source.getLogoutTime()).ifPresent(e -> row.put("logout_time", Parameter.from(e)));
            Optional.ofNullable(source.getIsLogoutResting()).ifPresent(e -> row.put("is_logout_resting", Parameter.from(e)));
            Optional.ofNullable(source.getRestBonus()).ifPresent(e -> row.put("rest_bonus", Parameter.from(e)));
            Optional.ofNullable(source.getResettalentsCost()).ifPresent(e -> row.put("resettalents_cost", Parameter.from(e)));
            Optional.ofNullable(source.getResettalentsTime()).ifPresent(e -> row.put("resettalents_time", Parameter.from(e)));
            Optional.ofNullable(source.getNumRespecs()).ifPresent(e -> row.put("numRespecs", Parameter.from(e)));
            Optional.ofNullable(source.getPrimarySpecialization()).ifPresent(e -> row.put("primarySpecialization", Parameter.from(e)));
            Optional.ofNullable(source.getTransX()).ifPresent(e -> row.put("trans_x", Parameter.from(e)));
            Optional.ofNullable(source.getTransY()).ifPresent(e -> row.put("trans_y", Parameter.from(e)));
            Optional.ofNullable(source.getTransZ()).ifPresent(e -> row.put("trans_z", Parameter.from(e)));
            Optional.ofNullable(source.getTransO()).ifPresent(e -> row.put("trans_o", Parameter.from(e)));
            Optional.ofNullable(source.getTransguid()).ifPresent(e -> row.put("transguid", Parameter.from(e)));
            Optional.ofNullable(source.getExtraFlags()).ifPresent(e -> row.put("extra_flags", Parameter.from(e)));
            Optional.ofNullable(source.getStableSlots()).ifPresent(e -> row.put("stable_slots", Parameter.from(e)));
            Optional.ofNullable(source.getAtLogin()).ifPresent(e -> row.put("at_login", Parameter.from(e)));
            Optional.ofNullable(source.getZone()).ifPresent(e -> row.put("zone", Parameter.from(e)));
            Optional.ofNullable(source.getDeathExpireTime()).ifPresent(e -> row.put("death_expire_time", Parameter.from(e)));
            Optional.ofNullable(source.getTaxiPath()).ifPresent(e -> row.put("taxi_path", Parameter.from(e)));
            Optional.ofNullable(source.getTotalKills()).ifPresent(e -> row.put("totalKills", Parameter.from(e)));
            Optional.ofNullable(source.getTodayKills()).ifPresent(e -> row.put("todayKills", Parameter.from(e)));
            Optional.ofNullable(source.getYesterdayKills()).ifPresent(e -> row.put("yesterdayKills", Parameter.from(e)));
            Optional.ofNullable(source.getChosenTitle()).ifPresent(e -> row.put("chosenTitle", Parameter.from(e)));
            Optional.ofNullable(source.getWatchedFaction()).ifPresent(e -> row.put("watchedFaction", Parameter.from(e)));
            Optional.ofNullable(source.getDrunk()).ifPresent(e -> row.put("drunk", Parameter.from(e)));
            Optional.ofNullable(source.getHealth()).ifPresent(e -> row.put("health", Parameter.from(e)));
            Optional.ofNullable(source.getPower1()).ifPresent(e -> row.put("power1", Parameter.from(e)));
            Optional.ofNullable(source.getPower2()).ifPresent(e -> row.put("power2", Parameter.from(e)));
            Optional.ofNullable(source.getPower3()).ifPresent(e -> row.put("power3", Parameter.from(e)));
            Optional.ofNullable(source.getPower4()).ifPresent(e -> row.put("power4", Parameter.from(e)));
            Optional.ofNullable(source.getPower5()).ifPresent(e -> row.put("power5", Parameter.from(e)));
            Optional.ofNullable(source.getPower6()).ifPresent(e -> row.put("power6", Parameter.from(e)));
            Optional.ofNullable(source.getLatency()).ifPresent(e -> row.put("latency", Parameter.from(e)));
            Optional.ofNullable(source.getActiveTalentGroup()).ifPresent(e -> row.put("activeTalentGroup", Parameter.from(e)));
            Optional.ofNullable(source.getLootSpecId()).ifPresent(e -> row.put("lootSpecId", Parameter.from(e)));
            Optional.ofNullable(source.getExploredZones()).ifPresent(e -> row.put("exploredZones", Parameter.from(e)));
            Optional.ofNullable(source.getEquipmentCache()).ifPresent(e -> row.put("equipmentCache", Parameter.from(e)));
            Optional.ofNullable(source.getKnownTitles()).ifPresent(e -> row.put("knownTitles", Parameter.from(e)));
            Optional.ofNullable(source.getActionBars()).ifPresent(e -> row.put("actionBars", Parameter.from(e)));
            Optional.ofNullable(source.getDeleteInfosAccount()).ifPresent(e -> row.put("deleteInfos_Account", Parameter.from(e)));
            Optional.ofNullable(source.getDeleteInfosName()).ifPresent(e -> row.put("deleteInfos_Name", Parameter.from(e)));
            Optional.ofNullable(source.getDeleteDate()).ifPresent(e -> row.put("deleteDate", Parameter.from(e)));
            Optional.ofNullable(source.getHonor()).ifPresent(e -> row.put("honor", Parameter.from(e)));
            Optional.ofNullable(source.getHonorLevel()).ifPresent(e -> row.put("honorLevel", Parameter.from(e)));
            Optional.ofNullable(source.getHonorRestState()).ifPresent(e -> row.put("honorRestState", Parameter.from(e)));
            Optional.ofNullable(source.getHonorRestBonus()).ifPresent(e -> row.put("honorRestBonus", Parameter.from(e)));
            Optional.ofNullable(source.getLastLoginBuild()).ifPresent(e -> row.put("lastLoginBuild", Parameter.from(e)));
            return row;
        }
    }

}
