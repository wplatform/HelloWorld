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
@Table(name = "item_random_suffix")
@Db2DataBind(name = "ItemRandomSuffix.db2", layoutHash = 0x95CAB825, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = {"enchantment1", "enchantment2", "enchantment3", "enchantment4", "enchantment5"}, type = Db2Type.SHORT),
        @Db2Field(name = {"allocationPct1", "allocationPct2", "allocationPct3", "allocationPct4", "allocationPct5"}, type = Db2Type.SHORT)
})
public class ItemRandomSuffix implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Enchantment1")
    private Short enchantment1;

    @Column(name = "Enchantment2")
    private Short enchantment2;

    @Column(name = "Enchantment3")
    private Short enchantment3;

    @Column(name = "Enchantment4")
    private Short enchantment4;

    @Column(name = "Enchantment5")
    private Short enchantment5;

    @Column(name = "AllocationPct1")
    private Short allocationPct1;

    @Column(name = "AllocationPct2")
    private Short allocationPct2;

    @Column(name = "AllocationPct3")
    private Short allocationPct3;

    @Column(name = "AllocationPct4")
    private Short allocationPct4;

    @Column(name = "AllocationPct5")
    private Short allocationPct5;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
