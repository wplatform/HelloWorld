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
@Table("gossip_menu_option_locale")
public class GossipMenuOptionLocale {

    @Column("MenuId")
    private Integer menuId;
    @Column("OptionIndex")
    private Integer optionIndex;
    @Column("Locale")
    private String locale;
    @Column("OptionText")
    private String optionText;
    @Column("BoxText")
    private String boxText;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GossipMenuOptionLocale> {

        public GossipMenuOptionLocale convert(Row row) {
            GossipMenuOptionLocale domain = new GossipMenuOptionLocale();
            domain.setMenuId(row.get("MenuId", Integer.class));
            domain.setOptionIndex(row.get("OptionIndex", Integer.class));
            domain.setLocale(row.get("Locale", String.class));
            domain.setOptionText(row.get("OptionText", String.class));
            domain.setBoxText(row.get("BoxText", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GossipMenuOptionLocale, OutboundRow> {

        public OutboundRow convert(GossipMenuOptionLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMenuId()).ifPresent(e -> row.put("MenuId", Parameter.from(e)));
            Optional.ofNullable(source.getOptionIndex()).ifPresent(e -> row.put("OptionIndex", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("Locale", Parameter.from(e)));
            Optional.ofNullable(source.getOptionText()).ifPresent(e -> row.put("OptionText", Parameter.from(e)));
            Optional.ofNullable(source.getBoxText()).ifPresent(e -> row.put("BoxText", Parameter.from(e)));
            return row;
        }
    }

}
