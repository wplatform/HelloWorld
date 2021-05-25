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
@Table("scenario")
public class Scenario {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("AreaTableID")
    private Integer areaTableId;
    @Column("Type")
    private Integer type;
    @Column("Flags")
    private Integer flags;
    @Column("UiTextureKitID")
    private Integer uiTextureKitId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Scenario> {

        public Scenario convert(Row row) {
            Scenario domain = new Scenario();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setAreaTableId(row.get("AreaTableID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setUiTextureKitId(row.get("UiTextureKitID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Scenario, OutboundRow> {

        public OutboundRow convert(Scenario source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getAreaTableId()).ifPresent(e -> row.put("AreaTableID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureKitId()).ifPresent(e -> row.put("UiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
