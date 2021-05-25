package com.rainbowland.service.world.domain;

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
@Table("mount_definitions")
public class MountDefinitions {

    @Column("spellId")
    private Integer spellId;
    @Column("otherFactionSpellId")
    private Integer otherFactionSpellId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MountDefinitions> {

        public MountDefinitions convert(Row row) {
            MountDefinitions domain = new MountDefinitions();
            domain.setSpellId(row.get("spellId", Integer.class));
            domain.setOtherFactionSpellId(row.get("otherFactionSpellId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MountDefinitions, OutboundRow> {

        public OutboundRow convert(MountDefinitions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spellId", Parameter.from(e)));
            Optional.ofNullable(source.getOtherFactionSpellId()).ifPresent(e -> row.put("otherFactionSpellId", Parameter.from(e)));
            return row;
        }
    }

}
