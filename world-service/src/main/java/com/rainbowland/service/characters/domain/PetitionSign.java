package com.rainbowland.service.characters.domain;

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
@Table("petition_sign")
public class PetitionSign {

    @Column("ownerguid")
    private Long ownerguid;
    @Column("petitionguid")
    private Long petitionguid;
    @Column("playerguid")
    private Long playerguid;
    @Column("player_account")
    private Integer playerAccount;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PetitionSign> {

        public PetitionSign convert(Row row) {
            PetitionSign domain = new PetitionSign();
            domain.setOwnerguid(row.get("ownerguid", Long.class));
            domain.setPetitionguid(row.get("petitionguid", Long.class));
            domain.setPlayerguid(row.get("playerguid", Long.class));
            domain.setPlayerAccount(row.get("player_account", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PetitionSign, OutboundRow> {

        public OutboundRow convert(PetitionSign source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getOwnerguid()).ifPresent(e -> row.put("ownerguid", Parameter.from(e)));
            Optional.ofNullable(source.getPetitionguid()).ifPresent(e -> row.put("petitionguid", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerguid()).ifPresent(e -> row.put("playerguid", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerAccount()).ifPresent(e -> row.put("player_account", Parameter.from(e)));
            return row;
        }
    }

}
