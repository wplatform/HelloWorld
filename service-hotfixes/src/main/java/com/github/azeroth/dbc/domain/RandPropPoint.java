package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "rand_prop_points")
@Db2DataBind(name = "RandPropPoints.db2", layoutHash = 0x4E2C0BCC, fields = {
        @Db2Field(name = {"epic1", "epic2", "epic3", "epic4", "epic5"}, type = Db2Type.INT),
        @Db2Field(name = {"superior1", "superior2", "superior3", "superior4", "superior5"}, type = Db2Type.INT),
        @Db2Field(name = {"good1", "good2", "good3", "good4", "good5"}, type = Db2Type.INT)
})
public class RandPropPoint implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Epic1")
    private Integer epic1;

    @Column("Epic2")
    private Integer epic2;

    @Column("Epic3")
    private Integer epic3;

    @Column("Epic4")
    private Integer epic4;

    @Column("Epic5")
    private Integer epic5;

    @Column("Superior1")
    private Integer superior1;

    @Column("Superior2")
    private Integer superior2;

    @Column("Superior3")
    private Integer superior3;

    @Column("Superior4")
    private Integer superior4;

    @Column("Superior5")
    private Integer superior5;

    @Column("Good1")
    private Integer good1;

    @Column("Good2")
    private Integer good2;

    @Column("Good3")
    private Integer good3;

    @Column("Good4")
    private Integer good4;

    @Column("Good5")
    private Integer good5;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
