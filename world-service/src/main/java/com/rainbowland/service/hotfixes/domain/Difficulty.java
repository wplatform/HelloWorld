package com.rainbowland.service.hotfixes.domain;

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
@Table("difficulty")
public class Difficulty {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("InstanceType")
    private Integer instanceType;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("OldEnumValue")
    private Integer oldEnumValue;
    @Column("FallbackDifficultyID")
    private Integer fallbackDifficultyId;
    @Column("MinPlayers")
    private Integer minPlayers;
    @Column("MaxPlayers")
    private Integer maxPlayers;
    @Column("Flags")
    private Integer flags;
    @Column("ItemContext")
    private Integer itemContext;
    @Column("ToggleDifficultyID")
    private Integer toggleDifficultyId;
    @Column("GroupSizeHealthCurveID")
    private Integer groupSizeHealthCurveId;
    @Column("GroupSizeDmgCurveID")
    private Integer groupSizeDmgCurveId;
    @Column("GroupSizeSpellPointsCurveID")
    private Integer groupSizeSpellPointsCurveId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Difficulty> {

        public Difficulty convert(Row row) {
            Difficulty domain = new Difficulty();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setInstanceType(row.get("InstanceType", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setOldEnumValue(row.get("OldEnumValue", Integer.class));
            domain.setFallbackDifficultyId(row.get("FallbackDifficultyID", Integer.class));
            domain.setMinPlayers(row.get("MinPlayers", Integer.class));
            domain.setMaxPlayers(row.get("MaxPlayers", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setItemContext(row.get("ItemContext", Integer.class));
            domain.setToggleDifficultyId(row.get("ToggleDifficultyID", Integer.class));
            domain.setGroupSizeHealthCurveId(row.get("GroupSizeHealthCurveID", Integer.class));
            domain.setGroupSizeDmgCurveId(row.get("GroupSizeDmgCurveID", Integer.class));
            domain.setGroupSizeSpellPointsCurveId(row.get("GroupSizeSpellPointsCurveID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Difficulty, OutboundRow> {

        public OutboundRow convert(Difficulty source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceType()).ifPresent(e -> row.put("InstanceType", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getOldEnumValue()).ifPresent(e -> row.put("OldEnumValue", Parameter.from(e)));
            Optional.ofNullable(source.getFallbackDifficultyId()).ifPresent(e -> row.put("FallbackDifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getMinPlayers()).ifPresent(e -> row.put("MinPlayers", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPlayers()).ifPresent(e -> row.put("MaxPlayers", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getItemContext()).ifPresent(e -> row.put("ItemContext", Parameter.from(e)));
            Optional.ofNullable(source.getToggleDifficultyId()).ifPresent(e -> row.put("ToggleDifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getGroupSizeHealthCurveId()).ifPresent(e -> row.put("GroupSizeHealthCurveID", Parameter.from(e)));
            Optional.ofNullable(source.getGroupSizeDmgCurveId()).ifPresent(e -> row.put("GroupSizeDmgCurveID", Parameter.from(e)));
            Optional.ofNullable(source.getGroupSizeSpellPointsCurveId()).ifPresent(e -> row.put("GroupSizeSpellPointsCurveID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
