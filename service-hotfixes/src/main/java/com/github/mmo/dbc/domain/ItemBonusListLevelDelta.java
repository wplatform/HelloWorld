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
@Table(name = "item_bonus_list_level_delta")
@Db2DataBind(name = "ItemBonusListLevelDelta.db2", layoutHash = 0xDFBF5AC9, indexField = 1, fields = {
        @Db2Field(name = "itemLevelDelta", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class ItemBonusListLevelDelta implements DbcEntity {
    @Column(name = "ItemLevelDelta")
    private Short itemLevelDelta;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
