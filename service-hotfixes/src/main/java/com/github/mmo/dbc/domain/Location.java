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
@Table(name = "location")
@Db2DataBind(name = "Location.db2", layoutHash = 0xBBC1BE7A, fields = {
        @Db2Field(name = {"posX", "posY", "posZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"rot1", "rot2", "rot3"}, type = Db2Type.FLOAT)
})
public class Location implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @ColumnDefault("0")
    @Column(name = "PosX", nullable = false)
    private Float posX;

    @ColumnDefault("0")
    @Column(name = "PosY", nullable = false)
    private Float posY;

    @ColumnDefault("0")
    @Column(name = "PosZ", nullable = false)
    private Float posZ;

    @ColumnDefault("0")
    @Column(name = "Rot1", nullable = false)
    private Float rot1;

    @ColumnDefault("0")
    @Column(name = "Rot2", nullable = false)
    private Float rot2;

    @ColumnDefault("0")
    @Column(name = "Rot3", nullable = false)
    private Float rot3;

}