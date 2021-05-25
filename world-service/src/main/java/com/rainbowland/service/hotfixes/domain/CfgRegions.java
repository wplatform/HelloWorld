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
@Table("cfg_regions")
public class CfgRegions {

    @Column("ID")
    private Integer id;
    @Column("Tag")
    private String tag;
    @Column("RegionID")
    private Integer regionId;
    @Column("Raidorigin")
    private Integer raidorigin;
    @Column("RegionGroupMask")
    private Integer regionGroupMask;
    @Column("ChallengeOrigin")
    private Integer challengeOrigin;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CfgRegions> {

        public CfgRegions convert(Row row) {
            CfgRegions domain = new CfgRegions();
            domain.setId(row.get("ID", Integer.class));
            domain.setTag(row.get("Tag", String.class));
            domain.setRegionId(row.get("RegionID", Integer.class));
            domain.setRaidorigin(row.get("Raidorigin", Integer.class));
            domain.setRegionGroupMask(row.get("RegionGroupMask", Integer.class));
            domain.setChallengeOrigin(row.get("ChallengeOrigin", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CfgRegions, OutboundRow> {

        public OutboundRow convert(CfgRegions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getTag()).ifPresent(e -> row.put("Tag", Parameter.from(e)));
            Optional.ofNullable(source.getRegionId()).ifPresent(e -> row.put("RegionID", Parameter.from(e)));
            Optional.ofNullable(source.getRaidorigin()).ifPresent(e -> row.put("Raidorigin", Parameter.from(e)));
            Optional.ofNullable(source.getRegionGroupMask()).ifPresent(e -> row.put("RegionGroupMask", Parameter.from(e)));
            Optional.ofNullable(source.getChallengeOrigin()).ifPresent(e -> row.put("ChallengeOrigin", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
