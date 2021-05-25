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
@Table("trainer_spell")
public class TrainerSpell {

    @Column("TrainerId")
    private Integer trainerId;
    @Column("SpellId")
    private Integer spellId;
    @Column("MoneyCost")
    private Integer moneyCost;
    @Column("ReqSkillLine")
    private Integer reqSkillLine;
    @Column("ReqSkillRank")
    private Integer reqSkillRank;
    @Column("ReqAbility1")
    private Integer reqAbility1;
    @Column("ReqAbility2")
    private Integer reqAbility2;
    @Column("ReqAbility3")
    private Integer reqAbility3;
    @Column("ReqLevel")
    private Integer reqLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TrainerSpell> {

        public TrainerSpell convert(Row row) {
            TrainerSpell domain = new TrainerSpell();
            domain.setTrainerId(row.get("TrainerId", Integer.class));
            domain.setSpellId(row.get("SpellId", Integer.class));
            domain.setMoneyCost(row.get("MoneyCost", Integer.class));
            domain.setReqSkillLine(row.get("ReqSkillLine", Integer.class));
            domain.setReqSkillRank(row.get("ReqSkillRank", Integer.class));
            domain.setReqAbility1(row.get("ReqAbility1", Integer.class));
            domain.setReqAbility2(row.get("ReqAbility2", Integer.class));
            domain.setReqAbility3(row.get("ReqAbility3", Integer.class));
            domain.setReqLevel(row.get("ReqLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TrainerSpell, OutboundRow> {

        public OutboundRow convert(TrainerSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getTrainerId()).ifPresent(e -> row.put("TrainerId", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellId", Parameter.from(e)));
            Optional.ofNullable(source.getMoneyCost()).ifPresent(e -> row.put("MoneyCost", Parameter.from(e)));
            Optional.ofNullable(source.getReqSkillLine()).ifPresent(e -> row.put("ReqSkillLine", Parameter.from(e)));
            Optional.ofNullable(source.getReqSkillRank()).ifPresent(e -> row.put("ReqSkillRank", Parameter.from(e)));
            Optional.ofNullable(source.getReqAbility1()).ifPresent(e -> row.put("ReqAbility1", Parameter.from(e)));
            Optional.ofNullable(source.getReqAbility2()).ifPresent(e -> row.put("ReqAbility2", Parameter.from(e)));
            Optional.ofNullable(source.getReqAbility3()).ifPresent(e -> row.put("ReqAbility3", Parameter.from(e)));
            Optional.ofNullable(source.getReqLevel()).ifPresent(e -> row.put("ReqLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
