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
@Table(name = "power_type")
@Db2DataBind(name = "PowerType.db2", layoutHash = 0x0C3844E1, fields = {
        @Db2Field(name = "nameGlobalStringTag", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "costGlobalStringTag", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "regenPeace", type = Db2Type.FLOAT),
        @Db2Field(name = "regenCombat", type = Db2Type.FLOAT),
        @Db2Field(name = "maxBasePower", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "regenInterruptTimeMS", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "powerTypeEnum", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minPower", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "centerPower", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "defaultPower", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "displayModifier", type = Db2Type.BYTE, signed = true)
})
public class PowerType implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "NameGlobalStringTag")
    private String nameGlobalStringTag;

    @Column(name = "CostGlobalStringTag")
    private String costGlobalStringTag;

    @Column(name = "RegenPeace")
    private Float regenPeace;

    @Column(name = "RegenCombat")
    private Float regenCombat;

    @Column(name = "MaxBasePower")
    private Short maxBasePower;

    @Column(name = "RegenInterruptTimeMS")
    private Short regenInterruptTimeMS;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "PowerTypeEnum")
    private Byte powerTypeEnum;

    @Column(name = "MinPower")
    private Byte minPower;

    @Column(name = "CenterPower")
    private Byte centerPower;

    @Column(name = "DefaultPower")
    private Byte defaultPower;

    @Column(name = "DisplayModifier")
    private Byte displayModifier;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
