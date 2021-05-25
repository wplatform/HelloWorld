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
@Table("dungeon_encounter")
public class DungeonEncounter {

    @Column("Name")
    private String name;
    @Column("ID")
    private Integer id;
    @Column("MapID")
    private Integer mapId;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("CompleteWorldStateID")
    private Integer completeWorldStateId;
    @Column("Bit")
    private Integer bit;
    @Column("CreatureDisplayID")
    private Integer creatureDisplayId;
    @Column("Flags")
    private Integer flags;
    @Column("SpellIconFileID")
    private Integer spellIconFileId;
    @Column("Faction")
    private Integer faction;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, DungeonEncounter> {

        public DungeonEncounter convert(Row row) {
            DungeonEncounter domain = new DungeonEncounter();
            domain.setName(row.get("Name", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setCompleteWorldStateId(row.get("CompleteWorldStateID", Integer.class));
            domain.setBit(row.get("Bit", Integer.class));
            domain.setCreatureDisplayId(row.get("CreatureDisplayID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSpellIconFileId(row.get("SpellIconFileID", Integer.class));
            domain.setFaction(row.get("Faction", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<DungeonEncounter, OutboundRow> {

        public OutboundRow convert(DungeonEncounter source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getCompleteWorldStateId()).ifPresent(e -> row.put("CompleteWorldStateID", Parameter.from(e)));
            Optional.ofNullable(source.getBit()).ifPresent(e -> row.put("Bit", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayId()).ifPresent(e -> row.put("CreatureDisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSpellIconFileId()).ifPresent(e -> row.put("SpellIconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("Faction", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
