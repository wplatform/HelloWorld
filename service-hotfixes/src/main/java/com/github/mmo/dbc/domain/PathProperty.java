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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "path_property")
@Db2DataBind(name = "PathProperty.db2", layoutHash = 0x3D29C266, indexField = 3, fields = {
        @Db2Field(name = "value", type = Db2Type.INT),
        @Db2Field(name = "pathID", type = Db2Type.INT),
        @Db2Field(name = "propertyIndex", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class PathProperty implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @ColumnDefault("'0'")
    @Column(name = "PathID", columnDefinition = "smallint UNSIGNED not null")
    private Integer pathID;

    @ColumnDefault("'0'")
    @Column(name = "PropertyIndex", columnDefinition = "tinyint UNSIGNED not null")
    private Short propertyIndex;

    @ColumnDefault("0")
    @Column(name = "Value", nullable = false)
    private Integer value;

}