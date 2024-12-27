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
@Table(name = "garr_site_level_plot_inst")
@Db2DataBind(name = "GarrSiteLevelPlotInst.db2", layoutHash = 0xC4E74201, parentIndexField = 1, fields = {
        @Db2Field(name = {"uiMarkerPosX", "uiMarkerPosY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "garrSiteLevelID", type = Db2Type.SHORT),
        @Db2Field(name = "garrPlotInstanceID", type = Db2Type.BYTE),
        @Db2Field(name = "uiMarkerSize", type = Db2Type.BYTE)
})
public class GarrSiteLevelPlotInst implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "UiMarkerPosX")
    private Float uiMarkerPosX;

    @Column(name = "UiMarkerPosY")
    private Float uiMarkerPosY;

    @Column(name = "GarrSiteLevelID")
    private Short garrSiteLevelID;

    @Column(name = "GarrPlotInstanceID")
    private Byte garrPlotInstanceID;

    @Column(name = "UiMarkerSize")
    private Byte uiMarkerSize;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
