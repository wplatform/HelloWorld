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
@Table(name = "specialization_spells")
@Db2DataBind(name = "SpecializationSpells.db2", layoutHash = 0xAE3436F3, indexField = 5, parentIndexField = 3, fields = {
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "overridesSpellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "specID", type = Db2Type.SHORT),
        @Db2Field(name = "displayOrder", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class SpecializationSpell implements DbcEntity {
    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "OverridesSpellID")
    private Integer overridesSpellID;

    @Column(name = "SpecID")
    private Short specID;

    @Column(name = "DisplayOrder")
    private Byte displayOrder;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
