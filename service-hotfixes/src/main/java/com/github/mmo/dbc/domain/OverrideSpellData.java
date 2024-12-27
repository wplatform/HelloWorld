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
@Table(name = "override_spell_data")
@Db2DataBind(name = "OverrideSpellData.db2", layoutHash = 0x9417628C, fields = {
        @Db2Field(name = {"spells1", "spells2", "spells3", "spells4", "spells5", "spells6", "spells7", "spells8", "spells9", "spells10"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "playerActionBarFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class OverrideSpellData implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Spells1")
    private Integer spells1;

    @Column(name = "Spells2")
    private Integer spells2;

    @Column(name = "Spells3")
    private Integer spells3;

    @Column(name = "Spells4")
    private Integer spells4;

    @Column(name = "Spells5")
    private Integer spells5;

    @Column(name = "Spells6")
    private Integer spells6;

    @Column(name = "Spells7")
    private Integer spells7;

    @Column(name = "Spells8")
    private Integer spells8;

    @Column(name = "Spells9")
    private Integer spells9;

    @Column(name = "Spells10")
    private Integer spells10;

    @Column(name = "PlayerActionBarFileDataID")
    private Integer playerActionBarFileDataID;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
