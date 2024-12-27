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
@Table(name = "pvp_talent")
@Db2DataBind(name = "PvpTalent.db2", layoutHash = 0x6EB51740, fields = {
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "spellID", type = Db2Type.INT),
        @Db2Field(name = "overridesSpellID", type = Db2Type.INT),
        @Db2Field(name = "actionBarSpellID", type = Db2Type.INT),
        @Db2Field(name = "tierID", type = Db2Type.INT),
        @Db2Field(name = "columnIndex", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "classID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "specID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "role", type = Db2Type.INT, signed = true)
})
public class PvpTalent implements DbcEntity {
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

    @Column(name = "ActionBarSpellID")
    private Integer actionBarSpellID;

    @Column(name = "TierID")
    private Integer tierID;

    @Column(name = "ColumnIndex")
    private Integer columnIndex;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "ClassID")
    private Integer classID;

    @Column(name = "SpecID")
    private Integer specID;

    @Column(name = "Role")
    private Integer role;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
