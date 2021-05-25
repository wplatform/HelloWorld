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
@Table("character_garrison_follower_abilities")
public class CharacterGarrisonFollowerAbilities {

    @Column("dbId")
    private Long dbId;
    @Column("abilityId")
    private Integer abilityId;
    @Column("slot")
    private Integer slot;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterGarrisonFollowerAbilities> {

        public CharacterGarrisonFollowerAbilities convert(Row row) {
            CharacterGarrisonFollowerAbilities domain = new CharacterGarrisonFollowerAbilities();
            domain.setDbId(row.get("dbId", Long.class));
            domain.setAbilityId(row.get("abilityId", Integer.class));
            domain.setSlot(row.get("slot", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterGarrisonFollowerAbilities, OutboundRow> {

        public OutboundRow convert(CharacterGarrisonFollowerAbilities source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDbId()).ifPresent(e -> row.put("dbId", Parameter.from(e)));
            Optional.ofNullable(source.getAbilityId()).ifPresent(e -> row.put("abilityId", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("slot", Parameter.from(e)));
            return row;
        }
    }

}
