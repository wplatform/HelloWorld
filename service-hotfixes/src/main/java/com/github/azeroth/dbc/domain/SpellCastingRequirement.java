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


@Table(name = "spell_casting_requirements")
@Db2DataBind(name = "SpellCastingRequirements.db2", layoutHash = 0xD8B56E5D, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "minFactionID", type = Db2Type.SHORT),
        @Db2Field(name = "requiredAreasID", type = Db2Type.SHORT),
        @Db2Field(name = "requiresSpellFocus", type = Db2Type.SHORT),
        @Db2Field(name = "facingCasterFlags", type = Db2Type.BYTE),
        @Db2Field(name = "minReputation", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "requiredAuraVision", type = Db2Type.BYTE)
})
public class SpellCastingRequirement implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("MinFactionID")
    private Short minFactionID;

    @Column("RequiredAreasID")
    private Short requiredAreasID;

    @Column("RequiresSpellFocus")
    private Short requiresSpellFocus;

    @Column("FacingCasterFlags")
    private Byte facingCasterFlags;

    @Column("MinReputation")
    private Byte minReputation;

    @Column("RequiredAuraVision")
    private Byte requiredAuraVision;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
