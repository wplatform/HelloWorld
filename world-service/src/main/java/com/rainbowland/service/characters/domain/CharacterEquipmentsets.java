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
@Table("character_equipmentsets")
public class CharacterEquipmentsets {

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
    @Column("AssignedSpecIndex")
    private Integer assignedSpecIndex;
    @Column("item0")
    private Long item0;
    @Column("item1")
    private Long item1;
    @Column("item2")
    private Long item2;
    @Column("item3")
    private Long item3;
    @Column("item4")
    private Long item4;
    @Column("item5")
    private Long item5;
    @Column("item6")
    private Long item6;
    @Column("item7")
    private Long item7;
    @Column("item8")
    private Long item8;
    @Column("item9")
    private Long item9;
    @Column("item10")
    private Long item10;
    @Column("item11")
    private Long item11;
    @Column("item12")
    private Long item12;
    @Column("item13")
    private Long item13;
    @Column("item14")
    private Long item14;
    @Column("item15")
    private Long item15;
    @Column("item16")
    private Long item16;
    @Column("item17")
    private Long item17;
    @Column("item18")
    private Long item18;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterEquipmentsets> {

        public CharacterEquipmentsets convert(Row row) {
            CharacterEquipmentsets domain = new CharacterEquipmentsets();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSetguid(row.get("setguid", Long.class));
            domain.setSetindex(row.get("setindex", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setIconname(row.get("iconname", String.class));
            domain.setIgnoreMask(row.get("ignore_mask", Integer.class));
            domain.setAssignedSpecIndex(row.get("AssignedSpecIndex", Integer.class));
            domain.setItem0(row.get("item0", Long.class));
            domain.setItem1(row.get("item1", Long.class));
            domain.setItem2(row.get("item2", Long.class));
            domain.setItem3(row.get("item3", Long.class));
            domain.setItem4(row.get("item4", Long.class));
            domain.setItem5(row.get("item5", Long.class));
            domain.setItem6(row.get("item6", Long.class));
            domain.setItem7(row.get("item7", Long.class));
            domain.setItem8(row.get("item8", Long.class));
            domain.setItem9(row.get("item9", Long.class));
            domain.setItem10(row.get("item10", Long.class));
            domain.setItem11(row.get("item11", Long.class));
            domain.setItem12(row.get("item12", Long.class));
            domain.setItem13(row.get("item13", Long.class));
            domain.setItem14(row.get("item14", Long.class));
            domain.setItem15(row.get("item15", Long.class));
            domain.setItem16(row.get("item16", Long.class));
            domain.setItem17(row.get("item17", Long.class));
            domain.setItem18(row.get("item18", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterEquipmentsets, OutboundRow> {

        public OutboundRow convert(CharacterEquipmentsets source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSetguid()).ifPresent(e -> row.put("setguid", Parameter.from(e)));
            Optional.ofNullable(source.getSetindex()).ifPresent(e -> row.put("setindex", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getIconname()).ifPresent(e -> row.put("iconname", Parameter.from(e)));
            Optional.ofNullable(source.getIgnoreMask()).ifPresent(e -> row.put("ignore_mask", Parameter.from(e)));
            Optional.ofNullable(source.getAssignedSpecIndex()).ifPresent(e -> row.put("AssignedSpecIndex", Parameter.from(e)));
            Optional.ofNullable(source.getItem0()).ifPresent(e -> row.put("item0", Parameter.from(e)));
            Optional.ofNullable(source.getItem1()).ifPresent(e -> row.put("item1", Parameter.from(e)));
            Optional.ofNullable(source.getItem2()).ifPresent(e -> row.put("item2", Parameter.from(e)));
            Optional.ofNullable(source.getItem3()).ifPresent(e -> row.put("item3", Parameter.from(e)));
            Optional.ofNullable(source.getItem4()).ifPresent(e -> row.put("item4", Parameter.from(e)));
            Optional.ofNullable(source.getItem5()).ifPresent(e -> row.put("item5", Parameter.from(e)));
            Optional.ofNullable(source.getItem6()).ifPresent(e -> row.put("item6", Parameter.from(e)));
            Optional.ofNullable(source.getItem7()).ifPresent(e -> row.put("item7", Parameter.from(e)));
            Optional.ofNullable(source.getItem8()).ifPresent(e -> row.put("item8", Parameter.from(e)));
            Optional.ofNullable(source.getItem9()).ifPresent(e -> row.put("item9", Parameter.from(e)));
            Optional.ofNullable(source.getItem10()).ifPresent(e -> row.put("item10", Parameter.from(e)));
            Optional.ofNullable(source.getItem11()).ifPresent(e -> row.put("item11", Parameter.from(e)));
            Optional.ofNullable(source.getItem12()).ifPresent(e -> row.put("item12", Parameter.from(e)));
            Optional.ofNullable(source.getItem13()).ifPresent(e -> row.put("item13", Parameter.from(e)));
            Optional.ofNullable(source.getItem14()).ifPresent(e -> row.put("item14", Parameter.from(e)));
            Optional.ofNullable(source.getItem15()).ifPresent(e -> row.put("item15", Parameter.from(e)));
            Optional.ofNullable(source.getItem16()).ifPresent(e -> row.put("item16", Parameter.from(e)));
            Optional.ofNullable(source.getItem17()).ifPresent(e -> row.put("item17", Parameter.from(e)));
            Optional.ofNullable(source.getItem18()).ifPresent(e -> row.put("item18", Parameter.from(e)));
            return row;
        }
    }

}
