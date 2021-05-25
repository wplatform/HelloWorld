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
@Table("character_garrison_followers")
public class CharacterGarrisonFollowers {

    @Column("dbId")
    private Long dbId;
    @Column("guid")
    private Long guid;
    @Column("followerId")
    private Integer followerId;
    @Column("quality")
    private Integer quality;
    @Column("level")
    private Integer level;
    @Column("itemLevelWeapon")
    private Integer itemLevelWeapon;
    @Column("itemLevelArmor")
    private Integer itemLevelArmor;
    @Column("xp")
    private Integer xp;
    @Column("currentBuilding")
    private Integer currentBuilding;
    @Column("currentMission")
    private Integer currentMission;
    @Column("status")
    private Integer status;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterGarrisonFollowers> {

        public CharacterGarrisonFollowers convert(Row row) {
            CharacterGarrisonFollowers domain = new CharacterGarrisonFollowers();
            domain.setDbId(row.get("dbId", Long.class));
            domain.setGuid(row.get("guid", Long.class));
            domain.setFollowerId(row.get("followerId", Integer.class));
            domain.setQuality(row.get("quality", Integer.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setItemLevelWeapon(row.get("itemLevelWeapon", Integer.class));
            domain.setItemLevelArmor(row.get("itemLevelArmor", Integer.class));
            domain.setXp(row.get("xp", Integer.class));
            domain.setCurrentBuilding(row.get("currentBuilding", Integer.class));
            domain.setCurrentMission(row.get("currentMission", Integer.class));
            domain.setStatus(row.get("status", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterGarrisonFollowers, OutboundRow> {

        public OutboundRow convert(CharacterGarrisonFollowers source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDbId()).ifPresent(e -> row.put("dbId", Parameter.from(e)));
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getFollowerId()).ifPresent(e -> row.put("followerId", Parameter.from(e)));
            Optional.ofNullable(source.getQuality()).ifPresent(e -> row.put("quality", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevelWeapon()).ifPresent(e -> row.put("itemLevelWeapon", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevelArmor()).ifPresent(e -> row.put("itemLevelArmor", Parameter.from(e)));
            Optional.ofNullable(source.getXp()).ifPresent(e -> row.put("xp", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentBuilding()).ifPresent(e -> row.put("currentBuilding", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentMission()).ifPresent(e -> row.put("currentMission", Parameter.from(e)));
            Optional.ofNullable(source.getStatus()).ifPresent(e -> row.put("status", Parameter.from(e)));
            return row;
        }
    }

}
