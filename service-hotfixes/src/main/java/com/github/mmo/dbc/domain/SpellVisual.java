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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "MissileCastOffset1")
    private Float missileCastOffset1;

    @Column(name = "MissileCastOffset2")
    private Float missileCastOffset2;

    @Column(name = "MissileCastOffset3")
    private Float missileCastOffset3;

    @Column(name = "MissileImpactOffset1")
    private Float missileImpactOffset1;

    @Column(name = "MissileImpactOffset2")
    private Float missileImpactOffset2;

    @Column(name = "MissileImpactOffset3")
    private Float missileImpactOffset3;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "SpellVisualMissileSetID")
    private Short spellVisualMissileSetID;

    @Column(name = "MissileDestinationAttachment")
    private Byte missileDestinationAttachment;

    @Column(name = "MissileAttachment")
    private Byte missileAttachment;

    @Column(name = "MissileCastPositionerID")
    private Integer missileCastPositionerID;

    @Column(name = "MissileImpactPositionerID")
    private Integer missileImpactPositionerID;

    @Column(name = "MissileTargetingKit")
    private Integer missileTargetingKit;

    @Column(name = "AnimEventSoundID")
    private Integer animEventSoundID;

    @Column(name = "DamageNumberDelay")
    private Short damageNumberDelay;

    @Column(name = "HostileSpellVisualID")
    private Integer hostileSpellVisualID;

    @Column(name = "CasterSpellVisualID")
    private Integer casterSpellVisualID;

    @Column(name = "LowViolenceSpellVisualID")
    private Integer lowViolenceSpellVisualID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
