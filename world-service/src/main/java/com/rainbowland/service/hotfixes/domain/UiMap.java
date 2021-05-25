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
@Table("ui_map")
public class UiMap {

    @Column("Name")
    private String name;
    @Column("ID")
    private Integer id;
    @Column("ParentUiMapID")
    private Integer parentUiMapId;
    @Column("Flags")
    private Integer flags;
    @Column("System")
    private Integer system;
    @Column("Type")
    private Integer type;
    @Column("BountySetID")
    private Integer bountySetId;
    @Column("BountyDisplayLocation")
    private Integer bountyDisplayLocation;
    @Column("VisibilityPlayerConditionID")
    private Integer visibilityPlayerConditionId;
    @Column("HelpTextPosition")
    private Integer helpTextPosition;
    @Column("BkgAtlasID")
    private Integer bkgAtlasId;
    @Column("AlternateUiMapGroup")
    private Integer alternateUiMapGroup;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, UiMap> {

        public UiMap convert(Row row) {
            UiMap domain = new UiMap();
            domain.setName(row.get("Name", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setParentUiMapId(row.get("ParentUiMapID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSystem(row.get("System", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setBountySetId(row.get("BountySetID", Integer.class));
            domain.setBountyDisplayLocation(row.get("BountyDisplayLocation", Integer.class));
            domain.setVisibilityPlayerConditionId(row.get("VisibilityPlayerConditionID", Integer.class));
            domain.setHelpTextPosition(row.get("HelpTextPosition", Integer.class));
            domain.setBkgAtlasId(row.get("BkgAtlasID", Integer.class));
            domain.setAlternateUiMapGroup(row.get("AlternateUiMapGroup", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<UiMap, OutboundRow> {

        public OutboundRow convert(UiMap source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getParentUiMapId()).ifPresent(e -> row.put("ParentUiMapID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSystem()).ifPresent(e -> row.put("System", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getBountySetId()).ifPresent(e -> row.put("BountySetID", Parameter.from(e)));
            Optional.ofNullable(source.getBountyDisplayLocation()).ifPresent(e -> row.put("BountyDisplayLocation", Parameter.from(e)));
            Optional.ofNullable(source.getVisibilityPlayerConditionId()).ifPresent(e -> row.put("VisibilityPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getHelpTextPosition()).ifPresent(e -> row.put("HelpTextPosition", Parameter.from(e)));
            Optional.ofNullable(source.getBkgAtlasId()).ifPresent(e -> row.put("BkgAtlasID", Parameter.from(e)));
            Optional.ofNullable(source.getAlternateUiMapGroup()).ifPresent(e -> row.put("AlternateUiMapGroup", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
