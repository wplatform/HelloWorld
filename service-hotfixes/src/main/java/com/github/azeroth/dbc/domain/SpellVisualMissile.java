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
    @Column("FollowGroundHeight")
    private Integer followGroundHeight;

    @Column("FollowGroundDropSpeed")
    private Integer followGroundDropSpeed;

    @Column("Flags")
    private Integer flags;

    @Column("CastOffset1")
    private Float castOffset1;

    @Column("CastOffset2")
    private Float castOffset2;

    @Column("CastOffset3")
    private Float castOffset3;

    @Column("ImpactOffset1")
    private Float impactOffset1;

    @Column("ImpactOffset2")
    private Float impactOffset2;

    @Column("ImpactOffset3")
    private Float impactOffset3;

    @Column("SpellVisualEffectNameID")
    private Short spellVisualEffectNameID;

    @Column("CastPositionerID")
    private Short castPositionerID;

    @Column("ImpactPositionerID")
    private Short impactPositionerID;

    @Column("FollowGroundApproach")
    private Integer followGroundApproach;

    @Column("SpellMissileMotionID")
    private Short spellMissileMotionID;

    @Column("Attachment")
    private Byte attachment;

    @Column("DestinationAttachment")
    private Byte destinationAttachment;

    @Id
    
    @Column("ID")
    private int id;

    @Column("SoundEntriesID")
    private Integer soundEntriesID;

    @Column("AnimKitID")
    private Integer animKitID;

    @Column("SpellVisualMissileSetID")
    private Short spellVisualMissileSetID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
