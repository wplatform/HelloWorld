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
@Table("quest_xp")
public class QuestXp {

    @Column("ID")
    private Integer id;
    @Column("Difficulty1")
    private Integer difficulty1;
    @Column("Difficulty2")
    private Integer difficulty2;
    @Column("Difficulty3")
    private Integer difficulty3;
    @Column("Difficulty4")
    private Integer difficulty4;
    @Column("Difficulty5")
    private Integer difficulty5;
    @Column("Difficulty6")
    private Integer difficulty6;
    @Column("Difficulty7")
    private Integer difficulty7;
    @Column("Difficulty8")
    private Integer difficulty8;
    @Column("Difficulty9")
    private Integer difficulty9;
    @Column("Difficulty10")
    private Integer difficulty10;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestXp> {

        public QuestXp convert(Row row) {
            QuestXp domain = new QuestXp();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficulty1(row.get("Difficulty1", Integer.class));
            domain.setDifficulty2(row.get("Difficulty2", Integer.class));
            domain.setDifficulty3(row.get("Difficulty3", Integer.class));
            domain.setDifficulty4(row.get("Difficulty4", Integer.class));
            domain.setDifficulty5(row.get("Difficulty5", Integer.class));
            domain.setDifficulty6(row.get("Difficulty6", Integer.class));
            domain.setDifficulty7(row.get("Difficulty7", Integer.class));
            domain.setDifficulty8(row.get("Difficulty8", Integer.class));
            domain.setDifficulty9(row.get("Difficulty9", Integer.class));
            domain.setDifficulty10(row.get("Difficulty10", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestXp, OutboundRow> {

        public OutboundRow convert(QuestXp source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty1()).ifPresent(e -> row.put("Difficulty1", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty2()).ifPresent(e -> row.put("Difficulty2", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty3()).ifPresent(e -> row.put("Difficulty3", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty4()).ifPresent(e -> row.put("Difficulty4", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty5()).ifPresent(e -> row.put("Difficulty5", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty6()).ifPresent(e -> row.put("Difficulty6", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty7()).ifPresent(e -> row.put("Difficulty7", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty8()).ifPresent(e -> row.put("Difficulty8", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty9()).ifPresent(e -> row.put("Difficulty9", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty10()).ifPresent(e -> row.put("Difficulty10", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
