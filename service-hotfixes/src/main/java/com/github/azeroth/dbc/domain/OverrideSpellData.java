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


@Table(name = "override_spell_data")
@Db2DataBind(name = "OverrideSpellData.db2", layoutHash = 0x9417628C, fields = {
        @Db2Field(name = {"spells1", "spells2", "spells3", "spells4", "spells5", "spells6", "spells7", "spells8", "spells9", "spells10"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "playerActionBarFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class OverrideSpellData implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Spells1")
    private Integer spells1;

    @Column("Spells2")
    private Integer spells2;

    @Column("Spells3")
    private Integer spells3;

    @Column("Spells4")
    private Integer spells4;

    @Column("Spells5")
    private Integer spells5;

    @Column("Spells6")
    private Integer spells6;

    @Column("Spells7")
    private Integer spells7;

    @Column("Spells8")
    private Integer spells8;

    @Column("Spells9")
    private Integer spells9;

    @Column("Spells10")
    private Integer spells10;

    @Column("PlayerActionBarFileDataID")
    private Integer playerActionBarFileDataID;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
