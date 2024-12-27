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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "MinFactionID")
    private Short minFactionID;

    @Column(name = "RequiredAreasID")
    private Short requiredAreasID;

    @Column(name = "RequiresSpellFocus")
    private Short requiresSpellFocus;

    @Column(name = "FacingCasterFlags")
    private Byte facingCasterFlags;

    @Column(name = "MinReputation")
    private Byte minReputation;

    @Column(name = "RequiredAuraVision")
    private Byte requiredAuraVision;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
