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
@Table("playerchoice_response_maw_power")
public class PlayerchoiceResponseMawPower {

    @Column("ChoiceId")
    private Integer choiceId;
    @Column("ResponseId")
    private Integer responseId;
    @Column("TypeArtFileID")
    private Integer typeArtFileId;
    @Column("Rarity")
    private Integer rarity;
    @Column("RarityColor")
    private Integer rarityColor;
    @Column("SpellID")
    private Integer spellId;
    @Column("MaxStacks")
    private Integer maxStacks;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerchoiceResponseMawPower> {

        public PlayerchoiceResponseMawPower convert(Row row) {
            PlayerchoiceResponseMawPower domain = new PlayerchoiceResponseMawPower();
            domain.setChoiceId(row.get("ChoiceId", Integer.class));
            domain.setResponseId(row.get("ResponseId", Integer.class));
            domain.setTypeArtFileId(row.get("TypeArtFileID", Integer.class));
            domain.setRarity(row.get("Rarity", Integer.class));
            domain.setRarityColor(row.get("RarityColor", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setMaxStacks(row.get("MaxStacks", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerchoiceResponseMawPower, OutboundRow> {

        public OutboundRow convert(PlayerchoiceResponseMawPower source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getChoiceId()).ifPresent(e -> row.put("ChoiceId", Parameter.from(e)));
            Optional.ofNullable(source.getResponseId()).ifPresent(e -> row.put("ResponseId", Parameter.from(e)));
            Optional.ofNullable(source.getTypeArtFileId()).ifPresent(e -> row.put("TypeArtFileID", Parameter.from(e)));
            Optional.ofNullable(source.getRarity()).ifPresent(e -> row.put("Rarity", Parameter.from(e)));
            Optional.ofNullable(source.getRarityColor()).ifPresent(e -> row.put("RarityColor", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxStacks()).ifPresent(e -> row.put("MaxStacks", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
