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
@Table(name = "world_safe_loc")
@Db2DataBind(name = "WorldSafeLocs.db2", layoutHash = 0x605EA8A6, parentIndexField = 3, fields = {
        @Db2Field(name = "areaName", type = Db2Type.STRING),
        @Db2Field(name = {"locX", "locY", "locZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "facing", type = Db2Type.FLOAT),
        @Db2Field(name = "mapID", type = Db2Type.SHORT)
})
public class WorldSafeLoc implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "AreaName")
    private LocalizedString areaName;

    @Column(name = "LocX")
    private Float locX;

    @Column(name = "LocY")
    private Float locY;

    @Column(name = "LocZ")
    private Float locZ;

    @Column(name = "Facing")
    private Float facing;

    @Column(name = "MapID")
    private Short mapID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
