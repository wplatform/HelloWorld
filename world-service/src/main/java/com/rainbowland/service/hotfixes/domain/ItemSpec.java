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
@Table("item_spec")
public class ItemSpec {

    @Column("ID")
    private Integer id;
    @Column("MinLevel")
    private Integer minLevel;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("ItemType")
    private Integer itemType;
    @Column("PrimaryStat")
    private Integer primaryStat;
    @Column("SecondaryStat")
    private Integer secondaryStat;
    @Column("SpecializationID")
    private Integer specializationId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemSpec> {

        public ItemSpec convert(Row row) {
            ItemSpec domain = new ItemSpec();
            domain.setId(row.get("ID", Integer.class));
            domain.setMinLevel(row.get("MinLevel", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setItemType(row.get("ItemType", Integer.class));
            domain.setPrimaryStat(row.get("PrimaryStat", Integer.class));
            domain.setSecondaryStat(row.get("SecondaryStat", Integer.class));
            domain.setSpecializationId(row.get("SpecializationID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemSpec, OutboundRow> {

        public OutboundRow convert(ItemSpec source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevel()).ifPresent(e -> row.put("MinLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getItemType()).ifPresent(e -> row.put("ItemType", Parameter.from(e)));
            Optional.ofNullable(source.getPrimaryStat()).ifPresent(e -> row.put("PrimaryStat", Parameter.from(e)));
            Optional.ofNullable(source.getSecondaryStat()).ifPresent(e -> row.put("SecondaryStat", Parameter.from(e)));
            Optional.ofNullable(source.getSpecializationId()).ifPresent(e -> row.put("SpecializationID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
