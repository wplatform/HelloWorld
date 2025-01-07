package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "light")
@Db2DataBind(name = "Light.db2", layoutHash = 0x25025A13, fields = {
        @Db2Field(name = {"gameCoordsX", "gameCoordsY", "gameCoordsZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "gameFalloffStart", type = Db2Type.FLOAT),
        @Db2Field(name = "gameFalloffEnd", type = Db2Type.FLOAT),
        @Db2Field(name = "continentID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = {"lightParamsID1", "lightParamsID2", "lightParamsID3", "lightParamsID4", "lightParamsID5", "lightParamsID6", "lightParamsID7", "lightParamsID8"}, type = Db2Type.SHORT)
})
public class Light implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("GameCoordsX")
    private Float gameCoordsX;

    @Column("GameCoordsY")
    private Float gameCoordsY;

    @Column("GameCoordsZ")
    private Float gameCoordsZ;

    @Column("GameFalloffStart")
    private Float gameFalloffStart;

    @Column("GameFalloffEnd")
    private Float gameFalloffEnd;

    @Column("ContinentID")
    private Short continentID;

    @Column("LightParamsID1")
    private Short lightParamsID1;

    @Column("LightParamsID2")
    private Short lightParamsID2;

    @Column("LightParamsID3")
    private Short lightParamsID3;

    @Column("LightParamsID4")
    private Short lightParamsID4;

    @Column("LightParamsID5")
    private Short lightParamsID5;

    @Column("LightParamsID6")
    private Short lightParamsID6;

    @Column("LightParamsID7")
    private Short lightParamsID7;

    @Column("LightParamsID8")
    private Short lightParamsID8;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
