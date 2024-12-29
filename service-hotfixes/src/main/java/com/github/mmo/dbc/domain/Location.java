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


@Table(name = "location")
@Db2DataBind(name = "Location.db2", layoutHash = 0xBBC1BE7A, fields = {
        @Db2Field(name = {"posX", "posY", "posZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"rot1", "rot2", "rot3"}, type = Db2Type.FLOAT)
})
public class Location implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("PosX")
    private Float posX;


    @Column("PosY")
    private Float posY;


    @Column("PosZ")
    private Float posZ;


    @Column("Rot1")
    private Float rot1;


    @Column("Rot2")
    private Float rot2;


    @Column("Rot3")
    private Float rot3;

}