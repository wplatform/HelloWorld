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
@Table("item_instance_artifact")
public class ItemInstanceArtifact {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("xp")
    private Long xp;
    @Column("artifactAppearanceId")
    private Integer artifactAppearanceId;
    @Column("artifactTierId")
    private Integer artifactTierId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceArtifact> {

        public ItemInstanceArtifact convert(Row row) {
            ItemInstanceArtifact domain = new ItemInstanceArtifact();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setXp(row.get("xp", Long.class));
            domain.setArtifactAppearanceId(row.get("artifactAppearanceId", Integer.class));
            domain.setArtifactTierId(row.get("artifactTierId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceArtifact, OutboundRow> {

        public OutboundRow convert(ItemInstanceArtifact source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getXp()).ifPresent(e -> row.put("xp", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactAppearanceId()).ifPresent(e -> row.put("artifactAppearanceId", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactTierId()).ifPresent(e -> row.put("artifactTierId", Parameter.from(e)));
            return row;
        }
    }

}
