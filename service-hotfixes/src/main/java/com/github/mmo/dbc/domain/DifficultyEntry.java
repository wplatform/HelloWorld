package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.EnumFlag;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import com.github.mmo.dbc.defines.DifficultyFlag;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "difficulty")
@Db2DataBind(name = "Difficulty.db2", layoutHash = 0x92302BB8, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "groupSizeHealthCurveID", type = Db2Type.SHORT),
        @Db2Field(name = "groupSizeDmgCurveID", type = Db2Type.SHORT),
        @Db2Field(name = "groupSizeSpellPointsCurveID", type = Db2Type.SHORT),
        @Db2Field(name = "fallbackDifficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "instanceType", type = Db2Type.BYTE),
        @Db2Field(name = "minPlayers", type = Db2Type.BYTE),
        @Db2Field(name = "maxPlayers", type = Db2Type.BYTE),
        @Db2Field(name = "oldEnumValue", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "toggleDifficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "itemContext", type = Db2Type.BYTE),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE)
})
public class DifficultyEntry implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("GroupSizeHealthCurveID")
    private Short groupSizeHealthCurveID;

    @Column("GroupSizeDmgCurveID")
    private Short groupSizeDmgCurveID;

    @Column("GroupSizeSpellPointsCurveID")
    private Short groupSizeSpellPointsCurveID;

    @Column("FallbackDifficultyID")
    private Byte fallbackDifficultyID;

    @Column("InstanceType")
    private Byte instanceType;

    @Column("MinPlayers")
    private Byte minPlayers;

    @Column("MaxPlayers")
    private Byte maxPlayers;

    @Column("OldEnumValue")
    private Byte oldEnumValue;

    @Column("Flags")
    private Short flags;

    @Column("ToggleDifficultyID")
    private Byte toggleDifficultyID;

    @Column("ItemContext")
    private Byte itemContext;

    @Column("OrderIndex")
    private Byte orderIndex;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    public EnumFlag<DifficultyFlag> flags() {
        return EnumFlag.of(DifficultyFlag.class, flags);
    }

}
