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
@Table("item_disenchant_loot")
public class ItemDisenchantLoot {

    @Column("ID")
    private Integer id;
    @Column("Subclass")
    private Integer subclass;
    @Column("Quality")
    private Integer quality;
    @Column("MinLevel")
    private Integer minLevel;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("SkillRequired")
    private Integer skillRequired;
    @Column("ExpansionID")
    private Integer expansionId;
    @Column("Class")
    private Integer klass;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemDisenchantLoot> {

        public ItemDisenchantLoot convert(Row row) {
            ItemDisenchantLoot domain = new ItemDisenchantLoot();
            domain.setId(row.get("ID", Integer.class));
            domain.setSubclass(row.get("Subclass", Integer.class));
            domain.setQuality(row.get("Quality", Integer.class));
            domain.setMinLevel(row.get("MinLevel", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setSkillRequired(row.get("SkillRequired", Integer.class));
            domain.setExpansionId(row.get("ExpansionID", Integer.class));
            domain.setKlass(row.get("Class", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemDisenchantLoot, OutboundRow> {

        public OutboundRow convert(ItemDisenchantLoot source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSubclass()).ifPresent(e -> row.put("Subclass", Parameter.from(e)));
            Optional.ofNullable(source.getQuality()).ifPresent(e -> row.put("Quality", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevel()).ifPresent(e -> row.put("MinLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getSkillRequired()).ifPresent(e -> row.put("SkillRequired", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionId()).ifPresent(e -> row.put("ExpansionID", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("Class", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
