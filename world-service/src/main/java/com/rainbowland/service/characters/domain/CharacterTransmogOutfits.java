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
@Table("character_transmog_outfits")
public class CharacterTransmogOutfits {

    @Column("guid")
    private Long guid;
    @Column("setguid")
    private Long setguid;
    @Column("setindex")
    private Integer setindex;
    @Column("name")
    private String name;
    @Column("iconname")
    private String iconname;
    @Column("ignore_mask")
    private Integer ignoreMask;
    @Column("appearance0")
    private Integer appearance0;
    @Column("appearance1")
    private Integer appearance1;
    @Column("appearance2")
    private Integer appearance2;
    @Column("appearance3")
    private Integer appearance3;
    @Column("appearance4")
    private Integer appearance4;
    @Column("appearance5")
    private Integer appearance5;
    @Column("appearance6")
    private Integer appearance6;
    @Column("appearance7")
    private Integer appearance7;
    @Column("appearance8")
    private Integer appearance8;
    @Column("appearance9")
    private Integer appearance9;
    @Column("appearance10")
    private Integer appearance10;
    @Column("appearance11")
    private Integer appearance11;
    @Column("appearance12")
    private Integer appearance12;
    @Column("appearance13")
    private Integer appearance13;
    @Column("appearance14")
    private Integer appearance14;
    @Column("appearance15")
    private Integer appearance15;
    @Column("appearance16")
    private Integer appearance16;
    @Column("appearance17")
    private Integer appearance17;
    @Column("appearance18")
    private Integer appearance18;
    @Column("mainHandEnchant")
    private Integer mainHandEnchant;
    @Column("offHandEnchant")
    private Integer offHandEnchant;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterTransmogOutfits> {

        public CharacterTransmogOutfits convert(Row row) {
            CharacterTransmogOutfits domain = new CharacterTransmogOutfits();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSetguid(row.get("setguid", Long.class));
            domain.setSetindex(row.get("setindex", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setIconname(row.get("iconname", String.class));
            domain.setIgnoreMask(row.get("ignore_mask", Integer.class));
            domain.setAppearance0(row.get("appearance0", Integer.class));
            domain.setAppearance1(row.get("appearance1", Integer.class));
            domain.setAppearance2(row.get("appearance2", Integer.class));
            domain.setAppearance3(row.get("appearance3", Integer.class));
            domain.setAppearance4(row.get("appearance4", Integer.class));
            domain.setAppearance5(row.get("appearance5", Integer.class));
            domain.setAppearance6(row.get("appearance6", Integer.class));
            domain.setAppearance7(row.get("appearance7", Integer.class));
            domain.setAppearance8(row.get("appearance8", Integer.class));
            domain.setAppearance9(row.get("appearance9", Integer.class));
            domain.setAppearance10(row.get("appearance10", Integer.class));
            domain.setAppearance11(row.get("appearance11", Integer.class));
            domain.setAppearance12(row.get("appearance12", Integer.class));
            domain.setAppearance13(row.get("appearance13", Integer.class));
            domain.setAppearance14(row.get("appearance14", Integer.class));
            domain.setAppearance15(row.get("appearance15", Integer.class));
            domain.setAppearance16(row.get("appearance16", Integer.class));
            domain.setAppearance17(row.get("appearance17", Integer.class));
            domain.setAppearance18(row.get("appearance18", Integer.class));
            domain.setMainHandEnchant(row.get("mainHandEnchant", Integer.class));
            domain.setOffHandEnchant(row.get("offHandEnchant", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterTransmogOutfits, OutboundRow> {

        public OutboundRow convert(CharacterTransmogOutfits source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSetguid()).ifPresent(e -> row.put("setguid", Parameter.from(e)));
            Optional.ofNullable(source.getSetindex()).ifPresent(e -> row.put("setindex", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getIconname()).ifPresent(e -> row.put("iconname", Parameter.from(e)));
            Optional.ofNullable(source.getIgnoreMask()).ifPresent(e -> row.put("ignore_mask", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance0()).ifPresent(e -> row.put("appearance0", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance1()).ifPresent(e -> row.put("appearance1", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance2()).ifPresent(e -> row.put("appearance2", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance3()).ifPresent(e -> row.put("appearance3", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance4()).ifPresent(e -> row.put("appearance4", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance5()).ifPresent(e -> row.put("appearance5", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance6()).ifPresent(e -> row.put("appearance6", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance7()).ifPresent(e -> row.put("appearance7", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance8()).ifPresent(e -> row.put("appearance8", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance9()).ifPresent(e -> row.put("appearance9", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance10()).ifPresent(e -> row.put("appearance10", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance11()).ifPresent(e -> row.put("appearance11", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance12()).ifPresent(e -> row.put("appearance12", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance13()).ifPresent(e -> row.put("appearance13", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance14()).ifPresent(e -> row.put("appearance14", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance15()).ifPresent(e -> row.put("appearance15", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance16()).ifPresent(e -> row.put("appearance16", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance17()).ifPresent(e -> row.put("appearance17", Parameter.from(e)));
            Optional.ofNullable(source.getAppearance18()).ifPresent(e -> row.put("appearance18", Parameter.from(e)));
            Optional.ofNullable(source.getMainHandEnchant()).ifPresent(e -> row.put("mainHandEnchant", Parameter.from(e)));
            Optional.ofNullable(source.getOffHandEnchant()).ifPresent(e -> row.put("offHandEnchant", Parameter.from(e)));
            return row;
        }
    }

}
