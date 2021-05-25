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
@Table("character_battleground_data")
public class CharacterBattlegroundData {

    @Column("guid")
    private Long guid;
    @Column("instanceId")
    private Integer instanceId;
    @Column("team")
    private Integer team;
    @Column("joinX")
    private Double joinX;
    @Column("joinY")
    private Double joinY;
    @Column("joinZ")
    private Double joinZ;
    @Column("joinO")
    private Double joinO;
    @Column("joinMapId")
    private Integer joinMapId;
    @Column("taxiStart")
    private Integer taxiStart;
    @Column("taxiEnd")
    private Integer taxiEnd;
    @Column("mountSpell")
    private Integer mountSpell;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterBattlegroundData> {

        public CharacterBattlegroundData convert(Row row) {
            CharacterBattlegroundData domain = new CharacterBattlegroundData();
            domain.setGuid(row.get("guid", Long.class));
            domain.setInstanceId(row.get("instanceId", Integer.class));
            domain.setTeam(row.get("team", Integer.class));
            domain.setJoinX(row.get("joinX", Double.class));
            domain.setJoinY(row.get("joinY", Double.class));
            domain.setJoinZ(row.get("joinZ", Double.class));
            domain.setJoinO(row.get("joinO", Double.class));
            domain.setJoinMapId(row.get("joinMapId", Integer.class));
            domain.setTaxiStart(row.get("taxiStart", Integer.class));
            domain.setTaxiEnd(row.get("taxiEnd", Integer.class));
            domain.setMountSpell(row.get("mountSpell", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterBattlegroundData, OutboundRow> {

        public OutboundRow convert(CharacterBattlegroundData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceId()).ifPresent(e -> row.put("instanceId", Parameter.from(e)));
            Optional.ofNullable(source.getTeam()).ifPresent(e -> row.put("team", Parameter.from(e)));
            Optional.ofNullable(source.getJoinX()).ifPresent(e -> row.put("joinX", Parameter.from(e)));
            Optional.ofNullable(source.getJoinY()).ifPresent(e -> row.put("joinY", Parameter.from(e)));
            Optional.ofNullable(source.getJoinZ()).ifPresent(e -> row.put("joinZ", Parameter.from(e)));
            Optional.ofNullable(source.getJoinO()).ifPresent(e -> row.put("joinO", Parameter.from(e)));
            Optional.ofNullable(source.getJoinMapId()).ifPresent(e -> row.put("joinMapId", Parameter.from(e)));
            Optional.ofNullable(source.getTaxiStart()).ifPresent(e -> row.put("taxiStart", Parameter.from(e)));
            Optional.ofNullable(source.getTaxiEnd()).ifPresent(e -> row.put("taxiEnd", Parameter.from(e)));
            Optional.ofNullable(source.getMountSpell()).ifPresent(e -> row.put("mountSpell", Parameter.from(e)));
            return row;
        }
    }

}
