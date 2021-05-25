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
@Table("item_instance_modifiers")
public class ItemInstanceModifiers {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("fixedScalingLevel")
    private Integer fixedScalingLevel;
    @Column("artifactKnowledgeLevel")
    private Integer artifactKnowledgeLevel;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceModifiers> {

        public ItemInstanceModifiers convert(Row row) {
            ItemInstanceModifiers domain = new ItemInstanceModifiers();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setFixedScalingLevel(row.get("fixedScalingLevel", Integer.class));
            domain.setArtifactKnowledgeLevel(row.get("artifactKnowledgeLevel", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceModifiers, OutboundRow> {

        public OutboundRow convert(ItemInstanceModifiers source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getFixedScalingLevel()).ifPresent(e -> row.put("fixedScalingLevel", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactKnowledgeLevel()).ifPresent(e -> row.put("artifactKnowledgeLevel", Parameter.from(e)));
            return row;
        }
    }

}
