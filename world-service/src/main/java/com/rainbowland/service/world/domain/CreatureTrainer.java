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
@Table("creature_trainer")
public class CreatureTrainer {

    @Column("CreatureId")
    private Integer creatureId;
    @Column("TrainerId")
    private Integer trainerId;
    @Column("MenuId")
    private Integer menuId;
    @Column("OptionIndex")
    private Integer optionIndex;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureTrainer> {

        public CreatureTrainer convert(Row row) {
            CreatureTrainer domain = new CreatureTrainer();
            domain.setCreatureId(row.get("CreatureId", Integer.class));
            domain.setTrainerId(row.get("TrainerId", Integer.class));
            domain.setMenuId(row.get("MenuId", Integer.class));
            domain.setOptionIndex(row.get("OptionIndex", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureTrainer, OutboundRow> {

        public OutboundRow convert(CreatureTrainer source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureId", Parameter.from(e)));
            Optional.ofNullable(source.getTrainerId()).ifPresent(e -> row.put("TrainerId", Parameter.from(e)));
            Optional.ofNullable(source.getMenuId()).ifPresent(e -> row.put("MenuId", Parameter.from(e)));
            Optional.ofNullable(source.getOptionIndex()).ifPresent(e -> row.put("OptionIndex", Parameter.from(e)));
            return row;
        }
    }

}
