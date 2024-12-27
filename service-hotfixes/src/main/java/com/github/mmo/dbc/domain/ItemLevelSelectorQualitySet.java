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
@Table(name = "item_level_selector_quality_set")
@Db2DataBind(name = "ItemLevelSelectorQualitySet.db2", layoutHash = 0x20055BA8, fields = {
        @Db2Field(name = "ilvlRare", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "ilvlEpic", type = Db2Type.SHORT, signed = true)
})
public class ItemLevelSelectorQualitySet implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "IlvlRare")
    private Short ilvlRare;

    @Column(name = "IlvlEpic")
    private Short ilvlEpic;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
