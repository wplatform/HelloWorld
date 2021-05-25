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
@Table("lfg_dungeon_rewards")
public class LfgDungeonRewards {

    @Column("dungeonId")
    private Integer dungeonId;
    @Column("maxLevel")
    private Integer maxLevel;
    @Column("firstQuestId")
    private Integer firstQuestId;
    @Column("otherQuestId")
    private Integer otherQuestId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, LfgDungeonRewards> {

        public LfgDungeonRewards convert(Row row) {
            LfgDungeonRewards domain = new LfgDungeonRewards();
            domain.setDungeonId(row.get("dungeonId", Integer.class));
            domain.setMaxLevel(row.get("maxLevel", Integer.class));
            domain.setFirstQuestId(row.get("firstQuestId", Integer.class));
            domain.setOtherQuestId(row.get("otherQuestId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<LfgDungeonRewards, OutboundRow> {

        public OutboundRow convert(LfgDungeonRewards source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDungeonId()).ifPresent(e -> row.put("dungeonId", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("maxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getFirstQuestId()).ifPresent(e -> row.put("firstQuestId", Parameter.from(e)));
            Optional.ofNullable(source.getOtherQuestId()).ifPresent(e -> row.put("otherQuestId", Parameter.from(e)));
            return row;
        }
    }

}
