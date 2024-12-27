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
@Table(name = "spell_class_options")
@Db2DataBind(name = "SpellClassOptions.db2", layoutHash = 0x80FBD67A, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"spellClassMask1", "spellClassMask2", "spellClassMask3", "spellClassMask4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellClassSet", type = Db2Type.BYTE),
        @Db2Field(name = "modalNextSpell", type = Db2Type.INT)
})
public class SpellClassOption implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "SpellClassMask1")
    private Integer spellClassMask1;

    @Column(name = "SpellClassMask2")
    private Integer spellClassMask2;

    @Column(name = "SpellClassMask3")
    private Integer spellClassMask3;

    @Column(name = "SpellClassMask4")
    private Integer spellClassMask4;

    @Column(name = "SpellClassSet")
    private Byte spellClassSet;

    @Column(name = "ModalNextSpell")
    private Integer modalNextSpell;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
