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
@Table("gossip_menu_option_box")
public class GossipMenuOptionBox {

    @Column("MenuId")
    private Integer menuId;
    @Column("OptionIndex")
    private Integer optionIndex;
    @Column("BoxCoded")
    private Integer boxCoded;
    @Column("BoxMoney")
    private Integer boxMoney;
    @Column("BoxText")
    private String boxText;
    @Column("BoxBroadcastTextId")
    private Integer boxBroadcastTextId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GossipMenuOptionBox> {

        public GossipMenuOptionBox convert(Row row) {
            GossipMenuOptionBox domain = new GossipMenuOptionBox();
            domain.setMenuId(row.get("MenuId", Integer.class));
            domain.setOptionIndex(row.get("OptionIndex", Integer.class));
            domain.setBoxCoded(row.get("BoxCoded", Integer.class));
            domain.setBoxMoney(row.get("BoxMoney", Integer.class));
            domain.setBoxText(row.get("BoxText", String.class));
            domain.setBoxBroadcastTextId(row.get("BoxBroadcastTextId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GossipMenuOptionBox, OutboundRow> {

        public OutboundRow convert(GossipMenuOptionBox source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMenuId()).ifPresent(e -> row.put("MenuId", Parameter.from(e)));
            Optional.ofNullable(source.getOptionIndex()).ifPresent(e -> row.put("OptionIndex", Parameter.from(e)));
            Optional.ofNullable(source.getBoxCoded()).ifPresent(e -> row.put("BoxCoded", Parameter.from(e)));
            Optional.ofNullable(source.getBoxMoney()).ifPresent(e -> row.put("BoxMoney", Parameter.from(e)));
            Optional.ofNullable(source.getBoxText()).ifPresent(e -> row.put("BoxText", Parameter.from(e)));
            Optional.ofNullable(source.getBoxBroadcastTextId()).ifPresent(e -> row.put("BoxBroadcastTextId", Parameter.from(e)));
            return row;
        }
    }

}
