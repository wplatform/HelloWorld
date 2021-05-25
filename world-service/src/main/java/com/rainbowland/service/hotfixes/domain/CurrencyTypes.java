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
@Table("currency_types")
public class CurrencyTypes {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("Description")
    private String description;
    @Column("CategoryID")
    private Integer categoryId;
    @Column("InventoryIconFileID")
    private Integer inventoryIconFileId;
    @Column("SpellWeight")
    private Integer spellWeight;
    @Column("SpellCategory")
    private Integer spellCategory;
    @Column("MaxQty")
    private Integer maxQty;
    @Column("MaxEarnablePerWeek")
    private Integer maxEarnablePerWeek;
    @Column("Quality")
    private Integer quality;
    @Column("FactionID")
    private Integer factionId;
    @Column("ItemGroupSoundsID")
    private Integer itemGroupSoundsId;
    @Column("XpQuestDifficulty")
    private Integer xpQuestDifficulty;
    @Column("AwardConditionID")
    private Integer awardConditionId;
    @Column("MaxQtyWorldStateID")
    private Integer maxQtyWorldStateId;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CurrencyTypes> {

        public CurrencyTypes convert(Row row) {
            CurrencyTypes domain = new CurrencyTypes();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setCategoryId(row.get("CategoryID", Integer.class));
            domain.setInventoryIconFileId(row.get("InventoryIconFileID", Integer.class));
            domain.setSpellWeight(row.get("SpellWeight", Integer.class));
            domain.setSpellCategory(row.get("SpellCategory", Integer.class));
            domain.setMaxQty(row.get("MaxQty", Integer.class));
            domain.setMaxEarnablePerWeek(row.get("MaxEarnablePerWeek", Integer.class));
            domain.setQuality(row.get("Quality", Integer.class));
            domain.setFactionId(row.get("FactionID", Integer.class));
            domain.setItemGroupSoundsId(row.get("ItemGroupSoundsID", Integer.class));
            domain.setXpQuestDifficulty(row.get("XpQuestDifficulty", Integer.class));
            domain.setAwardConditionId(row.get("AwardConditionID", Integer.class));
            domain.setMaxQtyWorldStateId(row.get("MaxQtyWorldStateID", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CurrencyTypes, OutboundRow> {

        public OutboundRow convert(CurrencyTypes source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryId()).ifPresent(e -> row.put("CategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getInventoryIconFileId()).ifPresent(e -> row.put("InventoryIconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellWeight()).ifPresent(e -> row.put("SpellWeight", Parameter.from(e)));
            Optional.ofNullable(source.getSpellCategory()).ifPresent(e -> row.put("SpellCategory", Parameter.from(e)));
            Optional.ofNullable(source.getMaxQty()).ifPresent(e -> row.put("MaxQty", Parameter.from(e)));
            Optional.ofNullable(source.getMaxEarnablePerWeek()).ifPresent(e -> row.put("MaxEarnablePerWeek", Parameter.from(e)));
            Optional.ofNullable(source.getQuality()).ifPresent(e -> row.put("Quality", Parameter.from(e)));
            Optional.ofNullable(source.getFactionId()).ifPresent(e -> row.put("FactionID", Parameter.from(e)));
            Optional.ofNullable(source.getItemGroupSoundsId()).ifPresent(e -> row.put("ItemGroupSoundsID", Parameter.from(e)));
            Optional.ofNullable(source.getXpQuestDifficulty()).ifPresent(e -> row.put("XpQuestDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getAwardConditionId()).ifPresent(e -> row.put("AwardConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxQtyWorldStateId()).ifPresent(e -> row.put("MaxQtyWorldStateID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
