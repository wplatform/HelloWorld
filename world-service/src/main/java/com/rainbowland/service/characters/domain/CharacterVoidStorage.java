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
@Table("character_void_storage")
public class CharacterVoidStorage {

    @Column("itemId")
    private Long itemId;
    @Column("playerGuid")
    private Long playerGuid;
    @Column("itemEntry")
    private Integer itemEntry;
    @Column("slot")
    private Integer slot;
    @Column("creatorGuid")
    private Long creatorGuid;
    @Column("randomBonusListId")
    private Integer randomBonusListId;
    @Column("fixedScalingLevel")
    private Integer fixedScalingLevel;
    @Column("artifactKnowledgeLevel")
    private Integer artifactKnowledgeLevel;
    @Column("context")
    private Integer context;
    @Column("bonusListIDs")
    private String bonusListIDs;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterVoidStorage> {

        public CharacterVoidStorage convert(Row row) {
            CharacterVoidStorage domain = new CharacterVoidStorage();
            domain.setItemId(row.get("itemId", Long.class));
            domain.setPlayerGuid(row.get("playerGuid", Long.class));
            domain.setItemEntry(row.get("itemEntry", Integer.class));
            domain.setSlot(row.get("slot", Integer.class));
            domain.setCreatorGuid(row.get("creatorGuid", Long.class));
            domain.setRandomBonusListId(row.get("randomBonusListId", Integer.class));
            domain.setFixedScalingLevel(row.get("fixedScalingLevel", Integer.class));
            domain.setArtifactKnowledgeLevel(row.get("artifactKnowledgeLevel", Integer.class));
            domain.setContext(row.get("context", Integer.class));
            domain.setBonusListIDs(row.get("bonusListIDs", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterVoidStorage, OutboundRow> {

        public OutboundRow convert(CharacterVoidStorage source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("itemId", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid()).ifPresent(e -> row.put("playerGuid", Parameter.from(e)));
            Optional.ofNullable(source.getItemEntry()).ifPresent(e -> row.put("itemEntry", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("slot", Parameter.from(e)));
            Optional.ofNullable(source.getCreatorGuid()).ifPresent(e -> row.put("creatorGuid", Parameter.from(e)));
            Optional.ofNullable(source.getRandomBonusListId()).ifPresent(e -> row.put("randomBonusListId", Parameter.from(e)));
            Optional.ofNullable(source.getFixedScalingLevel()).ifPresent(e -> row.put("fixedScalingLevel", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactKnowledgeLevel()).ifPresent(e -> row.put("artifactKnowledgeLevel", Parameter.from(e)));
            Optional.ofNullable(source.getContext()).ifPresent(e -> row.put("context", Parameter.from(e)));
            Optional.ofNullable(source.getBonusListIDs()).ifPresent(e -> row.put("bonusListIDs", Parameter.from(e)));
            return row;
        }
    }

}
