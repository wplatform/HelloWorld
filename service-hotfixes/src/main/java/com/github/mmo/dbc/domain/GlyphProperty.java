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


@Table(name = "glyph_properties")
@Db2DataBind(name = "GlyphProperties.db2", layoutHash = 0xD0046829, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT),
        @Db2Field(name = "spellIconID", type = Db2Type.SHORT),
        @Db2Field(name = "glyphType", type = Db2Type.BYTE),
        @Db2Field(name = "glyphExclusiveCategoryID", type = Db2Type.BYTE)
})
public class GlyphProperty implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("SpellIconID")
    private Short spellIconID;

    @Column("GlyphType")
    private Byte glyphType;

    @Column("GlyphExclusiveCategoryID")
    private Byte glyphExclusiveCategoryID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
