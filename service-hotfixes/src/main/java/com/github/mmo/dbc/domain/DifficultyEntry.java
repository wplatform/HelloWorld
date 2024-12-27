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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "GroupSizeHealthCurveID")
    private Short groupSizeHealthCurveID;

    @Column(name = "GroupSizeDmgCurveID")
    private Short groupSizeDmgCurveID;

    @Column(name = "GroupSizeSpellPointsCurveID")
    private Short groupSizeSpellPointsCurveID;

    @Column(name = "FallbackDifficultyID")
    private Byte fallbackDifficultyID;

    @Column(name = "InstanceType")
    private Byte instanceType;

    @Column(name = "MinPlayers")
    private Byte minPlayers;

    @Column(name = "MaxPlayers")
    private Byte maxPlayers;

    @Column(name = "OldEnumValue")
    private Byte oldEnumValue;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "ToggleDifficultyID")
    private Byte toggleDifficultyID;

    @Column(name = "ItemContext")
    private Byte itemContext;

    @Column(name = "OrderIndex")
    private Byte orderIndex;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
