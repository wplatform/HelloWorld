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
public class AreaTriggerEntry implements DbcEntity {
    @Column("PosX")
    private Float posX;

    @Column("PosY")
    private Float posY;

    @Column("PosZ")
    private Float posZ;

    @Column("Radius")
    private Float radius;

    @Column("BoxLength")
    private Float boxLength;

    @Column("BoxWidth")
    private Float boxWidth;

    @Column("BoxHeight")
    private Float boxHeight;

    @Column("BoxYaw")
    private Float boxYaw;

    @Column("ContinentID")
    private Short continentID;

    @Column("PhaseID")
    private Short phaseID;

    @Column("PhaseGroupID")
    private Short phaseGroupID;

    @Column("ShapeID")
    private Short shapeID;

    @Column("AreaTriggerActionSetID")
    private Short areaTriggerActionSetID;

    @Column("PhaseUseFlags")
    private Byte phaseUseFlags;

    @Column("ShapeType")
    private Byte shapeType;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
