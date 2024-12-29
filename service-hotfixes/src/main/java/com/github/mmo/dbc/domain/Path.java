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
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "path")
@Db2DataBind(name = "Path.db2", layoutHash = 0x5017579F, fields = {
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "splineType", type = Db2Type.BYTE),
        @Db2Field(name = "red", type = Db2Type.BYTE),
        @Db2Field(name = "green", type = Db2Type.BYTE),
        @Db2Field(name = "blue", type = Db2Type.BYTE),
        @Db2Field(name = "alpha", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class Path implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("Type")
    private Short type;


    @Column("SplineType")
    private Short splineType;


    @Column("Red")
    private Short red;


    @Column("Green")
    private Short green;


    @Column("Blue")
    private Short blue;


    @Column("Alpha")
    private Short alpha;


    @Column("Flags")
    private Short flags;

}