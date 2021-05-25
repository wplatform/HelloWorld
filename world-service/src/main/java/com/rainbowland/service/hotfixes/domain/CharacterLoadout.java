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
@Table("character_loadout")
public class CharacterLoadout {

    @Column("RaceMask")
    private Long raceMask;
    @Column("ID")
    private Integer id;
    @Column("ChrClassID")
    private Integer chrClassId;
    @Column("Purpose")
    private Integer purpose;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterLoadout> {

        public CharacterLoadout convert(Row row) {
            CharacterLoadout domain = new CharacterLoadout();
            domain.setRaceMask(row.get("RaceMask", Long.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setChrClassId(row.get("ChrClassID", Integer.class));
            domain.setPurpose(row.get("Purpose", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterLoadout, OutboundRow> {

        public OutboundRow convert(CharacterLoadout source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("RaceMask", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrClassId()).ifPresent(e -> row.put("ChrClassID", Parameter.from(e)));
            Optional.ofNullable(source.getPurpose()).ifPresent(e -> row.put("Purpose", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
