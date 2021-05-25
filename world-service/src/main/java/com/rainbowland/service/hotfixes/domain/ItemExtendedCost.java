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
@Table("item_extended_cost")
public class ItemExtendedCost {

    @Column("ID")
    private Integer id;
    @Column("RequiredArenaRating")
    private Integer requiredArenaRating;
    @Column("ArenaBracket")
    private Integer arenaBracket;
    @Column("Flags")
    private Integer flags;
    @Column("MinFactionID")
    private Integer minFactionId;
    @Column("MinReputation")
    private Integer minReputation;
    @Column("RequiredAchievement")
    private Integer requiredAchievement;
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
    @Column("ItemCount1")
    private Integer itemCount1;
    @Column("ItemCount2")
    private Integer itemCount2;
    @Column("ItemCount3")
    private Integer itemCount3;
    @Column("ItemCount4")
    private Integer itemCount4;
    @Column("ItemCount5")
    private Integer itemCount5;
    @Column("CurrencyID1")
    private Integer currencyId1;
    @Column("CurrencyID2")
    private Integer currencyId2;
    @Column("CurrencyID3")
    private Integer currencyId3;
    @Column("CurrencyID4")
    private Integer currencyId4;
    @Column("CurrencyID5")
    private Integer currencyId5;
    @Column("CurrencyCount1")
    private Integer currencyCount1;
    @Column("CurrencyCount2")
    private Integer currencyCount2;
    @Column("CurrencyCount3")
    private Integer currencyCount3;
    @Column("CurrencyCount4")
    private Integer currencyCount4;
    @Column("CurrencyCount5")
    private Integer currencyCount5;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemExtendedCost> {

        public ItemExtendedCost convert(Row row) {
            ItemExtendedCost domain = new ItemExtendedCost();
            domain.setId(row.get("ID", Integer.class));
            domain.setRequiredArenaRating(row.get("RequiredArenaRating", Integer.class));
            domain.setArenaBracket(row.get("ArenaBracket", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setMinFactionId(row.get("MinFactionID", Integer.class));
            domain.setMinReputation(row.get("MinReputation", Integer.class));
            domain.setRequiredAchievement(row.get("RequiredAchievement", Integer.class));
            domain.setItemId1(row.get("ItemID1", Integer.class));
            domain.setItemId2(row.get("ItemID2", Integer.class));
            domain.setItemId3(row.get("ItemID3", Integer.class));
            domain.setItemId4(row.get("ItemID4", Integer.class));
            domain.setItemId5(row.get("ItemID5", Integer.class));
            domain.setItemCount1(row.get("ItemCount1", Integer.class));
            domain.setItemCount2(row.get("ItemCount2", Integer.class));
            domain.setItemCount3(row.get("ItemCount3", Integer.class));
            domain.setItemCount4(row.get("ItemCount4", Integer.class));
            domain.setItemCount5(row.get("ItemCount5", Integer.class));
            domain.setCurrencyId1(row.get("CurrencyID1", Integer.class));
            domain.setCurrencyId2(row.get("CurrencyID2", Integer.class));
            domain.setCurrencyId3(row.get("CurrencyID3", Integer.class));
            domain.setCurrencyId4(row.get("CurrencyID4", Integer.class));
            domain.setCurrencyId5(row.get("CurrencyID5", Integer.class));
            domain.setCurrencyCount1(row.get("CurrencyCount1", Integer.class));
            domain.setCurrencyCount2(row.get("CurrencyCount2", Integer.class));
            domain.setCurrencyCount3(row.get("CurrencyCount3", Integer.class));
            domain.setCurrencyCount4(row.get("CurrencyCount4", Integer.class));
            domain.setCurrencyCount5(row.get("CurrencyCount5", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemExtendedCost, OutboundRow> {

        public OutboundRow convert(ItemExtendedCost source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredArenaRating()).ifPresent(e -> row.put("RequiredArenaRating", Parameter.from(e)));
            Optional.ofNullable(source.getArenaBracket()).ifPresent(e -> row.put("ArenaBracket", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getMinFactionId()).ifPresent(e -> row.put("MinFactionID", Parameter.from(e)));
            Optional.ofNullable(source.getMinReputation()).ifPresent(e -> row.put("MinReputation", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredAchievement()).ifPresent(e -> row.put("RequiredAchievement", Parameter.from(e)));
            Optional.ofNullable(source.getItemId1()).ifPresent(e -> row.put("ItemID1", Parameter.from(e)));
            Optional.ofNullable(source.getItemId2()).ifPresent(e -> row.put("ItemID2", Parameter.from(e)));
            Optional.ofNullable(source.getItemId3()).ifPresent(e -> row.put("ItemID3", Parameter.from(e)));
            Optional.ofNullable(source.getItemId4()).ifPresent(e -> row.put("ItemID4", Parameter.from(e)));
            Optional.ofNullable(source.getItemId5()).ifPresent(e -> row.put("ItemID5", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount1()).ifPresent(e -> row.put("ItemCount1", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount2()).ifPresent(e -> row.put("ItemCount2", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount3()).ifPresent(e -> row.put("ItemCount3", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount4()).ifPresent(e -> row.put("ItemCount4", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount5()).ifPresent(e -> row.put("ItemCount5", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId1()).ifPresent(e -> row.put("CurrencyID1", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId2()).ifPresent(e -> row.put("CurrencyID2", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId3()).ifPresent(e -> row.put("CurrencyID3", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId4()).ifPresent(e -> row.put("CurrencyID4", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId5()).ifPresent(e -> row.put("CurrencyID5", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount1()).ifPresent(e -> row.put("CurrencyCount1", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount2()).ifPresent(e -> row.put("CurrencyCount2", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount3()).ifPresent(e -> row.put("CurrencyCount3", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount4()).ifPresent(e -> row.put("CurrencyCount4", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount5()).ifPresent(e -> row.put("CurrencyCount5", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
