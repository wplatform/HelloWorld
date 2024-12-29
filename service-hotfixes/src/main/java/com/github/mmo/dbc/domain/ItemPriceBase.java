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


@Table(name = "item_price_base")
@Db2DataBind(name = "ItemPriceBase.db2", layoutHash = 0x4BD234D7, fields = {
        @Db2Field(name = "armor", type = Db2Type.FLOAT),
        @Db2Field(name = "weapon", type = Db2Type.FLOAT),
        @Db2Field(name = "itemLevel", type = Db2Type.SHORT)
})
public class ItemPriceBase implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Armor")
    private Float armor;

    @Column("Weapon")
    private Float weapon;

    @Column("ItemLevel")
    private Short itemLevel;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
