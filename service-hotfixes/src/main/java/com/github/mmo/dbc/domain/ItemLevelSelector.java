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
@Table(name = "item_level_selector")
@Db2DataBind(name = "ItemLevelSelector.db2", layoutHash = 0x8143060E, fields = {
        @Db2Field(name = "minItemLevel", type = Db2Type.SHORT),
        @Db2Field(name = "itemLevelSelectorQualitySetID", type = Db2Type.SHORT)
})
public class ItemLevelSelector implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "MinItemLevel")
    private Short minItemLevel;

    @Column(name = "ItemLevelSelectorQualitySetID")
    private Short itemLevelSelectorQualitySetID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
