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
@Table("pool_quest_save")
public class PoolQuestSave {

    @Column("pool_id")
    private Integer poolId;
    @Column("quest_id")
    private Integer questId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PoolQuestSave> {

        public PoolQuestSave convert(Row row) {
            PoolQuestSave domain = new PoolQuestSave();
            domain.setPoolId(row.get("pool_id", Integer.class));
            domain.setQuestId(row.get("quest_id", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PoolQuestSave, OutboundRow> {

        public OutboundRow convert(PoolQuestSave source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getPoolId()).ifPresent(e -> row.put("pool_id", Parameter.from(e)));
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("quest_id", Parameter.from(e)));
            return row;
        }
    }

}
