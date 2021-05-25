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
@Table("item_loot_items")
public class ItemLootItems {

    @Column("container_id")
    private Long containerId;
    @Column("item_id")
    private Integer itemId;
    @Column("item_count")
    private Integer itemCount;
    @Column("follow_rules")
    private Integer followRules;
    @Column("ffa")
    private Integer ffa;
    @Column("blocked")
    private Integer blocked;
    @Column("counted")
    private Integer counted;
    @Column("under_threshold")
    private Integer underThreshold;
    @Column("needs_quest")
    private Integer needsQuest;
    @Column("rnd_bonus")
    private Integer rndBonus;
    @Column("context")
    private Integer context;
    @Column("bonus_list_ids")
    private String bonusListIds;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemLootItems> {

        public ItemLootItems convert(Row row) {
            ItemLootItems domain = new ItemLootItems();
            domain.setContainerId(row.get("container_id", Long.class));
            domain.setItemId(row.get("item_id", Integer.class));
            domain.setItemCount(row.get("item_count", Integer.class));
            domain.setFollowRules(row.get("follow_rules", Integer.class));
            domain.setFfa(row.get("ffa", Integer.class));
            domain.setBlocked(row.get("blocked", Integer.class));
            domain.setCounted(row.get("counted", Integer.class));
            domain.setUnderThreshold(row.get("under_threshold", Integer.class));
            domain.setNeedsQuest(row.get("needs_quest", Integer.class));
            domain.setRndBonus(row.get("rnd_bonus", Integer.class));
            domain.setContext(row.get("context", Integer.class));
            domain.setBonusListIds(row.get("bonus_list_ids", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemLootItems, OutboundRow> {

        public OutboundRow convert(ItemLootItems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getContainerId()).ifPresent(e -> row.put("container_id", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("item_id", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount()).ifPresent(e -> row.put("item_count", Parameter.from(e)));
            Optional.ofNullable(source.getFollowRules()).ifPresent(e -> row.put("follow_rules", Parameter.from(e)));
            Optional.ofNullable(source.getFfa()).ifPresent(e -> row.put("ffa", Parameter.from(e)));
            Optional.ofNullable(source.getBlocked()).ifPresent(e -> row.put("blocked", Parameter.from(e)));
            Optional.ofNullable(source.getCounted()).ifPresent(e -> row.put("counted", Parameter.from(e)));
            Optional.ofNullable(source.getUnderThreshold()).ifPresent(e -> row.put("under_threshold", Parameter.from(e)));
            Optional.ofNullable(source.getNeedsQuest()).ifPresent(e -> row.put("needs_quest", Parameter.from(e)));
            Optional.ofNullable(source.getRndBonus()).ifPresent(e -> row.put("rnd_bonus", Parameter.from(e)));
            Optional.ofNullable(source.getContext()).ifPresent(e -> row.put("context", Parameter.from(e)));
            Optional.ofNullable(source.getBonusListIds()).ifPresent(e -> row.put("bonus_list_ids", Parameter.from(e)));
            return row;
        }
    }

}
