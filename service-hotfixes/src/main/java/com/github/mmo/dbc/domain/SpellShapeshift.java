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
@Table(name = "spell_shapeshift")
@Db2DataBind(name = "SpellShapeshift.db2", layoutHash = 0xA461C24D, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"shapeshiftExclude1", "shapeshiftExclude2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"shapeshiftMask1", "shapeshiftMask2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "stanceBarOrder", type = Db2Type.BYTE, signed = true)
})
public class SpellShapeshift implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "ShapeshiftExclude1")
    private Integer shapeshiftExclude1;

    @Column(name = "ShapeshiftExclude2")
    private Integer shapeshiftExclude2;

    @Column(name = "ShapeshiftMask1")
    private Integer shapeshiftMask1;

    @Column(name = "ShapeshiftMask2")
    private Integer shapeshiftMask2;

    @Column(name = "StanceBarOrder")
    private Byte stanceBarOrder;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
