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
@Table("map_difficulty")
public class MapDifficulty {

    @Column("ID")
    private Integer id;
    @Column("Message")
    private String message;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("LockID")
    private Integer lockId;
    @Column("ResetInterval")
    private Integer resetInterval;
    @Column("MaxPlayers")
    private Integer maxPlayers;
    @Column("ItemContext")
    private Integer itemContext;
    @Column("ItemContextPickerID")
    private Integer itemContextPickerId;
    @Column("Flags")
    private Integer flags;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("MapID")
    private Integer mapId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MapDifficulty> {

        public MapDifficulty convert(Row row) {
            MapDifficulty domain = new MapDifficulty();
            domain.setId(row.get("ID", Integer.class));
            domain.setMessage(row.get("Message", String.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setLockId(row.get("LockID", Integer.class));
            domain.setResetInterval(row.get("ResetInterval", Integer.class));
            domain.setMaxPlayers(row.get("MaxPlayers", Integer.class));
            domain.setItemContext(row.get("ItemContext", Integer.class));
            domain.setItemContextPickerId(row.get("ItemContextPickerID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MapDifficulty, OutboundRow> {

        public OutboundRow convert(MapDifficulty source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMessage()).ifPresent(e -> row.put("Message", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getLockId()).ifPresent(e -> row.put("LockID", Parameter.from(e)));
            Optional.ofNullable(source.getResetInterval()).ifPresent(e -> row.put("ResetInterval", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPlayers()).ifPresent(e -> row.put("MaxPlayers", Parameter.from(e)));
            Optional.ofNullable(source.getItemContext()).ifPresent(e -> row.put("ItemContext", Parameter.from(e)));
            Optional.ofNullable(source.getItemContextPickerId()).ifPresent(e -> row.put("ItemContextPickerID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
