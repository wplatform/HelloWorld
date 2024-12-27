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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "spell_reagents_currency")
@Db2DataBind(name = "SpellReagentsCurrency.db2", layoutHash = 0xA7C3638C, parentIndexField = 0, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "currencyTypesID", type = Db2Type.INT),
        @Db2Field(name = "currencyCount", type = Db2Type.INT),
        @Db2Field(name = "", type = Db2Type.INT, signed = true)
})
public class SpellReagentsCurrency implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private  Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @ColumnDefault("'0'")
    @Column(name = "SpellID", columnDefinition = "int UNSIGNED not null")
    private Long spellID;

    @ColumnDefault("'0'")
    @Column(name = "CurrencyTypesID", columnDefinition = "smallint UNSIGNED not null")
    private Integer currencyTypesID;

    @ColumnDefault("'0'")
    @Column(name = "CurrencyCount", columnDefinition = "smallint UNSIGNED not null")
    private Integer currencyCount;

}