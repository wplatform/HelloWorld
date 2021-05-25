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
@Table("quest_sort")
public class QuestSort {

    @Column("ID")
    private Integer id;
    @Column("SortName")
    private String sortName;
    @Column("UiOrderIndex")
    private Integer uiOrderIndex;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestSort> {

        public QuestSort convert(Row row) {
            QuestSort domain = new QuestSort();
            domain.setId(row.get("ID", Integer.class));
            domain.setSortName(row.get("SortName", String.class));
            domain.setUiOrderIndex(row.get("UiOrderIndex", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestSort, OutboundRow> {

        public OutboundRow convert(QuestSort source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSortName()).ifPresent(e -> row.put("SortName", Parameter.from(e)));
            Optional.ofNullable(source.getUiOrderIndex()).ifPresent(e -> row.put("UiOrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
