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
@Table(name = "item_bonus")
@Db2DataBind(name = "ItemBonus.db2", layoutHash = 0xE12FB1A0, parentIndexField = 1, fields = {
        @Db2Field(name = {"value1", "value2", "value3"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "parentItemBonusListID", type = Db2Type.SHORT),
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE)
})
public class ItemBonus implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Value1")
    private Integer value1;

    @Column(name = "Value2")
    private Integer value2;

    @Column(name = "Value3")
    private Integer value3;

    @Column(name = "ParentItemBonusListID")
    private Short parentItemBonusListID;

    @Column(name = "Type")
    private Byte type;

    @Column(name = "OrderIndex")
    private Byte orderIndex;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
