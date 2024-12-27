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
@Table(name = "spell_visual_missile")
@Db2DataBind(name = "SpellVisualMissile.db2", layoutHash = 0x00BA67A5, indexField = 12, parentIndexField = 15, fields = {
        @Db2Field(name = "followGroundHeight", type = Db2Type.INT, signed = true),
        @Db2Field(name = "followGroundDropSpeed", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.INT),
        @Db2Field(name = {"castOffset1", "castOffset2", "castOffset3"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"impactOffset1", "impactOffset2", "impactOffset3"}, type = Db2Type.FLOAT),
        @Db2Field(name = "spellVisualEffectNameID", type = Db2Type.SHORT),
        @Db2Field(name = "castPositionerID", type = Db2Type.SHORT),
        @Db2Field(name = "impactPositionerID", type = Db2Type.SHORT),
        @Db2Field(name = "followGroundApproach", type = Db2Type.SHORT),
        @Db2Field(name = "spellMissileMotionID", type = Db2Type.SHORT),
        @Db2Field(name = "attachment", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "destinationAttachment", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "soundEntriesID", type = Db2Type.INT),
        @Db2Field(name = "animKitID", type = Db2Type.INT),
        @Db2Field(name = "spellVisualMissileSetID", type = Db2Type.SHORT)
})
public class SpellVisualMissile implements DbcEntity {
    @Column(name = "FollowGroundHeight")
    private Integer followGroundHeight;

    @Column(name = "FollowGroundDropSpeed")
    private Integer followGroundDropSpeed;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "CastOffset1")
    private Float castOffset1;

    @Column(name = "CastOffset2")
    private Float castOffset2;

    @Column(name = "CastOffset3")
    private Float castOffset3;

    @Column(name = "ImpactOffset1")
    private Float impactOffset1;

    @Column(name = "ImpactOffset2")
    private Float impactOffset2;

    @Column(name = "ImpactOffset3")
    private Float impactOffset3;

    @Column(name = "SpellVisualEffectNameID")
    private Short spellVisualEffectNameID;

    @Column(name = "CastPositionerID")
    private Short castPositionerID;

    @Column(name = "ImpactPositionerID")
    private Short impactPositionerID;

    @Column(name = "FollowGroundApproach")
    private Integer followGroundApproach;

    @Column(name = "SpellMissileMotionID")
    private Short spellMissileMotionID;

    @Column(name = "Attachment")
    private Byte attachment;

    @Column(name = "DestinationAttachment")
    private Byte destinationAttachment;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SoundEntriesID")
    private Integer soundEntriesID;

    @Column(name = "AnimKitID")
    private Integer animKitID;

    @Column(name = "SpellVisualMissileSetID")
    private Short spellVisualMissileSetID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
