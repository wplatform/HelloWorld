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
@Table("gossip_menu_option")
public class GossipMenuOption {

    @Column("MenuId")
    private Integer menuId;
    @Column("OptionIndex")
    private Integer optionIndex;
    @Column("OptionIcon")
    private Integer optionIcon;
    @Column("OptionText")
    private String optionText;
    @Column("OptionBroadcastTextId")
    private Integer optionBroadcastTextId;
    @Column("OptionType")
    private Integer optionType;
    @Column("OptionNpcFlag")
    private Long optionNpcFlag;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GossipMenuOption> {

        public GossipMenuOption convert(Row row) {
            GossipMenuOption domain = new GossipMenuOption();
            domain.setMenuId(row.get("MenuId", Integer.class));
            domain.setOptionIndex(row.get("OptionIndex", Integer.class));
            domain.setOptionIcon(row.get("OptionIcon", Integer.class));
            domain.setOptionText(row.get("OptionText", String.class));
            domain.setOptionBroadcastTextId(row.get("OptionBroadcastTextId", Integer.class));
            domain.setOptionType(row.get("OptionType", Integer.class));
            domain.setOptionNpcFlag(row.get("OptionNpcFlag", Long.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GossipMenuOption, OutboundRow> {

        public OutboundRow convert(GossipMenuOption source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMenuId()).ifPresent(e -> row.put("MenuId", Parameter.from(e)));
            Optional.ofNullable(source.getOptionIndex()).ifPresent(e -> row.put("OptionIndex", Parameter.from(e)));
            Optional.ofNullable(source.getOptionIcon()).ifPresent(e -> row.put("OptionIcon", Parameter.from(e)));
            Optional.ofNullable(source.getOptionText()).ifPresent(e -> row.put("OptionText", Parameter.from(e)));
            Optional.ofNullable(source.getOptionBroadcastTextId()).ifPresent(e -> row.put("OptionBroadcastTextId", Parameter.from(e)));
            Optional.ofNullable(source.getOptionType()).ifPresent(e -> row.put("OptionType", Parameter.from(e)));
            Optional.ofNullable(source.getOptionNpcFlag()).ifPresent(e -> row.put("OptionNpcFlag", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
