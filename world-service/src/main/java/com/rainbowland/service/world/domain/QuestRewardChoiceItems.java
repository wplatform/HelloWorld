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
@Table("quest_reward_choice_items")
public class QuestRewardChoiceItems {

    @Column("QuestID")
    private Integer questId;
    @Column("Type1")
    private Integer type1;
    @Column("Type2")
    private Integer type2;
    @Column("Type3")
    private Integer type3;
    @Column("Type4")
    private Integer type4;
    @Column("Type5")
    private Integer type5;
    @Column("Type6")
    private Integer type6;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestRewardChoiceItems> {

        public QuestRewardChoiceItems convert(Row row) {
            QuestRewardChoiceItems domain = new QuestRewardChoiceItems();
            domain.setQuestId(row.get("QuestID", Integer.class));
            domain.setType1(row.get("Type1", Integer.class));
            domain.setType2(row.get("Type2", Integer.class));
            domain.setType3(row.get("Type3", Integer.class));
            domain.setType4(row.get("Type4", Integer.class));
            domain.setType5(row.get("Type5", Integer.class));
            domain.setType6(row.get("Type6", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestRewardChoiceItems, OutboundRow> {

        public OutboundRow convert(QuestRewardChoiceItems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestID", Parameter.from(e)));
            Optional.ofNullable(source.getType1()).ifPresent(e -> row.put("Type1", Parameter.from(e)));
            Optional.ofNullable(source.getType2()).ifPresent(e -> row.put("Type2", Parameter.from(e)));
            Optional.ofNullable(source.getType3()).ifPresent(e -> row.put("Type3", Parameter.from(e)));
            Optional.ofNullable(source.getType4()).ifPresent(e -> row.put("Type4", Parameter.from(e)));
            Optional.ofNullable(source.getType5()).ifPresent(e -> row.put("Type5", Parameter.from(e)));
            Optional.ofNullable(source.getType6()).ifPresent(e -> row.put("Type6", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
