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
@Table(name = "rand_prop_points")
@Db2DataBind(name = "RandPropPoints.db2", layoutHash = 0x4E2C0BCC, fields = {
        @Db2Field(name = {"epic1", "epic2", "epic3", "epic4", "epic5"}, type = Db2Type.INT),
        @Db2Field(name = {"superior1", "superior2", "superior3", "superior4", "superior5"}, type = Db2Type.INT),
        @Db2Field(name = {"good1", "good2", "good3", "good4", "good5"}, type = Db2Type.INT)
})
public class RandPropPoint implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Epic1")
    private Integer epic1;

    @Column(name = "Epic2")
    private Integer epic2;

    @Column(name = "Epic3")
    private Integer epic3;

    @Column(name = "Epic4")
    private Integer epic4;

    @Column(name = "Epic5")
    private Integer epic5;

    @Column(name = "Superior1")
    private Integer superior1;

    @Column(name = "Superior2")
    private Integer superior2;

    @Column(name = "Superior3")
    private Integer superior3;

    @Column(name = "Superior4")
    private Integer superior4;

    @Column(name = "Superior5")
    private Integer superior5;

    @Column(name = "Good1")
    private Integer good1;

    @Column(name = "Good2")
    private Integer good2;

    @Column(name = "Good3")
    private Integer good3;

    @Column(name = "Good4")
    private Integer good4;

    @Column(name = "Good5")
    private Integer good5;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
