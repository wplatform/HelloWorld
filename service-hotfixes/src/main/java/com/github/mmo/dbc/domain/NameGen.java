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


@Table(name = "name_gen")
@Db2DataBind(name = "NameGen.db2", layoutHash = 0x2EF936CD, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "raceID", type = Db2Type.BYTE),
        @Db2Field(name = "sex", type = Db2Type.BYTE)
})
public class NameGen implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private String name;

    @Column("RaceID")
    private Byte raceID;

    @Column("Sex")
    private Byte sex;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
