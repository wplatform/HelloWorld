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
@Table("groups")
public class Groups {

    @Column("guid")
    private Integer guid;
    @Column("leaderGuid")
    private Long leaderGuid;
    @Column("lootMethod")
    private Integer lootMethod;
    @Column("looterGuid")
    private Long looterGuid;
    @Column("lootThreshold")
    private Integer lootThreshold;
    @Column("icon1")
    private byte[] icon1;
    @Column("icon2")
    private byte[] icon2;
    @Column("icon3")
    private byte[] icon3;
    @Column("icon4")
    private byte[] icon4;
    @Column("icon5")
    private byte[] icon5;
    @Column("icon6")
    private byte[] icon6;
    @Column("icon7")
    private byte[] icon7;
    @Column("icon8")
    private byte[] icon8;
    @Column("groupType")
    private Integer groupType;
    @Column("difficulty")
    private Integer difficulty;
    @Column("raidDifficulty")
    private Integer raidDifficulty;
    @Column("legacyRaidDifficulty")
    private Integer legacyRaidDifficulty;
    @Column("masterLooterGuid")
    private Long masterLooterGuid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Groups> {

        public Groups convert(Row row) {
            Groups domain = new Groups();
            domain.setGuid(row.get("guid", Integer.class));
            domain.setLeaderGuid(row.get("leaderGuid", Long.class));
            domain.setLootMethod(row.get("lootMethod", Integer.class));
            domain.setLooterGuid(row.get("looterGuid", Long.class));
            domain.setLootThreshold(row.get("lootThreshold", Integer.class));
            domain.setIcon1(row.get("icon1", byte[].class));
            domain.setIcon2(row.get("icon2", byte[].class));
            domain.setIcon3(row.get("icon3", byte[].class));
            domain.setIcon4(row.get("icon4", byte[].class));
            domain.setIcon5(row.get("icon5", byte[].class));
            domain.setIcon6(row.get("icon6", byte[].class));
            domain.setIcon7(row.get("icon7", byte[].class));
            domain.setIcon8(row.get("icon8", byte[].class));
            domain.setGroupType(row.get("groupType", Integer.class));
            domain.setDifficulty(row.get("difficulty", Integer.class));
            domain.setRaidDifficulty(row.get("raidDifficulty", Integer.class));
            domain.setLegacyRaidDifficulty(row.get("legacyRaidDifficulty", Integer.class));
            domain.setMasterLooterGuid(row.get("masterLooterGuid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Groups, OutboundRow> {

        public OutboundRow convert(Groups source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getLeaderGuid()).ifPresent(e -> row.put("leaderGuid", Parameter.from(e)));
            Optional.ofNullable(source.getLootMethod()).ifPresent(e -> row.put("lootMethod", Parameter.from(e)));
            Optional.ofNullable(source.getLooterGuid()).ifPresent(e -> row.put("looterGuid", Parameter.from(e)));
            Optional.ofNullable(source.getLootThreshold()).ifPresent(e -> row.put("lootThreshold", Parameter.from(e)));
            Optional.ofNullable(source.getIcon1()).ifPresent(e -> row.put("icon1", Parameter.from(e)));
            Optional.ofNullable(source.getIcon2()).ifPresent(e -> row.put("icon2", Parameter.from(e)));
            Optional.ofNullable(source.getIcon3()).ifPresent(e -> row.put("icon3", Parameter.from(e)));
            Optional.ofNullable(source.getIcon4()).ifPresent(e -> row.put("icon4", Parameter.from(e)));
            Optional.ofNullable(source.getIcon5()).ifPresent(e -> row.put("icon5", Parameter.from(e)));
            Optional.ofNullable(source.getIcon6()).ifPresent(e -> row.put("icon6", Parameter.from(e)));
            Optional.ofNullable(source.getIcon7()).ifPresent(e -> row.put("icon7", Parameter.from(e)));
            Optional.ofNullable(source.getIcon8()).ifPresent(e -> row.put("icon8", Parameter.from(e)));
            Optional.ofNullable(source.getGroupType()).ifPresent(e -> row.put("groupType", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty()).ifPresent(e -> row.put("difficulty", Parameter.from(e)));
            Optional.ofNullable(source.getRaidDifficulty()).ifPresent(e -> row.put("raidDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getLegacyRaidDifficulty()).ifPresent(e -> row.put("legacyRaidDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getMasterLooterGuid()).ifPresent(e -> row.put("masterLooterGuid", Parameter.from(e)));
            return row;
        }
    }

}
