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
@Table(name = "item_limit_category_condition")
@Db2DataBind(name = "ItemLimitCategoryCondition.db2", layoutHash = 0xDE8EAD49, parentIndexField = 2, fields = {
        @Db2Field(name = "addQuantity", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT),
        @Db2Field(name = "parentItemLimitCategoryID", type = Db2Type.INT, signed = true)
})
public class ItemLimitCategoryCondition implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "AddQuantity")
    private Byte addQuantity;

    @Column(name = "PlayerConditionID")
    private Integer playerConditionID;

    @Column(name = "ParentItemLimitCategoryID")
    private Integer parentItemLimitCategoryID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
