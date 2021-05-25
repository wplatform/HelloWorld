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
@Table("character_favorite_auctions")
public class CharacterFavoriteAuctions {

    @Column("guid")
    private Long guid;
    @Column("order")
    private Integer order;
    @Column("itemId")
    private Integer itemId;
    @Column("itemLevel")
    private Integer itemLevel;
    @Column("battlePetSpeciesId")
    private Integer battlePetSpeciesId;
    @Column("suffixItemNameDescriptionId")
    private Integer suffixItemNameDescriptionId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterFavoriteAuctions> {

        public CharacterFavoriteAuctions convert(Row row) {
            CharacterFavoriteAuctions domain = new CharacterFavoriteAuctions();
            domain.setGuid(row.get("guid", Long.class));
            domain.setOrder(row.get("order", Integer.class));
            domain.setItemId(row.get("itemId", Integer.class));
            domain.setItemLevel(row.get("itemLevel", Integer.class));
            domain.setBattlePetSpeciesId(row.get("battlePetSpeciesId", Integer.class));
            domain.setSuffixItemNameDescriptionId(row.get("suffixItemNameDescriptionId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterFavoriteAuctions, OutboundRow> {

        public OutboundRow convert(CharacterFavoriteAuctions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getOrder()).ifPresent(e -> row.put("order", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("itemId", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("itemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetSpeciesId()).ifPresent(e -> row.put("battlePetSpeciesId", Parameter.from(e)));
            Optional.ofNullable(source.getSuffixItemNameDescriptionId()).ifPresent(e -> row.put("suffixItemNameDescriptionId", Parameter.from(e)));
            return row;
        }
    }

}
