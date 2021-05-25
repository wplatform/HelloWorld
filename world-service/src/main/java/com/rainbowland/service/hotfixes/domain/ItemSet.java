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
@Table("item_set")
public class ItemSet {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("SetFlags")
    private Integer setFlags;
    @Column("RequiredSkill")
    private Integer requiredSkill;
    @Column("RequiredSkillRank")
    private Integer requiredSkillRank;
    @Column("ItemID1")
    private Integer itemId1;
    @Column("ItemID2")
    private Integer itemId2;
    @Column("ItemID3")
    private Integer itemId3;
    @Column("ItemID4")
    private Integer itemId4;
    @Column("ItemID5")
    private Integer itemId5;
    @Column("ItemID6")
    private Integer itemId6;
    @Column("ItemID7")
    private Integer itemId7;
    @Column("ItemID8")
    private Integer itemId8;
    @Column("ItemID9")
    private Integer itemId9;
    @Column("ItemID10")
    private Integer itemId10;
    @Column("ItemID11")
    private Integer itemId11;
    @Column("ItemID12")
    private Integer itemId12;
    @Column("ItemID13")
    private Integer itemId13;
    @Column("ItemID14")
    private Integer itemId14;
    @Column("ItemID15")
    private Integer itemId15;
    @Column("ItemID16")
    private Integer itemId16;
    @Column("ItemID17")
    private Integer itemId17;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemSet> {

        public ItemSet convert(Row row) {
            ItemSet domain = new ItemSet();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setSetFlags(row.get("SetFlags", Integer.class));
            domain.setRequiredSkill(row.get("RequiredSkill", Integer.class));
            domain.setRequiredSkillRank(row.get("RequiredSkillRank", Integer.class));
            domain.setItemId1(row.get("ItemID1", Integer.class));
            domain.setItemId2(row.get("ItemID2", Integer.class));
            domain.setItemId3(row.get("ItemID3", Integer.class));
            domain.setItemId4(row.get("ItemID4", Integer.class));
            domain.setItemId5(row.get("ItemID5", Integer.class));
            domain.setItemId6(row.get("ItemID6", Integer.class));
            domain.setItemId7(row.get("ItemID7", Integer.class));
            domain.setItemId8(row.get("ItemID8", Integer.class));
            domain.setItemId9(row.get("ItemID9", Integer.class));
            domain.setItemId10(row.get("ItemID10", Integer.class));
            domain.setItemId11(row.get("ItemID11", Integer.class));
            domain.setItemId12(row.get("ItemID12", Integer.class));
            domain.setItemId13(row.get("ItemID13", Integer.class));
            domain.setItemId14(row.get("ItemID14", Integer.class));
            domain.setItemId15(row.get("ItemID15", Integer.class));
            domain.setItemId16(row.get("ItemID16", Integer.class));
            domain.setItemId17(row.get("ItemID17", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemSet, OutboundRow> {

        public OutboundRow convert(ItemSet source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getSetFlags()).ifPresent(e -> row.put("SetFlags", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkill()).ifPresent(e -> row.put("RequiredSkill", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkillRank()).ifPresent(e -> row.put("RequiredSkillRank", Parameter.from(e)));
            Optional.ofNullable(source.getItemId1()).ifPresent(e -> row.put("ItemID1", Parameter.from(e)));
            Optional.ofNullable(source.getItemId2()).ifPresent(e -> row.put("ItemID2", Parameter.from(e)));
            Optional.ofNullable(source.getItemId3()).ifPresent(e -> row.put("ItemID3", Parameter.from(e)));
            Optional.ofNullable(source.getItemId4()).ifPresent(e -> row.put("ItemID4", Parameter.from(e)));
            Optional.ofNullable(source.getItemId5()).ifPresent(e -> row.put("ItemID5", Parameter.from(e)));
            Optional.ofNullable(source.getItemId6()).ifPresent(e -> row.put("ItemID6", Parameter.from(e)));
            Optional.ofNullable(source.getItemId7()).ifPresent(e -> row.put("ItemID7", Parameter.from(e)));
            Optional.ofNullable(source.getItemId8()).ifPresent(e -> row.put("ItemID8", Parameter.from(e)));
            Optional.ofNullable(source.getItemId9()).ifPresent(e -> row.put("ItemID9", Parameter.from(e)));
            Optional.ofNullable(source.getItemId10()).ifPresent(e -> row.put("ItemID10", Parameter.from(e)));
            Optional.ofNullable(source.getItemId11()).ifPresent(e -> row.put("ItemID11", Parameter.from(e)));
            Optional.ofNullable(source.getItemId12()).ifPresent(e -> row.put("ItemID12", Parameter.from(e)));
            Optional.ofNullable(source.getItemId13()).ifPresent(e -> row.put("ItemID13", Parameter.from(e)));
            Optional.ofNullable(source.getItemId14()).ifPresent(e -> row.put("ItemID14", Parameter.from(e)));
            Optional.ofNullable(source.getItemId15()).ifPresent(e -> row.put("ItemID15", Parameter.from(e)));
            Optional.ofNullable(source.getItemId16()).ifPresent(e -> row.put("ItemID16", Parameter.from(e)));
            Optional.ofNullable(source.getItemId17()).ifPresent(e -> row.put("ItemID17", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
