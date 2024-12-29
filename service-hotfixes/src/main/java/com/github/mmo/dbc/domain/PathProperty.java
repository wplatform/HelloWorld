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


@Table(name = "path_property")
@Db2DataBind(name = "PathProperty.db2", layoutHash = 0x3D29C266, indexField = 3, fields = {
        @Db2Field(name = "value", type = Db2Type.INT),
        @Db2Field(name = "pathID", type = Db2Type.INT),
        @Db2Field(name = "propertyIndex", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class PathProperty implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("PathID")
    private Integer pathID;


    @Column("PropertyIndex")
    private Short propertyIndex;


    @Column("Value")
    private Integer value;

}