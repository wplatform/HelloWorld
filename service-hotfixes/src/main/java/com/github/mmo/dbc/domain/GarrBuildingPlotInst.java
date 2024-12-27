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
@Table(name = "garr_building_plot_inst")
@Db2DataBind(name = "GarrBuildingPlotInst.db2", layoutHash = 0xF45B6227, indexField = 4, parentIndexField = 3, fields = {
        @Db2Field(name = {"mapOffsetX", "mapOffsetY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "uiTextureAtlasMemberID", type = Db2Type.SHORT),
        @Db2Field(name = "garrSiteLevelPlotInstID", type = Db2Type.SHORT),
        @Db2Field(name = "garrBuildingID", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class GarrBuildingPlotInst implements DbcEntity {
    @Column(name = "MapOffsetX")
    private Float mapOffsetX;

    @Column(name = "MapOffsetY")
    private Float mapOffsetY;

    @Column(name = "UiTextureAtlasMemberID")
    private Short uiTextureAtlasMemberID;

    @Column(name = "GarrSiteLevelPlotInstID")
    private Short garrSiteLevelPlotInstID;

    @Column(name = "GarrBuildingID")
    private Short garrBuildingID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
