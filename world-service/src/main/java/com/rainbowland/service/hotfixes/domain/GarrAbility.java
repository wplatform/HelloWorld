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
@Table("garr_ability")
public class GarrAbility {

    @Column("Name")
    private String name;
    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("GarrAbilityCategoryID")
    private Integer garrAbilityCategoryId;
    @Column("GarrFollowerTypeID")
    private Integer garrFollowerTypeId;
    @Column("IconFileDataID")
    private Integer iconFileDataId;
    @Column("FactionChangeGarrAbilityID")
    private Integer factionChangeGarrAbilityId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrAbility> {

        public GarrAbility convert(Row row) {
            GarrAbility domain = new GarrAbility();
            domain.setName(row.get("Name", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setGarrAbilityCategoryId(row.get("GarrAbilityCategoryID", Integer.class));
            domain.setGarrFollowerTypeId(row.get("GarrFollowerTypeID", Integer.class));
            domain.setIconFileDataId(row.get("IconFileDataID", Integer.class));
            domain.setFactionChangeGarrAbilityId(row.get("FactionChangeGarrAbilityID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrAbility, OutboundRow> {

        public OutboundRow convert(GarrAbility source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrAbilityCategoryId()).ifPresent(e -> row.put("GarrAbilityCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrFollowerTypeId()).ifPresent(e -> row.put("GarrFollowerTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileDataId()).ifPresent(e -> row.put("IconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getFactionChangeGarrAbilityId()).ifPresent(e -> row.put("FactionChangeGarrAbilityID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
