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
@Table(name = "taxi_path_node")
@Db2DataBind(name = "TaxiPathNode.db2", layoutHash = 0xD38E8C01, indexField = 4, parentIndexField = 1, fields = {
        @Db2Field(name = {"locX", "locY", "locZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "pathID", type = Db2Type.SHORT),
        @Db2Field(name = "continentID", type = Db2Type.SHORT),
        @Db2Field(name = "nodeIndex", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "delay", type = Db2Type.INT),
        @Db2Field(name = "arrivalEventID", type = Db2Type.SHORT),
        @Db2Field(name = "departureEventID", type = Db2Type.SHORT)
})
public class TaxiPathNode implements DbcEntity {
    @Column(name = "LocX")
    private Float locX;

    @Column(name = "LocY")
    private Float locY;

    @Column(name = "LocZ")
    private Float locZ;

    @Column(name = "PathID")
    private Short pathID;

    @Column(name = "ContinentID")
    private Short continentID;

    @Column(name = "NodeIndex")
    private Short nodeIndex;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "Delay")
    private Integer delay;

    @Column(name = "ArrivalEventID")
    private Integer arrivalEventID;

    @Column(name = "DepartureEventID")
    private Integer departureEventID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
