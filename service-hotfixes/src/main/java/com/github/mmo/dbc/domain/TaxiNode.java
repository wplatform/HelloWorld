package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
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
@Table(name = "taxi_nodes")
@Db2DataBind(name = "TaxiNodes.db2", layoutHash = 0xB46C6A8B, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = {"posX", "posY","posZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"mountCreatureID1", "mountCreatureID2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"mapOffsetX", "mapOffsetY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "facing", type = Db2Type.FLOAT),
        @Db2Field(name = {"flightMapOffsetX", "flightMapOffsetY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "continentID", type = Db2Type.SHORT),
        @Db2Field(name = "conditionID", type = Db2Type.SHORT),
        @Db2Field(name = "characterBitNumber", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "uiTextureKitID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "specialIconConditionID", type = Db2Type.INT)
})
public class TaxiNode implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "PosX")
    private Float posX;

    @Column(name = "PosY")
    private Float posY;

    @Column(name = "PosZ")
    private Float posZ;

    @Column(name = "MountCreatureID1")
    private Integer mountCreatureID1;

    @Column(name = "MountCreatureID2")
    private Integer mountCreatureID2;

    @Column(name = "MapOffsetX")
    private Float mapOffsetX;

    @Column(name = "MapOffsetY")
    private Float mapOffsetY;

    @Column(name = "Facing")
    private Float facing;

    @Column(name = "FlightMapOffsetX")
    private Float flightMapOffsetX;

    @Column(name = "FlightMapOffsetY")
    private Float flightMapOffsetY;

    @Column(name = "ContinentID")
    private Short continentID;

    @Column(name = "ConditionID")
    private Integer conditionID;

    @Column(name = "CharacterBitNumber")
    private Short characterBitNumber;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "UiTextureKitID")
    private Integer uiTextureKitID;

    @Column(name = "SpecialIconConditionID")
    private Integer specialIconConditionID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
