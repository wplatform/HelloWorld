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
@Table(name = "glyph_properties")
@Db2DataBind(name = "GlyphProperties.db2", layoutHash = 0xD0046829, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT),
        @Db2Field(name = "spellIconID", type = Db2Type.SHORT),
        @Db2Field(name = "glyphType", type = Db2Type.BYTE),
        @Db2Field(name = "glyphExclusiveCategoryID", type = Db2Type.BYTE)
})
public class GlyphProperty implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "SpellIconID")
    private Short spellIconID;

    @Column(name = "GlyphType")
    private Byte glyphType;

    @Column(name = "GlyphExclusiveCategoryID")
    private Byte glyphExclusiveCategoryID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
