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
@Table(name = "spell_totems")
@Db2DataBind(name = "SpellTotems.db2", layoutHash = 0xEC0C4866, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"totem1", "totem2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"requiredTotemCategoryID1", "requiredTotemCategoryID2"}, type = Db2Type.SHORT)
})
public class SpellTotem implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "Totem1")
    private Integer totem1;

    @Column(name = "Totem2")
    private Integer totem2;

    @Column(name = "RequiredTotemCategoryID1")
    private Short requiredTotemCategoryID1;

    @Column(name = "RequiredTotemCategoryID2")
    private Short requiredTotemCategoryID2;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
