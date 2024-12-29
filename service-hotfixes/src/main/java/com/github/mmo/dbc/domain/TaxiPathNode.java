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


@Getter
@Setter
@ToString


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
    @Column("LocX")
    private Float locX;

    @Column("LocY")
    private Float locY;

    @Column("LocZ")
    private Float locZ;

    @Column("PathID")
    private Short pathID;

    @Column("ContinentID")
    private Short continentID;

    @Column("NodeIndex")
    private Short nodeIndex;

    @Id

    @Column("ID")
    private int id;

    @Column("Flags")
    private Byte flags;

    @Column("Delay")
    private Integer delay;

    @Column("ArrivalEventID")
    private Integer arrivalEventID;

    @Column("DepartureEventID")
    private Integer departureEventID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
