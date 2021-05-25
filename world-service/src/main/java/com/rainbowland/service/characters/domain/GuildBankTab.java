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
@Table("guild_bank_tab")
public class GuildBankTab {

    @Column("guildid")
    private Long guildid;
    @Column("TabId")
    private Integer tabId;
    @Column("TabName")
    private String tabName;
    @Column("TabIcon")
    private String tabIcon;
    @Column("TabText")
    private String tabText;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildBankTab> {

        public GuildBankTab convert(Row row) {
            GuildBankTab domain = new GuildBankTab();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setTabId(row.get("TabId", Integer.class));
            domain.setTabName(row.get("TabName", String.class));
            domain.setTabIcon(row.get("TabIcon", String.class));
            domain.setTabText(row.get("TabText", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildBankTab, OutboundRow> {

        public OutboundRow convert(GuildBankTab source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getTabId()).ifPresent(e -> row.put("TabId", Parameter.from(e)));
            Optional.ofNullable(source.getTabName()).ifPresent(e -> row.put("TabName", Parameter.from(e)));
            Optional.ofNullable(source.getTabIcon()).ifPresent(e -> row.put("TabIcon", Parameter.from(e)));
            Optional.ofNullable(source.getTabText()).ifPresent(e -> row.put("TabText", Parameter.from(e)));
            return row;
        }
    }

}
