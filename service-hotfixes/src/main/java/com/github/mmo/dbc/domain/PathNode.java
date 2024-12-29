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


@Table(name = "path_node")
@Db2DataBind(name = "PathNode.db2", layoutHash = 0x76615830, indexField = 0, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "locationID", type = Db2Type.INT),
        @Db2Field(name = "pathID", type = Db2Type.SHORT),
        @Db2Field(name = "sequence", type = Db2Type.SHORT)
})
public class PathNode implements DbcEntity {
    @Id

    @Column("ID")
    private  Integer id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("PathID")
    private Integer pathID;


    @Column("Sequence")
    private Short sequence;


    @Column("LocationID")
    private Integer locationID;

}