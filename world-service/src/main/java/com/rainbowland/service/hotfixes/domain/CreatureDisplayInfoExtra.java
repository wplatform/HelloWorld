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
@Table("creature_display_info_extra")
public class CreatureDisplayInfoExtra {

    @Column("ID")
    private Integer id;
    @Column("DisplayRaceID")
    private Integer displayRaceId;
    @Column("DisplaySexID")
    private Integer displaySexId;
    @Column("DisplayClassID")
    private Integer displayClassId;
    @Column("Flags")
    private Integer flags;
    @Column("BakeMaterialResourcesID")
    private Integer bakeMaterialResourcesId;
    @Column("HDBakeMaterialResourcesID")
    private Integer hdBakeMaterialResourcesId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureDisplayInfoExtra> {

        public CreatureDisplayInfoExtra convert(Row row) {
            CreatureDisplayInfoExtra domain = new CreatureDisplayInfoExtra();
            domain.setId(row.get("ID", Integer.class));
            domain.setDisplayRaceId(row.get("DisplayRaceID", Integer.class));
            domain.setDisplaySexId(row.get("DisplaySexID", Integer.class));
            domain.setDisplayClassId(row.get("DisplayClassID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setBakeMaterialResourcesId(row.get("BakeMaterialResourcesID", Integer.class));
            domain.setHdBakeMaterialResourcesId(row.get("HDBakeMaterialResourcesID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureDisplayInfoExtra, OutboundRow> {

        public OutboundRow convert(CreatureDisplayInfoExtra source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayRaceId()).ifPresent(e -> row.put("DisplayRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplaySexId()).ifPresent(e -> row.put("DisplaySexID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayClassId()).ifPresent(e -> row.put("DisplayClassID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getBakeMaterialResourcesId()).ifPresent(e -> row.put("BakeMaterialResourcesID", Parameter.from(e)));
            Optional.ofNullable(source.getHdBakeMaterialResourcesId()).ifPresent(e -> row.put("HDBakeMaterialResourcesID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
