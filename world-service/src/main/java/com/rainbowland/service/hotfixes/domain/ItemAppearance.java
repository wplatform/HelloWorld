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
@Table("item_appearance")
public class ItemAppearance {

    @Column("ID")
    private Integer id;
    @Column("DisplayType")
    private Integer displayType;
    @Column("ItemDisplayInfoID")
    private Integer itemDisplayInfoId;
    @Column("DefaultIconFileDataID")
    private Integer defaultIconFileDataId;
    @Column("UiOrder")
    private Integer uiOrder;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemAppearance> {

        public ItemAppearance convert(Row row) {
            ItemAppearance domain = new ItemAppearance();
            domain.setId(row.get("ID", Integer.class));
            domain.setDisplayType(row.get("DisplayType", Integer.class));
            domain.setItemDisplayInfoId(row.get("ItemDisplayInfoID", Integer.class));
            domain.setDefaultIconFileDataId(row.get("DefaultIconFileDataID", Integer.class));
            domain.setUiOrder(row.get("UiOrder", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemAppearance, OutboundRow> {

        public OutboundRow convert(ItemAppearance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayType()).ifPresent(e -> row.put("DisplayType", Parameter.from(e)));
            Optional.ofNullable(source.getItemDisplayInfoId()).ifPresent(e -> row.put("ItemDisplayInfoID", Parameter.from(e)));
            Optional.ofNullable(source.getDefaultIconFileDataId()).ifPresent(e -> row.put("DefaultIconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getUiOrder()).ifPresent(e -> row.put("UiOrder", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
