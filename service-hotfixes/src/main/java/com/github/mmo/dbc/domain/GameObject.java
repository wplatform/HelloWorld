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
@Table(name = "gameobjects")
@Db2DataBind(name = "GameObjects.db2", layoutHash = 0x597E8643, indexField = 11, parentIndexField = 5, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = {"posX", "posY", "posZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"rot1", "rot2", "rot3", "rot4"}, type = Db2Type.FLOAT),
        @Db2Field(name = "scale", type = Db2Type.FLOAT),
        @Db2Field(name = {"propValue1", "propValue2", "propValue3", "propValue4", "propValue5", "propValue6", "propValue7", "propValue8"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "ownerID", type = Db2Type.SHORT),
        @Db2Field(name = "displayID", type = Db2Type.SHORT),
        @Db2Field(name = "phaseID", type = Db2Type.SHORT),
        @Db2Field(name = "phaseGroupID", type = Db2Type.SHORT),
        @Db2Field(name = "phaseUseFlags", type = Db2Type.BYTE),
        @Db2Field(name = "typeID", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class GameObject implements DbcEntity {
    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "PosX")
    private Float posX;

    @Column(name = "PosY")
    private Float posY;

    @Column(name = "PosZ")
    private Float posZ;

    @Column(name = "Rot1")
    private Float rot1;

    @Column(name = "Rot2")
    private Float rot2;

    @Column(name = "Rot3")
    private Float rot3;

    @Column(name = "Rot4")
    private Float rot4;

    @Column(name = "Scale")
    private Float scale;

    @Column(name = "PropValue1")
    private Integer propValue1;

    @Column(name = "PropValue2")
    private Integer propValue2;

    @Column(name = "PropValue3")
    private Integer propValue3;

    @Column(name = "PropValue4")
    private Integer propValue4;

    @Column(name = "PropValue5")
    private Integer propValue5;

    @Column(name = "PropValue6")
    private Integer propValue6;

    @Column(name = "PropValue7")
    private Integer propValue7;

    @Column(name = "PropValue8")
    private Integer propValue8;

    @Column(name = "OwnerID")
    private Short ownerID;

    @Column(name = "DisplayID")
    private Integer displayID;

    @Column(name = "PhaseID")
    private Short phaseID;

    @Column(name = "PhaseGroupID")
    private Short phaseGroupID;

    @Column(name = "PhaseUseFlags")
    private Byte phaseUseFlags;

    @Column(name = "TypeID")
    private Byte typeID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
