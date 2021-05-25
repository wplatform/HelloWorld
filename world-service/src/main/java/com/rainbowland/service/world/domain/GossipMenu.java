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
@Table("gossip_menu")
public class GossipMenu {

    @Column("MenuId")
    private Integer menuId;
    @Column("TextId")
    private Integer textId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GossipMenu> {

        public GossipMenu convert(Row row) {
            GossipMenu domain = new GossipMenu();
            domain.setMenuId(row.get("MenuId", Integer.class));
            domain.setTextId(row.get("TextId", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GossipMenu, OutboundRow> {

        public OutboundRow convert(GossipMenu source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMenuId()).ifPresent(e -> row.put("MenuId", Parameter.from(e)));
            Optional.ofNullable(source.getTextId()).ifPresent(e -> row.put("TextId", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
