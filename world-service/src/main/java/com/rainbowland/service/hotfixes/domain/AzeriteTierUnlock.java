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
@Table("azerite_tier_unlock")
public class AzeriteTierUnlock {

    @Column("ID")
    private Integer id;
    @Column("ItemCreationContext")
    private Integer itemCreationContext;
    @Column("Tier")
    private Integer tier;
    @Column("AzeriteLevel")
    private Integer azeriteLevel;
    @Column("AzeriteTierUnlockSetID")
    private Integer azeriteTierUnlockSetId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteTierUnlock> {

        public AzeriteTierUnlock convert(Row row) {
            AzeriteTierUnlock domain = new AzeriteTierUnlock();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemCreationContext(row.get("ItemCreationContext", Integer.class));
            domain.setTier(row.get("Tier", Integer.class));
            domain.setAzeriteLevel(row.get("AzeriteLevel", Integer.class));
            domain.setAzeriteTierUnlockSetId(row.get("AzeriteTierUnlockSetID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteTierUnlock, OutboundRow> {

        public OutboundRow convert(AzeriteTierUnlock source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemCreationContext()).ifPresent(e -> row.put("ItemCreationContext", Parameter.from(e)));
            Optional.ofNullable(source.getTier()).ifPresent(e -> row.put("Tier", Parameter.from(e)));
            Optional.ofNullable(source.getAzeriteLevel()).ifPresent(e -> row.put("AzeriteLevel", Parameter.from(e)));
            Optional.ofNullable(source.getAzeriteTierUnlockSetId()).ifPresent(e -> row.put("AzeriteTierUnlockSetID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
