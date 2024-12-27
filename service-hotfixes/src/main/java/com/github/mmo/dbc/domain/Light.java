package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "GameCoordsX")
    private Float gameCoordsX;

    @Column(name = "GameCoordsY")
    private Float gameCoordsY;

    @Column(name = "GameCoordsZ")
    private Float gameCoordsZ;

    @Column(name = "GameFalloffStart")
    private Float gameFalloffStart;

    @Column(name = "GameFalloffEnd")
    private Float gameFalloffEnd;

    @Column(name = "ContinentID")
    private Short continentID;

    @Column(name = "LightParamsID1")
    private Short lightParamsID1;

    @Column(name = "LightParamsID2")
    private Short lightParamsID2;

    @Column(name = "LightParamsID3")
    private Short lightParamsID3;

    @Column(name = "LightParamsID4")
    private Short lightParamsID4;

    @Column(name = "LightParamsID5")
    private Short lightParamsID5;

    @Column(name = "LightParamsID6")
    private Short lightParamsID6;

    @Column(name = "LightParamsID7")
    private Short lightParamsID7;

    @Column(name = "LightParamsID8")
    private Short lightParamsID8;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
