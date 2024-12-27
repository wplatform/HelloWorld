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
@Table(name = "item_armor_total")
@Db2DataBind(name = "ItemArmorTotal.db2", layoutHash = 0x45C396DD, fields = {
        @Db2Field(name = "cloth", type = Db2Type.FLOAT),
        @Db2Field(name = "leather", type = Db2Type.FLOAT),
        @Db2Field(name = "mail", type = Db2Type.FLOAT),
        @Db2Field(name = "plate", type = Db2Type.FLOAT),
        @Db2Field(name = "itemLevel", type = Db2Type.SHORT, signed = true)
})
public class ItemArmorTotal implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Cloth")
    private Float cloth;

    @Column(name = "Leather")
    private Float leather;

    @Column(name = "Mail")
    private Float mail;

    @Column(name = "Plate")
    private Float plate;

    @Column(name = "ItemLevel")
    private Short itemLevel;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
