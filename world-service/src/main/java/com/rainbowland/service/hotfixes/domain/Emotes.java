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
@Table("emotes")
public class Emotes {

    @Column("ID")
    private Integer id;
    @Column("RaceMask")
    private Long raceMask;
    @Column("EmoteSlashCommand")
    private String emoteSlashCommand;
    @Column("AnimID")
    private Integer animId;
    @Column("EmoteFlags")
    private Integer emoteFlags;
    @Column("EmoteSpecProc")
    private Integer emoteSpecProc;
    @Column("EmoteSpecProcParam")
    private Integer emoteSpecProcParam;
    @Column("EventSoundID")
    private Integer eventSoundId;
    @Column("SpellVisualKitID")
    private Integer spellVisualKitId;
    @Column("ClassMask")
    private Integer classMask;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Emotes> {

        public Emotes convert(Row row) {
            Emotes domain = new Emotes();
            domain.setId(row.get("ID", Integer.class));
            domain.setRaceMask(row.get("RaceMask", Long.class));
            domain.setEmoteSlashCommand(row.get("EmoteSlashCommand", String.class));
            domain.setAnimId(row.get("AnimID", Integer.class));
            domain.setEmoteFlags(row.get("EmoteFlags", Integer.class));
            domain.setEmoteSpecProc(row.get("EmoteSpecProc", Integer.class));
            domain.setEmoteSpecProcParam(row.get("EmoteSpecProcParam", Integer.class));
            domain.setEventSoundId(row.get("EventSoundID", Integer.class));
            domain.setSpellVisualKitId(row.get("SpellVisualKitID", Integer.class));
            domain.setClassMask(row.get("ClassMask", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Emotes, OutboundRow> {

        public OutboundRow convert(Emotes source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("RaceMask", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteSlashCommand()).ifPresent(e -> row.put("EmoteSlashCommand", Parameter.from(e)));
            Optional.ofNullable(source.getAnimId()).ifPresent(e -> row.put("AnimID", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteFlags()).ifPresent(e -> row.put("EmoteFlags", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteSpecProc()).ifPresent(e -> row.put("EmoteSpecProc", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteSpecProcParam()).ifPresent(e -> row.put("EmoteSpecProcParam", Parameter.from(e)));
            Optional.ofNullable(source.getEventSoundId()).ifPresent(e -> row.put("EventSoundID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellVisualKitId()).ifPresent(e -> row.put("SpellVisualKitID", Parameter.from(e)));
            Optional.ofNullable(source.getClassMask()).ifPresent(e -> row.put("ClassMask", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
