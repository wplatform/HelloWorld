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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "AllianceConstructObjID")
    private Integer allianceConstructObjID;

    @Column(name = "HordeConstructObjID")
    private Integer hordeConstructObjID;

    @Column(name = "UiCategoryID")
    private Byte uiCategoryID;

    @Column(name = "PlotType")
    private Byte plotType;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "UpgradeRequirement1")
    private Integer upgradeRequirement1;

    @Column(name = "UpgradeRequirement2")
    private Integer upgradeRequirement2;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
