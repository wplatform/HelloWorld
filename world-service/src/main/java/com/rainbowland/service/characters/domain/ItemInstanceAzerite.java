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
@Table("item_instance_azerite")
public class ItemInstanceAzerite {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("xp")
    private Long xp;
    @Column("level")
    private Integer level;
    @Column("knowledgeLevel")
    private Integer knowledgeLevel;
    @Column("selectedAzeriteEssences1specId")
    private Integer selectedAzeriteEssences1SpecId;
    @Column("selectedAzeriteEssences1azeriteEssenceId1")
    private Integer selectedAzeriteEssences1AzeriteEssenceId1;
    @Column("selectedAzeriteEssences1azeriteEssenceId2")
    private Integer selectedAzeriteEssences1AzeriteEssenceId2;
    @Column("selectedAzeriteEssences1azeriteEssenceId3")
    private Integer selectedAzeriteEssences1AzeriteEssenceId3;
    @Column("selectedAzeriteEssences1azeriteEssenceId4")
    private Integer selectedAzeriteEssences1AzeriteEssenceId4;
    @Column("selectedAzeriteEssences2specId")
    private Integer selectedAzeriteEssences2SpecId;
    @Column("selectedAzeriteEssences2azeriteEssenceId1")
    private Integer selectedAzeriteEssences2AzeriteEssenceId1;
    @Column("selectedAzeriteEssences2azeriteEssenceId2")
    private Integer selectedAzeriteEssences2AzeriteEssenceId2;
    @Column("selectedAzeriteEssences2azeriteEssenceId3")
    private Integer selectedAzeriteEssences2AzeriteEssenceId3;
    @Column("selectedAzeriteEssences2azeriteEssenceId4")
    private Integer selectedAzeriteEssences2AzeriteEssenceId4;
    @Column("selectedAzeriteEssences3specId")
    private Integer selectedAzeriteEssences3SpecId;
    @Column("selectedAzeriteEssences3azeriteEssenceId1")
    private Integer selectedAzeriteEssences3AzeriteEssenceId1;
    @Column("selectedAzeriteEssences3azeriteEssenceId2")
    private Integer selectedAzeriteEssences3AzeriteEssenceId2;
    @Column("selectedAzeriteEssences3azeriteEssenceId3")
    private Integer selectedAzeriteEssences3AzeriteEssenceId3;
    @Column("selectedAzeriteEssences3azeriteEssenceId4")
    private Integer selectedAzeriteEssences3AzeriteEssenceId4;
    @Column("selectedAzeriteEssences4specId")
    private Integer selectedAzeriteEssences4SpecId;
    @Column("selectedAzeriteEssences4azeriteEssenceId1")
    private Integer selectedAzeriteEssences4AzeriteEssenceId1;
    @Column("selectedAzeriteEssences4azeriteEssenceId2")
    private Integer selectedAzeriteEssences4AzeriteEssenceId2;
    @Column("selectedAzeriteEssences4azeriteEssenceId3")
    private Integer selectedAzeriteEssences4AzeriteEssenceId3;
    @Column("selectedAzeriteEssences4azeriteEssenceId4")
    private Integer selectedAzeriteEssences4AzeriteEssenceId4;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceAzerite> {

        public ItemInstanceAzerite convert(Row row) {
            ItemInstanceAzerite domain = new ItemInstanceAzerite();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setXp(row.get("xp", Long.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setKnowledgeLevel(row.get("knowledgeLevel", Integer.class));
            domain.setSelectedAzeriteEssences1SpecId(row.get("selectedAzeriteEssences1specId", Integer.class));
            domain.setSelectedAzeriteEssences1AzeriteEssenceId1(row.get("selectedAzeriteEssences1azeriteEssenceId1", Integer.class));
            domain.setSelectedAzeriteEssences1AzeriteEssenceId2(row.get("selectedAzeriteEssences1azeriteEssenceId2", Integer.class));
            domain.setSelectedAzeriteEssences1AzeriteEssenceId3(row.get("selectedAzeriteEssences1azeriteEssenceId3", Integer.class));
            domain.setSelectedAzeriteEssences1AzeriteEssenceId4(row.get("selectedAzeriteEssences1azeriteEssenceId4", Integer.class));
            domain.setSelectedAzeriteEssences2SpecId(row.get("selectedAzeriteEssences2specId", Integer.class));
            domain.setSelectedAzeriteEssences2AzeriteEssenceId1(row.get("selectedAzeriteEssences2azeriteEssenceId1", Integer.class));
            domain.setSelectedAzeriteEssences2AzeriteEssenceId2(row.get("selectedAzeriteEssences2azeriteEssenceId2", Integer.class));
            domain.setSelectedAzeriteEssences2AzeriteEssenceId3(row.get("selectedAzeriteEssences2azeriteEssenceId3", Integer.class));
            domain.setSelectedAzeriteEssences2AzeriteEssenceId4(row.get("selectedAzeriteEssences2azeriteEssenceId4", Integer.class));
            domain.setSelectedAzeriteEssences3SpecId(row.get("selectedAzeriteEssences3specId", Integer.class));
            domain.setSelectedAzeriteEssences3AzeriteEssenceId1(row.get("selectedAzeriteEssences3azeriteEssenceId1", Integer.class));
            domain.setSelectedAzeriteEssences3AzeriteEssenceId2(row.get("selectedAzeriteEssences3azeriteEssenceId2", Integer.class));
            domain.setSelectedAzeriteEssences3AzeriteEssenceId3(row.get("selectedAzeriteEssences3azeriteEssenceId3", Integer.class));
            domain.setSelectedAzeriteEssences3AzeriteEssenceId4(row.get("selectedAzeriteEssences3azeriteEssenceId4", Integer.class));
            domain.setSelectedAzeriteEssences4SpecId(row.get("selectedAzeriteEssences4specId", Integer.class));
            domain.setSelectedAzeriteEssences4AzeriteEssenceId1(row.get("selectedAzeriteEssences4azeriteEssenceId1", Integer.class));
            domain.setSelectedAzeriteEssences4AzeriteEssenceId2(row.get("selectedAzeriteEssences4azeriteEssenceId2", Integer.class));
            domain.setSelectedAzeriteEssences4AzeriteEssenceId3(row.get("selectedAzeriteEssences4azeriteEssenceId3", Integer.class));
            domain.setSelectedAzeriteEssences4AzeriteEssenceId4(row.get("selectedAzeriteEssences4azeriteEssenceId4", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceAzerite, OutboundRow> {

        public OutboundRow convert(ItemInstanceAzerite source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getXp()).ifPresent(e -> row.put("xp", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getKnowledgeLevel()).ifPresent(e -> row.put("knowledgeLevel", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences1SpecId()).ifPresent(e -> row.put("selectedAzeriteEssences1specId", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences1AzeriteEssenceId1()).ifPresent(e -> row.put("selectedAzeriteEssences1azeriteEssenceId1", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences1AzeriteEssenceId2()).ifPresent(e -> row.put("selectedAzeriteEssences1azeriteEssenceId2", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences1AzeriteEssenceId3()).ifPresent(e -> row.put("selectedAzeriteEssences1azeriteEssenceId3", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences1AzeriteEssenceId4()).ifPresent(e -> row.put("selectedAzeriteEssences1azeriteEssenceId4", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences2SpecId()).ifPresent(e -> row.put("selectedAzeriteEssences2specId", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences2AzeriteEssenceId1()).ifPresent(e -> row.put("selectedAzeriteEssences2azeriteEssenceId1", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences2AzeriteEssenceId2()).ifPresent(e -> row.put("selectedAzeriteEssences2azeriteEssenceId2", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences2AzeriteEssenceId3()).ifPresent(e -> row.put("selectedAzeriteEssences2azeriteEssenceId3", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences2AzeriteEssenceId4()).ifPresent(e -> row.put("selectedAzeriteEssences2azeriteEssenceId4", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences3SpecId()).ifPresent(e -> row.put("selectedAzeriteEssences3specId", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences3AzeriteEssenceId1()).ifPresent(e -> row.put("selectedAzeriteEssences3azeriteEssenceId1", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences3AzeriteEssenceId2()).ifPresent(e -> row.put("selectedAzeriteEssences3azeriteEssenceId2", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences3AzeriteEssenceId3()).ifPresent(e -> row.put("selectedAzeriteEssences3azeriteEssenceId3", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences3AzeriteEssenceId4()).ifPresent(e -> row.put("selectedAzeriteEssences3azeriteEssenceId4", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences4SpecId()).ifPresent(e -> row.put("selectedAzeriteEssences4specId", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences4AzeriteEssenceId1()).ifPresent(e -> row.put("selectedAzeriteEssences4azeriteEssenceId1", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences4AzeriteEssenceId2()).ifPresent(e -> row.put("selectedAzeriteEssences4azeriteEssenceId2", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences4AzeriteEssenceId3()).ifPresent(e -> row.put("selectedAzeriteEssences4azeriteEssenceId3", Parameter.from(e)));
            Optional.ofNullable(source.getSelectedAzeriteEssences4AzeriteEssenceId4()).ifPresent(e -> row.put("selectedAzeriteEssences4azeriteEssenceId4", Parameter.from(e)));
            return row;
        }
    }

}
