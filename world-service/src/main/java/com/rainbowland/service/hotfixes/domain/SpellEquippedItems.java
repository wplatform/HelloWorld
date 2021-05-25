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
@Table("spell_equipped_items")
public class SpellEquippedItems {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("EquippedItemClass")
    private Integer equippedItemClass;
    @Column("EquippedItemInvTypes")
    private Integer equippedItemInvTypes;
    @Column("EquippedItemSubclass")
    private Integer equippedItemSubclass;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellEquippedItems> {

        public SpellEquippedItems convert(Row row) {
            SpellEquippedItems domain = new SpellEquippedItems();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setEquippedItemClass(row.get("EquippedItemClass", Integer.class));
            domain.setEquippedItemInvTypes(row.get("EquippedItemInvTypes", Integer.class));
            domain.setEquippedItemSubclass(row.get("EquippedItemSubclass", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellEquippedItems, OutboundRow> {

        public OutboundRow convert(SpellEquippedItems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getEquippedItemClass()).ifPresent(e -> row.put("EquippedItemClass", Parameter.from(e)));
            Optional.ofNullable(source.getEquippedItemInvTypes()).ifPresent(e -> row.put("EquippedItemInvTypes", Parameter.from(e)));
            Optional.ofNullable(source.getEquippedItemSubclass()).ifPresent(e -> row.put("EquippedItemSubclass", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
