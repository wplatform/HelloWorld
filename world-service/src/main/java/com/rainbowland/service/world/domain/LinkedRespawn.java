package com.rainbowland.service.world.domain;

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
@Table("linked_respawn")
public class LinkedRespawn {

    @Column("guid")
    private Long guid;
    @Column("linkedGuid")
    private Long linkedGuid;
    @Column("linkType")
    private Integer linkType;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, LinkedRespawn> {

        public LinkedRespawn convert(Row row) {
            LinkedRespawn domain = new LinkedRespawn();
            domain.setGuid(row.get("guid", Long.class));
            domain.setLinkedGuid(row.get("linkedGuid", Long.class));
            domain.setLinkType(row.get("linkType", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<LinkedRespawn, OutboundRow> {

        public OutboundRow convert(LinkedRespawn source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getLinkedGuid()).ifPresent(e -> row.put("linkedGuid", Parameter.from(e)));
            Optional.ofNullable(source.getLinkType()).ifPresent(e -> row.put("linkType", Parameter.from(e)));
            return row;
        }
    }

}
