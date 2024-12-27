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
@Table(name = "talent")
@Db2DataBind(name = "Talent.db2", layoutHash = 0xE8850B48, fields = {
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "spellID", type = Db2Type.INT),
        @Db2Field(name = "overridesSpellID", type = Db2Type.INT),
        @Db2Field(name = "specID", type = Db2Type.SHORT),
        @Db2Field(name = "tierID", type = Db2Type.BYTE),
        @Db2Field(name = "columnIndex", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = {"categoryMask1", "categoryMask2"}, type = Db2Type.BYTE),
        @Db2Field(name = "classID", type = Db2Type.BYTE)
})
public class Talent implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "OverridesSpellID")
    private Integer overridesSpellID;

    @Column(name = "SpecID")
    private Short specID;

    @Column(name = "TierID")
    private Byte tierID;

    @Column(name = "ColumnIndex")
    private Byte columnIndex;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "CategoryMask1")
    private Byte categoryMask1;

    @Column(name = "CategoryMask2")
    private Byte categoryMask2;

    @Column(name = "ClassID")
    private Byte classID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
