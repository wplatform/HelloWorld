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
@Table("chr_customization_req")
public class ChrCustomizationReq {

    @Column("ID")
    private Integer id;
    @Column("Flags")
    private Integer flags;
    @Column("ClassMask")
    private Integer classMask;
    @Column("AchievementID")
    private Integer achievementId;
    @Column("OverrideArchive")
    private Integer overrideArchive;
    @Column("ItemModifiedAppearanceID")
    private Integer itemModifiedAppearanceId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrCustomizationReq> {

        public ChrCustomizationReq convert(Row row) {
            ChrCustomizationReq domain = new ChrCustomizationReq();
            domain.setId(row.get("ID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setClassMask(row.get("ClassMask", Integer.class));
            domain.setAchievementId(row.get("AchievementID", Integer.class));
            domain.setOverrideArchive(row.get("OverrideArchive", Integer.class));
            domain.setItemModifiedAppearanceId(row.get("ItemModifiedAppearanceID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrCustomizationReq, OutboundRow> {

        public OutboundRow convert(ChrCustomizationReq source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getClassMask()).ifPresent(e -> row.put("ClassMask", Parameter.from(e)));
            Optional.ofNullable(source.getAchievementId()).ifPresent(e -> row.put("AchievementID", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideArchive()).ifPresent(e -> row.put("OverrideArchive", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceId()).ifPresent(e -> row.put("ItemModifiedAppearanceID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
