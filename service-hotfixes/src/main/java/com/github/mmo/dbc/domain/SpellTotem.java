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


@Getter
@Setter
@ToString


@Table(name = "spell_totems")
@Db2DataBind(name = "SpellTotems.db2", layoutHash = 0xEC0C4866, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"totem1", "totem2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"requiredTotemCategoryID1", "requiredTotemCategoryID2"}, type = Db2Type.SHORT)
})
public class SpellTotem implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("Totem1")
    private Integer totem1;

    @Column("Totem2")
    private Integer totem2;

    @Column("RequiredTotemCategoryID1")
    private Short requiredTotemCategoryID1;

    @Column("RequiredTotemCategoryID2")
    private Short requiredTotemCategoryID2;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
