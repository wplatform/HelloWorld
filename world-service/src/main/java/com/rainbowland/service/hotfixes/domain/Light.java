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
@Table("light")
public class Light {

    @Column("ID")
    private Integer id;
    @Column("GameCoordsX")
    private Double gameCoordsX;
    @Column("GameCoordsY")
    private Double gameCoordsY;
    @Column("GameCoordsZ")
    private Double gameCoordsZ;
    @Column("GameFalloffStart")
    private Double gameFalloffStart;
    @Column("GameFalloffEnd")
    private Double gameFalloffEnd;
    @Column("ContinentID")
    private Integer continentId;
    @Column("LightParamsID1")
    private Integer lightParamsId1;
    @Column("LightParamsID2")
    private Integer lightParamsId2;
    @Column("LightParamsID3")
    private Integer lightParamsId3;
    @Column("LightParamsID4")
    private Integer lightParamsId4;
    @Column("LightParamsID5")
    private Integer lightParamsId5;
    @Column("LightParamsID6")
    private Integer lightParamsId6;
    @Column("LightParamsID7")
    private Integer lightParamsId7;
    @Column("LightParamsID8")
    private Integer lightParamsId8;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Light> {

        public Light convert(Row row) {
            Light domain = new Light();
            domain.setId(row.get("ID", Integer.class));
            domain.setGameCoordsX(row.get("GameCoordsX", Double.class));
            domain.setGameCoordsY(row.get("GameCoordsY", Double.class));
            domain.setGameCoordsZ(row.get("GameCoordsZ", Double.class));
            domain.setGameFalloffStart(row.get("GameFalloffStart", Double.class));
            domain.setGameFalloffEnd(row.get("GameFalloffEnd", Double.class));
            domain.setContinentId(row.get("ContinentID", Integer.class));
            domain.setLightParamsId1(row.get("LightParamsID1", Integer.class));
            domain.setLightParamsId2(row.get("LightParamsID2", Integer.class));
            domain.setLightParamsId3(row.get("LightParamsID3", Integer.class));
            domain.setLightParamsId4(row.get("LightParamsID4", Integer.class));
            domain.setLightParamsId5(row.get("LightParamsID5", Integer.class));
            domain.setLightParamsId6(row.get("LightParamsID6", Integer.class));
            domain.setLightParamsId7(row.get("LightParamsID7", Integer.class));
            domain.setLightParamsId8(row.get("LightParamsID8", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Light, OutboundRow> {

        public OutboundRow convert(Light source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGameCoordsX()).ifPresent(e -> row.put("GameCoordsX", Parameter.from(e)));
            Optional.ofNullable(source.getGameCoordsY()).ifPresent(e -> row.put("GameCoordsY", Parameter.from(e)));
            Optional.ofNullable(source.getGameCoordsZ()).ifPresent(e -> row.put("GameCoordsZ", Parameter.from(e)));
            Optional.ofNullable(source.getGameFalloffStart()).ifPresent(e -> row.put("GameFalloffStart", Parameter.from(e)));
            Optional.ofNullable(source.getGameFalloffEnd()).ifPresent(e -> row.put("GameFalloffEnd", Parameter.from(e)));
            Optional.ofNullable(source.getContinentId()).ifPresent(e -> row.put("ContinentID", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId1()).ifPresent(e -> row.put("LightParamsID1", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId2()).ifPresent(e -> row.put("LightParamsID2", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId3()).ifPresent(e -> row.put("LightParamsID3", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId4()).ifPresent(e -> row.put("LightParamsID4", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId5()).ifPresent(e -> row.put("LightParamsID5", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId6()).ifPresent(e -> row.put("LightParamsID6", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId7()).ifPresent(e -> row.put("LightParamsID7", Parameter.from(e)));
            Optional.ofNullable(source.getLightParamsId8()).ifPresent(e -> row.put("LightParamsID8", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
