package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
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
@Table(name = "criteria_tree")
@Db2DataBind(name = "CriteriaTree.db2", layoutHash = 0x0A1B99C2, fields = {
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "amount", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "operator", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "criteriaID", type = Db2Type.INT),
        @Db2Field(name = "parent", type = Db2Type.INT),
        @Db2Field(name = "orderIndex", type = Db2Type.INT, signed = true)
})
public class CriteriaTree implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "Amount")
    private Integer amount;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "Operator")
    private Byte operator;

    @Column(name = "CriteriaID")
    private Integer criteriaID;

    @Column(name = "Parent")
    private Integer parent;

    @Column(name = "OrderIndex")
    private Integer orderIndex;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
