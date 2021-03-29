package com.rainbowland.service.auth.domain;

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
@Table("battle_pet_slots")
public class BattlePetSlot {

    @Column("id")
    private Integer id;
    @Column("battlenetAccountId")
    private Long battlenetAccountId;
    @Column("battlePetGuid")
    private Long battlePetGuid;
    @Column("locked")
    private Integer locked;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetSlot> {

        public BattlePetSlot convert(Row row) {
            BattlePetSlot domain = new BattlePetSlot();
            domain.setId(row.get("id", Integer.class));
            domain.setBattlenetAccountId(row.get("battlenetAccountId", Long.class));
            domain.setBattlePetGuid(row.get("battlePetGuid", Long.class));
            domain.setLocked(row.get("locked", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetSlot, OutboundRow> {

        public OutboundRow convert(BattlePetSlot source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getBattlenetAccountId()).ifPresent(e -> row.put("battlenetAccountId", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetGuid()).ifPresent(e -> row.put("battlePetGuid", Parameter.from(e)));
            Optional.ofNullable(source.getLocked()).ifPresent(e -> row.put("locked", Parameter.from(e)));
            return row;
        }
    }

}
