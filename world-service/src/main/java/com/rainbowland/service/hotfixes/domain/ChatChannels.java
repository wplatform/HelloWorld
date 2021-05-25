package com.rainbowland.service.hotfixes.domain;

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
@Table("chat_channels")
public class ChatChannels {

    @Column("Name")
    private String name;
    @Column("Shortcut")
    private String shortcut;
    @Column("ID")
    private Integer id;
    @Column("Flags")
    private Integer flags;
    @Column("FactionGroup")
    private Integer factionGroup;
    @Column("Ruleset")
    private Integer ruleset;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChatChannels> {

        public ChatChannels convert(Row row) {
            ChatChannels domain = new ChatChannels();
            domain.setName(row.get("Name", String.class));
            domain.setShortcut(row.get("Shortcut", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setFactionGroup(row.get("FactionGroup", Integer.class));
            domain.setRuleset(row.get("Ruleset", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChatChannels, OutboundRow> {

        public OutboundRow convert(ChatChannels source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getShortcut()).ifPresent(e -> row.put("Shortcut", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getFactionGroup()).ifPresent(e -> row.put("FactionGroup", Parameter.from(e)));
            Optional.ofNullable(source.getRuleset()).ifPresent(e -> row.put("Ruleset", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
