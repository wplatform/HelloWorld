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
@Table("item_effect")
public class ItemEffect {

    @Column("ID")
    private Integer id;
    @Column("LegacySlotIndex")
    private Integer legacySlotIndex;
    @Column("TriggerType")
    private Integer triggerType;
    @Column("Charges")
    private Integer charges;
    @Column("CoolDownMSec")
    private Integer coolDownMSec;
    @Column("CategoryCoolDownMSec")
    private Integer categoryCoolDownMSec;
    @Column("SpellCategoryID")
    private Integer spellCategoryId;
    @Column("SpellID")
    private Integer spellId;
    @Column("ChrSpecializationID")
    private Integer chrSpecializationId;
    @Column("ParentItemID")
    private Integer parentItemId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemEffect> {

        public ItemEffect convert(Row row) {
            ItemEffect domain = new ItemEffect();
            domain.setId(row.get("ID", Integer.class));
            domain.setLegacySlotIndex(row.get("LegacySlotIndex", Integer.class));
            domain.setTriggerType(row.get("TriggerType", Integer.class));
            domain.setCharges(row.get("Charges", Integer.class));
            domain.setCoolDownMSec(row.get("CoolDownMSec", Integer.class));
            domain.setCategoryCoolDownMSec(row.get("CategoryCoolDownMSec", Integer.class));
            domain.setSpellCategoryId(row.get("SpellCategoryID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setChrSpecializationId(row.get("ChrSpecializationID", Integer.class));
            domain.setParentItemId(row.get("ParentItemID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemEffect, OutboundRow> {

        public OutboundRow convert(ItemEffect source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLegacySlotIndex()).ifPresent(e -> row.put("LegacySlotIndex", Parameter.from(e)));
            Optional.ofNullable(source.getTriggerType()).ifPresent(e -> row.put("TriggerType", Parameter.from(e)));
            Optional.ofNullable(source.getCharges()).ifPresent(e -> row.put("Charges", Parameter.from(e)));
            Optional.ofNullable(source.getCoolDownMSec()).ifPresent(e -> row.put("CoolDownMSec", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryCoolDownMSec()).ifPresent(e -> row.put("CategoryCoolDownMSec", Parameter.from(e)));
            Optional.ofNullable(source.getSpellCategoryId()).ifPresent(e -> row.put("SpellCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getChrSpecializationId()).ifPresent(e -> row.put("ChrSpecializationID", Parameter.from(e)));
            Optional.ofNullable(source.getParentItemId()).ifPresent(e -> row.put("ParentItemID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
