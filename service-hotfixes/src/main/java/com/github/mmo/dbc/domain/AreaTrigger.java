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
@Table(name = "area_trigger")
@Db2DataBind(name = "AreaTrigger.db2", layoutHash = 0x378573E8, indexField = 14, parentIndexField = 6, fields = {
        @Db2Field(name = {"posX", "posY", "posZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "radius", type = Db2Type.FLOAT),
        @Db2Field(name = "boxLength", type = Db2Type.FLOAT),
        @Db2Field(name = "boxWidth", type = Db2Type.FLOAT),
        @Db2Field(name = "boxHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "boxYaw", type = Db2Type.FLOAT),
        @Db2Field(name = "continentID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "phaseID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "phaseGroupID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "shapeID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "areaTriggerActionSetID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "phaseUseFlags", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "shapeType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class AreaTrigger implements DbcEntity {
    @Column(name = "PosX")
    private Float posX;

    @Column(name = "PosY")
    private Float posY;

    @Column(name = "PosZ")
    private Float posZ;

    @Column(name = "Radius")
    private Float radius;

    @Column(name = "BoxLength")
    private Float boxLength;

    @Column(name = "BoxWidth")
    private Float boxWidth;

    @Column(name = "BoxHeight")
    private Float boxHeight;

    @Column(name = "BoxYaw")
    private Float boxYaw;

    @Column(name = "ContinentID")
    private Short continentID;

    @Column(name = "PhaseID")
    private Short phaseID;

    @Column(name = "PhaseGroupID")
    private Short phaseGroupID;

    @Column(name = "ShapeID")
    private Short shapeID;

    @Column(name = "AreaTriggerActionSetID")
    private Short areaTriggerActionSetID;

    @Column(name = "PhaseUseFlags")
    private Byte phaseUseFlags;

    @Column(name = "ShapeType")
    private Byte shapeType;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
