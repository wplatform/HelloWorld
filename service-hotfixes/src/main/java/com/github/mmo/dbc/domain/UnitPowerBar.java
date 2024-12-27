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
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Cost")
    private LocalizedString cost;

    @Column(name = "OutOfError")
    private LocalizedString outOfError;

    @Column(name = "ToolTip")
    private LocalizedString toolTip;

    @Column(name = "RegenerationPeace")
    private Float regenerationPeace;

    @Column(name = "RegenerationCombat")
    private Float regenerationCombat;

    @Column(name = "FileDataID1")
    private Integer fileDataID1;

    @Column(name = "FileDataID2")
    private Integer fileDataID2;

    @Column(name = "FileDataID3")
    private Integer fileDataID3;

    @Column(name = "FileDataID4")
    private Integer fileDataID4;

    @Column(name = "FileDataID5")
    private Integer fileDataID5;

    @Column(name = "FileDataID6")
    private Integer fileDataID6;

    @Column(name = "Color1")
    private Integer color1;

    @Column(name = "Color2")
    private Integer color2;

    @Column(name = "Color3")
    private Integer color3;

    @Column(name = "Color4")
    private Integer color4;

    @Column(name = "Color5")
    private Integer color5;

    @Column(name = "Color6")
    private Integer color6;

    @Column(name = "StartInset")
    private Float startInset;

    @Column(name = "EndInset")
    private Float endInset;

    @Column(name = "StartPower")
    private Short startPower;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "CenterPower")
    private Byte centerPower;

    @Column(name = "BarType")
    private Byte barType;

    @Column(name = "MinPower")
    private Integer minPower;

    @Column(name = "MaxPower")
    private Integer maxPower;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
