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
@Table("item_instance_artifact_powers")
public class ItemInstanceArtifactPowers {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("artifactPowerId")
    private Integer artifactPowerId;
    @Column("purchasedRank")
    private Integer purchasedRank;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceArtifactPowers> {

        public ItemInstanceArtifactPowers convert(Row row) {
            ItemInstanceArtifactPowers domain = new ItemInstanceArtifactPowers();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setArtifactPowerId(row.get("artifactPowerId", Integer.class));
            domain.setPurchasedRank(row.get("purchasedRank", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceArtifactPowers, OutboundRow> {

        public OutboundRow convert(ItemInstanceArtifactPowers source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactPowerId()).ifPresent(e -> row.put("artifactPowerId", Parameter.from(e)));
            Optional.ofNullable(source.getPurchasedRank()).ifPresent(e -> row.put("purchasedRank", Parameter.from(e)));
            return row;
        }
    }

}
