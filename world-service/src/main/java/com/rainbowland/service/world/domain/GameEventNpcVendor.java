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
@Table("game_event_npc_vendor")
public class GameEventNpcVendor {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("guid")
    private Long guid;
    @Column("slot")
    private Integer slot;
    @Column("item")
    private Integer item;
    @Column("maxcount")
    private Integer maxcount;
    @Column("incrtime")
    private Integer incrtime;
    @Column("ExtendedCost")
    private Integer extendedCost;
    @Column("type")
    private Integer type;
    @Column("BonusListIDs")
    private String bonusListIDs;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("IgnoreFiltering")
    private Integer ignoreFiltering;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventNpcVendor> {

        public GameEventNpcVendor convert(Row row) {
            GameEventNpcVendor domain = new GameEventNpcVendor();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setGuid(row.get("guid", Long.class));
            domain.setSlot(row.get("slot", Integer.class));
            domain.setItem(row.get("item", Integer.class));
            domain.setMaxcount(row.get("maxcount", Integer.class));
            domain.setIncrtime(row.get("incrtime", Integer.class));
            domain.setExtendedCost(row.get("ExtendedCost", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setBonusListIDs(row.get("BonusListIDs", String.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setIgnoreFiltering(row.get("IgnoreFiltering", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventNpcVendor, OutboundRow> {

        public OutboundRow convert(GameEventNpcVendor source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("slot", Parameter.from(e)));
            Optional.ofNullable(source.getItem()).ifPresent(e -> row.put("item", Parameter.from(e)));
            Optional.ofNullable(source.getMaxcount()).ifPresent(e -> row.put("maxcount", Parameter.from(e)));
            Optional.ofNullable(source.getIncrtime()).ifPresent(e -> row.put("incrtime", Parameter.from(e)));
            Optional.ofNullable(source.getExtendedCost()).ifPresent(e -> row.put("ExtendedCost", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getBonusListIDs()).ifPresent(e -> row.put("BonusListIDs", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getIgnoreFiltering()).ifPresent(e -> row.put("IgnoreFiltering", Parameter.from(e)));
            return row;
        }
    }

}
