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
@Table("heirloom")
public class Heirloom {

    @Column("SourceText")
    private String sourceText;
    @Column("ID")
    private Integer id;
    @Column("ItemID")
    private Integer itemId;
    @Column("LegacyUpgradedItemID")
    private Integer legacyUpgradedItemId;
    @Column("StaticUpgradedItemID")
    private Integer staticUpgradedItemId;
    @Column("SourceTypeEnum")
    private Integer sourceTypeEnum;
    @Column("Flags")
    private Integer flags;
    @Column("LegacyItemID")
    private Integer legacyItemId;
    @Column("UpgradeItemID1")
    private Integer upgradeItemId1;
    @Column("UpgradeItemID2")
    private Integer upgradeItemId2;
    @Column("UpgradeItemID3")
    private Integer upgradeItemId3;
    @Column("UpgradeItemID4")
    private Integer upgradeItemId4;
    @Column("UpgradeItemBonusListID1")
    private Integer upgradeItemBonusListId1;
    @Column("UpgradeItemBonusListID2")
    private Integer upgradeItemBonusListId2;
    @Column("UpgradeItemBonusListID3")
    private Integer upgradeItemBonusListId3;
    @Column("UpgradeItemBonusListID4")
    private Integer upgradeItemBonusListId4;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Heirloom> {

        public Heirloom convert(Row row) {
            Heirloom domain = new Heirloom();
            domain.setSourceText(row.get("SourceText", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setLegacyUpgradedItemId(row.get("LegacyUpgradedItemID", Integer.class));
            domain.setStaticUpgradedItemId(row.get("StaticUpgradedItemID", Integer.class));
            domain.setSourceTypeEnum(row.get("SourceTypeEnum", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setLegacyItemId(row.get("LegacyItemID", Integer.class));
            domain.setUpgradeItemId1(row.get("UpgradeItemID1", Integer.class));
            domain.setUpgradeItemId2(row.get("UpgradeItemID2", Integer.class));
            domain.setUpgradeItemId3(row.get("UpgradeItemID3", Integer.class));
            domain.setUpgradeItemId4(row.get("UpgradeItemID4", Integer.class));
            domain.setUpgradeItemBonusListId1(row.get("UpgradeItemBonusListID1", Integer.class));
            domain.setUpgradeItemBonusListId2(row.get("UpgradeItemBonusListID2", Integer.class));
            domain.setUpgradeItemBonusListId3(row.get("UpgradeItemBonusListID3", Integer.class));
            domain.setUpgradeItemBonusListId4(row.get("UpgradeItemBonusListID4", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Heirloom, OutboundRow> {

        public OutboundRow convert(Heirloom source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSourceText()).ifPresent(e -> row.put("SourceText", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getLegacyUpgradedItemId()).ifPresent(e -> row.put("LegacyUpgradedItemID", Parameter.from(e)));
            Optional.ofNullable(source.getStaticUpgradedItemId()).ifPresent(e -> row.put("StaticUpgradedItemID", Parameter.from(e)));
            Optional.ofNullable(source.getSourceTypeEnum()).ifPresent(e -> row.put("SourceTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getLegacyItemId()).ifPresent(e -> row.put("LegacyItemID", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemId1()).ifPresent(e -> row.put("UpgradeItemID1", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemId2()).ifPresent(e -> row.put("UpgradeItemID2", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemId3()).ifPresent(e -> row.put("UpgradeItemID3", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemId4()).ifPresent(e -> row.put("UpgradeItemID4", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemBonusListId1()).ifPresent(e -> row.put("UpgradeItemBonusListID1", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemBonusListId2()).ifPresent(e -> row.put("UpgradeItemBonusListID2", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemBonusListId3()).ifPresent(e -> row.put("UpgradeItemBonusListID3", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeItemBonusListId4()).ifPresent(e -> row.put("UpgradeItemBonusListID4", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
