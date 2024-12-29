package com.github.mmo.dbc.domain;

import com.github.mmo.common.LocalizedString;
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


@Getter
@Setter
@ToString


@Table(name = "unit_power_bar")
@Db2DataBind(name = "UnitPowerBar.db2", layoutHash = 0x626C94CD, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "cost", type = Db2Type.STRING),
        @Db2Field(name = "outOfError", type = Db2Type.STRING),
        @Db2Field(name = "toolTip", type = Db2Type.STRING),
        @Db2Field(name = "regenerationPeace", type = Db2Type.FLOAT),
        @Db2Field(name = "regenerationCombat", type = Db2Type.FLOAT),
        @Db2Field(name = {"fileDataID1", "fileDataID2", "fileDataID3", "fileDataID4", "fileDataID5", "fileDataID6"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"color1", "color2", "color3", "color4", "color5", "color6"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "startInset", type = Db2Type.FLOAT),
        @Db2Field(name = "endInset", type = Db2Type.FLOAT),
        @Db2Field(name = "startPower", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "centerPower", type = Db2Type.BYTE),
        @Db2Field(name = "barType", type = Db2Type.BYTE),
        @Db2Field(name = "minPower", type = Db2Type.INT),
        @Db2Field(name = "maxPower", type = Db2Type.INT)
})
public class UnitPowerBar implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("Cost")
    private LocalizedString cost;

    @Column("OutOfError")
    private LocalizedString outOfError;

    @Column("ToolTip")
    private LocalizedString toolTip;

    @Column("RegenerationPeace")
    private Float regenerationPeace;

    @Column("RegenerationCombat")
    private Float regenerationCombat;

    @Column("FileDataID1")
    private Integer fileDataID1;

    @Column("FileDataID2")
    private Integer fileDataID2;

    @Column("FileDataID3")
    private Integer fileDataID3;

    @Column("FileDataID4")
    private Integer fileDataID4;

    @Column("FileDataID5")
    private Integer fileDataID5;

    @Column("FileDataID6")
    private Integer fileDataID6;

    @Column("Color1")
    private Integer color1;

    @Column("Color2")
    private Integer color2;

    @Column("Color3")
    private Integer color3;

    @Column("Color4")
    private Integer color4;

    @Column("Color5")
    private Integer color5;

    @Column("Color6")
    private Integer color6;

    @Column("StartInset")
    private Float startInset;

    @Column("EndInset")
    private Float endInset;

    @Column("StartPower")
    private Short startPower;

    @Column("Flags")
    private Short flags;

    @Column("CenterPower")
    private Byte centerPower;

    @Column("BarType")
    private Byte barType;

    @Column("MinPower")
    private Integer minPower;

    @Column("MaxPower")
    private Integer maxPower;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
