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
@Table("summon_properties")
public class SummonProperties {

    @Column("ID")
    private Integer id;
    @Column("Control")
    private Integer control;
    @Column("Faction")
    private Integer faction;
    @Column("Title")
    private Integer title;
    @Column("Slot")
    private Integer slot;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SummonProperties> {

        public SummonProperties convert(Row row) {
            SummonProperties domain = new SummonProperties();
            domain.setId(row.get("ID", Integer.class));
            domain.setControl(row.get("Control", Integer.class));
            domain.setFaction(row.get("Faction", Integer.class));
            domain.setTitle(row.get("Title", Integer.class));
            domain.setSlot(row.get("Slot", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SummonProperties, OutboundRow> {

        public OutboundRow convert(SummonProperties source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getControl()).ifPresent(e -> row.put("Control", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("Faction", Parameter.from(e)));
            Optional.ofNullable(source.getTitle()).ifPresent(e -> row.put("Title", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("Slot", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
