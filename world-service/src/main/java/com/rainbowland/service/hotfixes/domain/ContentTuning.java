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
@Table("content_tuning")
public class ContentTuning {

    @Column("ID")
    private Integer id;
    @Column("Flags")
    private Integer flags;
    @Column("ExpansionID")
    private Integer expansionId;
    @Column("MinLevel")
    private Integer minLevel;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("MinLevelType")
    private Integer minLevelType;
    @Column("MaxLevelType")
    private Integer maxLevelType;
    @Column("TargetLevelDelta")
    private Integer targetLevelDelta;
    @Column("TargetLevelMaxDelta")
    private Integer targetLevelMaxDelta;
    @Column("TargetLevelMin")
    private Integer targetLevelMin;
    @Column("TargetLevelMax")
    private Integer targetLevelMax;
    @Column("MinItemLevel")
    private Integer minItemLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ContentTuning> {

        public ContentTuning convert(Row row) {
            ContentTuning domain = new ContentTuning();
            domain.setId(row.get("ID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setExpansionId(row.get("ExpansionID", Integer.class));
            domain.setMinLevel(row.get("MinLevel", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setMinLevelType(row.get("MinLevelType", Integer.class));
            domain.setMaxLevelType(row.get("MaxLevelType", Integer.class));
            domain.setTargetLevelDelta(row.get("TargetLevelDelta", Integer.class));
            domain.setTargetLevelMaxDelta(row.get("TargetLevelMaxDelta", Integer.class));
            domain.setTargetLevelMin(row.get("TargetLevelMin", Integer.class));
            domain.setTargetLevelMax(row.get("TargetLevelMax", Integer.class));
            domain.setMinItemLevel(row.get("MinItemLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ContentTuning, OutboundRow> {

        public OutboundRow convert(ContentTuning source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionId()).ifPresent(e -> row.put("ExpansionID", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevel()).ifPresent(e -> row.put("MinLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevelType()).ifPresent(e -> row.put("MinLevelType", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevelType()).ifPresent(e -> row.put("MaxLevelType", Parameter.from(e)));
            Optional.ofNullable(source.getTargetLevelDelta()).ifPresent(e -> row.put("TargetLevelDelta", Parameter.from(e)));
            Optional.ofNullable(source.getTargetLevelMaxDelta()).ifPresent(e -> row.put("TargetLevelMaxDelta", Parameter.from(e)));
            Optional.ofNullable(source.getTargetLevelMin()).ifPresent(e -> row.put("TargetLevelMin", Parameter.from(e)));
            Optional.ofNullable(source.getTargetLevelMax()).ifPresent(e -> row.put("TargetLevelMax", Parameter.from(e)));
            Optional.ofNullable(source.getMinItemLevel()).ifPresent(e -> row.put("MinItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
