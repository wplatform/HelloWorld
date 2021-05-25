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
@Table("gossip_menu_option_action")
public class GossipMenuOptionAction {

    @Column("MenuId")
    private Integer menuId;
    @Column("OptionIndex")
    private Integer optionIndex;
    @Column("ActionMenuId")
    private Integer actionMenuId;
    @Column("ActionPoiId")
    private Integer actionPoiId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GossipMenuOptionAction> {

        public GossipMenuOptionAction convert(Row row) {
            GossipMenuOptionAction domain = new GossipMenuOptionAction();
            domain.setMenuId(row.get("MenuId", Integer.class));
            domain.setOptionIndex(row.get("OptionIndex", Integer.class));
            domain.setActionMenuId(row.get("ActionMenuId", Integer.class));
            domain.setActionPoiId(row.get("ActionPoiId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GossipMenuOptionAction, OutboundRow> {

        public OutboundRow convert(GossipMenuOptionAction source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMenuId()).ifPresent(e -> row.put("MenuId", Parameter.from(e)));
            Optional.ofNullable(source.getOptionIndex()).ifPresent(e -> row.put("OptionIndex", Parameter.from(e)));
            Optional.ofNullable(source.getActionMenuId()).ifPresent(e -> row.put("ActionMenuId", Parameter.from(e)));
            Optional.ofNullable(source.getActionPoiId()).ifPresent(e -> row.put("ActionPoiId", Parameter.from(e)));
            return row;
        }
    }

}
