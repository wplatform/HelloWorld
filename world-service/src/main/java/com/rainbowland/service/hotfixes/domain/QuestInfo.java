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
@Table("quest_info")
public class QuestInfo {

    @Column("ID")
    private Integer id;
    @Column("InfoName")
    private String infoName;
    @Column("Type")
    private Integer type;
    @Column("Modifiers")
    private Integer modifiers;
    @Column("Profession")
    private Integer profession;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestInfo> {

        public QuestInfo convert(Row row) {
            QuestInfo domain = new QuestInfo();
            domain.setId(row.get("ID", Integer.class));
            domain.setInfoName(row.get("InfoName", String.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setModifiers(row.get("Modifiers", Integer.class));
            domain.setProfession(row.get("Profession", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestInfo, OutboundRow> {

        public OutboundRow convert(QuestInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getInfoName()).ifPresent(e -> row.put("InfoName", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getModifiers()).ifPresent(e -> row.put("Modifiers", Parameter.from(e)));
            Optional.ofNullable(source.getProfession()).ifPresent(e -> row.put("Profession", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
