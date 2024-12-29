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


@Table(name = "spell_visual")
@Db2DataBind(name = "SpellVisual.db2", layoutHash = 0x1C1301D2, fields = {
        @Db2Field(name = {"missileCastOffset1", "missileCastOffset2", "missileCastOffset3"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"missileImpactOffset1", "missileImpactOffset2", "missileImpactOffset3"}, type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellVisualMissileSetID", type = Db2Type.SHORT),
        @Db2Field(name = "missileDestinationAttachment", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "missileAttachment", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "missileCastPositionerID", type = Db2Type.INT),
        @Db2Field(name = "missileImpactPositionerID", type = Db2Type.INT),
        @Db2Field(name = "missileTargetingKit", type = Db2Type.INT, signed = true),
        @Db2Field(name = "animEventSoundID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "damageNumberDelay", type = Db2Type.SHORT),
        @Db2Field(name = "hostileSpellVisualID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "casterSpellVisualID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "lowViolenceSpellVisualID", type = Db2Type.INT, signed = true)
})
public class SpellVisual implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("MissileCastOffset1")
    private Float missileCastOffset1;

    @Column("MissileCastOffset2")
    private Float missileCastOffset2;

    @Column("MissileCastOffset3")
    private Float missileCastOffset3;

    @Column("MissileImpactOffset1")
    private Float missileImpactOffset1;

    @Column("MissileImpactOffset2")
    private Float missileImpactOffset2;

    @Column("MissileImpactOffset3")
    private Float missileImpactOffset3;

    @Column("Flags")
    private Integer flags;

    @Column("SpellVisualMissileSetID")
    private Short spellVisualMissileSetID;

    @Column("MissileDestinationAttachment")
    private Byte missileDestinationAttachment;

    @Column("MissileAttachment")
    private Byte missileAttachment;

    @Column("MissileCastPositionerID")
    private Integer missileCastPositionerID;

    @Column("MissileImpactPositionerID")
    private Integer missileImpactPositionerID;

    @Column("MissileTargetingKit")
    private Integer missileTargetingKit;

    @Column("AnimEventSoundID")
    private Integer animEventSoundID;

    @Column("DamageNumberDelay")
    private Short damageNumberDelay;

    @Column("HostileSpellVisualID")
    private Integer hostileSpellVisualID;

    @Column("CasterSpellVisualID")
    private Integer casterSpellVisualID;

    @Column("LowViolenceSpellVisualID")
    private Integer lowViolenceSpellVisualID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
