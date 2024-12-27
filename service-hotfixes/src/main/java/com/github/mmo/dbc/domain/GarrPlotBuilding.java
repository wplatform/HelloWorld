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
@Table(name = "garr_plot_building")
@Db2DataBind(name = "GarrPlotBuilding.db2", layoutHash = 0x3F77A6FA, fields = {
        @Db2Field(name = "garrPlotID", type = Db2Type.BYTE),
        @Db2Field(name = "garrBuildingID", type = Db2Type.BYTE)
})
public class GarrPlotBuilding implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "GarrPlotID")
    private Byte garrPlotID;

    @Column(name = "GarrBuildingID")
    private Short garrBuildingID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
