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
@Table(name = "glyph_required_spec")
@Db2DataBind(name = "GlyphRequiredSpec.db2", layoutHash = 0xDD6481CE, parentIndexField = 1, fields = {
        @Db2Field(name = "chrSpecializationID", type = Db2Type.SHORT),
        @Db2Field(name = "glyphPropertiesID", type = Db2Type.SHORT)
})
public class GlyphRequiredSpec implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ChrSpecializationID")
    private Short chrSpecializationID;

    @Column(name = "GlyphPropertiesID")
    private Short glyphPropertiesID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}