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


@Getter
@Setter
@ToString


@Table(name = "garr_plot")
@Db2DataBind(name = "GarrPlot.db2", layoutHash = 0xE12049E0, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "allianceConstructObjID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hordeConstructObjID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiCategoryID", type = Db2Type.BYTE),
        @Db2Field(name = "plotType", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = {"upgradeRequirement1", "upgradeRequirement2"}, type = Db2Type.INT)
})
public class GarrPlot implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("AllianceConstructObjID")
    private Integer allianceConstructObjID;

    @Column("HordeConstructObjID")
    private Integer hordeConstructObjID;

    @Column("UiCategoryID")
    private Byte uiCategoryID;

    @Column("PlotType")
    private Byte plotType;

    @Column("Flags")
    private Byte flags;

    @Column("UpgradeRequirement1")
    private Integer upgradeRequirement1;

    @Column("UpgradeRequirement2")
    private Integer upgradeRequirement2;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
