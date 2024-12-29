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


@Table(name = "item_damage_one_hand")
@Db2DataBind(name = "ItemDamageOneHand.db2", layoutHash = 0xC2186F95, fields = {
        @Db2Field(name = {"quality1", "quality2", "quality3", "quality4", "quality5", "quality6", "quality7"}, type = Db2Type.FLOAT),
        @Db2Field(name = "itemLevel", type = Db2Type.SHORT)
})
public class ItemDamageOneHand implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Quality1")
    private Float quality1;

    @Column("Quality2")
    private Float quality2;

    @Column("Quality3")
    private Float quality3;

    @Column("Quality4")
    private Float quality4;

    @Column("Quality5")
    private Float quality5;

    @Column("Quality6")
    private Float quality6;

    @Column("Quality7")
    private Float quality7;

    @Column("ItemLevel")
    private Short itemLevel;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
