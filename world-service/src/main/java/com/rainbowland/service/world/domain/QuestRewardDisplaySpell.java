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
@Table("quest_reward_display_spell")
public class QuestRewardDisplaySpell {

    @Column("QuestID")
    private Integer questId;
    @Column("Idx")
    private Integer idx;
    @Column("SpellID")
    private Integer spellId;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestRewardDisplaySpell> {

        public QuestRewardDisplaySpell convert(Row row) {
            QuestRewardDisplaySpell domain = new QuestRewardDisplaySpell();
            domain.setQuestId(row.get("QuestID", Integer.class));
            domain.setIdx(row.get("Idx", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestRewardDisplaySpell, OutboundRow> {

        public OutboundRow convert(QuestRewardDisplaySpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestID", Parameter.from(e)));
            Optional.ofNullable(source.getIdx()).ifPresent(e -> row.put("Idx", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
