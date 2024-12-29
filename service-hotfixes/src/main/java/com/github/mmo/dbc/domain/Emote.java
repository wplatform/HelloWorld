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


@Table(name = "emotes")
@Db2DataBind(name = "Emotes.db2", layoutHash = 0x14467F27, fields = {
        @Db2Field(name = "raceMask", type = Db2Type.LONG, signed = true),
        @Db2Field(name = "emoteSlashCommand", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "emoteFlags", type = Db2Type.INT),
        @Db2Field(name = "spellVisualKitID", type = Db2Type.INT),
        @Db2Field(name = "animID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "emoteSpecProc", type = Db2Type.BYTE),
        @Db2Field(name = "classMask", type = Db2Type.INT, signed = true),
        @Db2Field(name = "emoteSpecProcParam", type = Db2Type.INT),
        @Db2Field(name = "eventSoundID", type = Db2Type.INT)
})
public class Emote implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("RaceMask")
    private Long raceMask;

    @Column("EmoteSlashCommand")
    private String emoteSlashCommand;

    @Column("EmoteFlags")
    private Integer emoteFlags;

    @Column("SpellVisualKitID")
    private Integer spellVisualKitID;

    @Column("AnimID")
    private Short animID;

    @Column("EmoteSpecProc")
    private Byte emoteSpecProc;

    @Column("ClassMask")
    private Integer classMask;

    @Column("EmoteSpecProcParam")
    private Integer emoteSpecProcParam;

    @Column("EventSoundID")
    private Integer eventSoundID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
