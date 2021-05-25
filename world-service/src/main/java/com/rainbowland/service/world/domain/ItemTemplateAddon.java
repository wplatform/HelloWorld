package com.rainbowland.service.world.domain;

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
@Table("item_template_addon")
public class ItemTemplateAddon {

    @Column("Id")
    private Integer id;
    @Column("FlagsCu")
    private Integer flagsCu;
    @Column("FoodType")
    private Integer foodType;
    @Column("MinMoneyLoot")
    private Integer minMoneyLoot;
    @Column("MaxMoneyLoot")
    private Integer maxMoneyLoot;
    @Column("SpellPPMChance")
    private Double spellPpmChance;
    @Column("RandomBonusListTemplateId")
    private Integer randomBonusListTemplateId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemTemplateAddon> {

        public ItemTemplateAddon convert(Row row) {
            ItemTemplateAddon domain = new ItemTemplateAddon();
            domain.setId(row.get("Id", Integer.class));
            domain.setFlagsCu(row.get("FlagsCu", Integer.class));
            domain.setFoodType(row.get("FoodType", Integer.class));
            domain.setMinMoneyLoot(row.get("MinMoneyLoot", Integer.class));
            domain.setMaxMoneyLoot(row.get("MaxMoneyLoot", Integer.class));
            domain.setSpellPpmChance(row.get("SpellPPMChance", Double.class));
            domain.setRandomBonusListTemplateId(row.get("RandomBonusListTemplateId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemTemplateAddon, OutboundRow> {

        public OutboundRow convert(ItemTemplateAddon source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getFlagsCu()).ifPresent(e -> row.put("FlagsCu", Parameter.from(e)));
            Optional.ofNullable(source.getFoodType()).ifPresent(e -> row.put("FoodType", Parameter.from(e)));
            Optional.ofNullable(source.getMinMoneyLoot()).ifPresent(e -> row.put("MinMoneyLoot", Parameter.from(e)));
            Optional.ofNullable(source.getMaxMoneyLoot()).ifPresent(e -> row.put("MaxMoneyLoot", Parameter.from(e)));
            Optional.ofNullable(source.getSpellPpmChance()).ifPresent(e -> row.put("SpellPPMChance", Parameter.from(e)));
            Optional.ofNullable(source.getRandomBonusListTemplateId()).ifPresent(e -> row.put("RandomBonusListTemplateId", Parameter.from(e)));
            return row;
        }
    }

}
