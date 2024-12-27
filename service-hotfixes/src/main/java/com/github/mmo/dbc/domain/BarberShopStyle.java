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
@Table(name = "barber_shop_style")
@Db2DataBind(name = "BarberShopStyle.db2", layoutHash = 0x670C71AE, indexField = 7, fields = {
        @Db2Field(name = "displayName", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "costModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "race", type = Db2Type.BYTE),
        @Db2Field(name = "sex", type = Db2Type.BYTE),
        @Db2Field(name = "data", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class BarberShopStyle implements DbcEntity {
    @Column(name = "DisplayName")
    private LocalizedString displayName;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "CostModifier")
    private Float costModifier;

    @Column(name = "Type")
    private Byte type;

    @Column(name = "Race")
    private Byte race;

    @Column(name = "Sex")
    private Byte sex;

    @Column(name = "Data")
    private Byte data;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
