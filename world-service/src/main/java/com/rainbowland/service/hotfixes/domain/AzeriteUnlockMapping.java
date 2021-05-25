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
@Table("azerite_unlock_mapping")
public class AzeriteUnlockMapping {

    @Column("ID")
    private Integer id;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("ItemBonusListHead")
    private Integer itemBonusListHead;
    @Column("ItemBonusListShoulders")
    private Integer itemBonusListShoulders;
    @Column("ItemBonusListChest")
    private Integer itemBonusListChest;
    @Column("AzeriteUnlockMappingSetID")
    private Integer azeriteUnlockMappingSetId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteUnlockMapping> {

        public AzeriteUnlockMapping convert(Row row) {
            AzeriteUnlockMapping domain = new AzeriteUnlockMapping();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setItemBonusListHead(row.get("ItemBonusListHead", Integer.class));
            domain.setItemBonusListShoulders(row.get("ItemBonusListShoulders", Integer.class));
            domain.setItemBonusListChest(row.get("ItemBonusListChest", Integer.class));
            domain.setAzeriteUnlockMappingSetId(row.get("AzeriteUnlockMappingSetID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteUnlockMapping, OutboundRow> {

        public OutboundRow convert(AzeriteUnlockMapping source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusListHead()).ifPresent(e -> row.put("ItemBonusListHead", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusListShoulders()).ifPresent(e -> row.put("ItemBonusListShoulders", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusListChest()).ifPresent(e -> row.put("ItemBonusListChest", Parameter.from(e)));
            Optional.ofNullable(source.getAzeriteUnlockMappingSetId()).ifPresent(e -> row.put("AzeriteUnlockMappingSetID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
