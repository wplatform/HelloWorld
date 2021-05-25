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
@Table("prestige_level_info")
public class PrestigeLevelInfo {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("PrestigeLevel")
    private Integer prestigeLevel;
    @Column("BadgeTextureFileDataID")
    private Integer badgeTextureFileDataId;
    @Column("Flags")
    private Integer flags;
    @Column("AwardedAchievementID")
    private Integer awardedAchievementId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PrestigeLevelInfo> {

        public PrestigeLevelInfo convert(Row row) {
            PrestigeLevelInfo domain = new PrestigeLevelInfo();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setPrestigeLevel(row.get("PrestigeLevel", Integer.class));
            domain.setBadgeTextureFileDataId(row.get("BadgeTextureFileDataID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setAwardedAchievementId(row.get("AwardedAchievementID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PrestigeLevelInfo, OutboundRow> {

        public OutboundRow convert(PrestigeLevelInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getPrestigeLevel()).ifPresent(e -> row.put("PrestigeLevel", Parameter.from(e)));
            Optional.ofNullable(source.getBadgeTextureFileDataId()).ifPresent(e -> row.put("BadgeTextureFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getAwardedAchievementId()).ifPresent(e -> row.put("AwardedAchievementID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
