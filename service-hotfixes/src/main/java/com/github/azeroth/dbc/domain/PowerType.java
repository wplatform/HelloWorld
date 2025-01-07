package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


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
public  class PowerType implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("NameGlobalStringTag")
    private String nameGlobalStringTag;

    @Column("CostGlobalStringTag")
    private String costGlobalStringTag;

    @Column("RegenPeace")
    private Float regenPeace;

    @Column("RegenCombat")
    private Float regenCombat;

    @Column("MaxBasePower")
    private Short maxBasePower;

    @Column("RegenInterruptTimeMS")
    private Short regenInterruptTimeMS;

    @Column("Flags")
    private Short flags;

    @Column("PowerTypeEnum")
    private Byte powerTypeEnum;

    @Column("MinPower")
    private Byte minPower;

    @Column("CenterPower")
    private Byte centerPower;

    @Column("DefaultPower")
    private Byte defaultPower;

    @Column("DisplayModifier")
    private Byte displayModifier;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
