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


@Table(name = "spell_shapeshift")
@Db2DataBind(name = "SpellShapeshift.db2", layoutHash = 0xA461C24D, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"shapeshiftExclude1", "shapeshiftExclude2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"shapeshiftMask1", "shapeshiftMask2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "stanceBarOrder", type = Db2Type.BYTE, signed = true)
})
public class SpellShapeshift implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("ShapeshiftExclude1")
    private Integer shapeshiftExclude1;

    @Column("ShapeshiftExclude2")
    private Integer shapeshiftExclude2;

    @Column("ShapeshiftMask1")
    private Integer shapeshiftMask1;

    @Column("ShapeshiftMask2")
    private Integer shapeshiftMask2;

    @Column("StanceBarOrder")
    private Byte stanceBarOrder;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
