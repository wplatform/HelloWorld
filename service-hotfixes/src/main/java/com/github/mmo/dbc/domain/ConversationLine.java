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


@Table(name = "conversation_line")
@Db2DataBind(name = "ConversationLine.db2", layoutHash = 0x032B137B, fields = {
        @Db2Field(name = "broadcastTextID", type = Db2Type.INT),
        @Db2Field(name = "spellVisualKitID", type = Db2Type.INT),
        @Db2Field(name = "additionalDuration", type = Db2Type.INT, signed = true),
        @Db2Field(name = "nextConversationLineID", type = Db2Type.SHORT),
        @Db2Field(name = "animKitID", type = Db2Type.SHORT),
        @Db2Field(name = "speechType", type = Db2Type.BYTE),
        @Db2Field(name = "startAnimation", type = Db2Type.BYTE),
        @Db2Field(name = "endAnimation", type = Db2Type.BYTE)
})
public class ConversationLine implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("BroadcastTextID")
    private Integer broadcastTextID;

    @Column("SpellVisualKitID")
    private Integer spellVisualKitID;

    @Column("AdditionalDuration")
    private Integer additionalDuration;

    @Column("NextConversationLineID")
    private Short nextConversationLineID;

    @Column("AnimKitID")
    private Short animKitID;

    @Column("SpeechType")
    private Byte speechType;

    @Column("StartAnimation")
    private Short startAnimation;

    @Column("EndAnimation")
    private Short endAnimation;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
