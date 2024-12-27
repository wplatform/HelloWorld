package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
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
@Table(name = "broadcast_text")
@Db2DataBind(name = "BroadcastText.db2", layoutHash = 0x51BF0C33, fields = {
        @Db2Field(name = "text", type = Db2Type.STRING),
        @Db2Field(name = "text1", type = Db2Type.STRING),
        @Db2Field(name = {"emoteID1", "emoteID2", "emoteID3"}, type = Db2Type.SHORT),
        @Db2Field(name = {"emoteDelay1", "emoteDelay2", "emoteDelay3"}, type = Db2Type.SHORT),
        @Db2Field(name = "emotesID", type = Db2Type.SHORT),
        @Db2Field(name = "languageID", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "conditionID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"soundEntriesID1", "soundEntriesID2"}, type = Db2Type.INT)
})
public class BroadcastText implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Text")
    private LocalizedString text;

    @Column(name = "Text1")
    private LocalizedString text1;

    @Column(name = "EmoteID1")
    private Short emoteID1;

    @Column(name = "EmoteID2")
    private Short emoteID2;

    @Column(name = "EmoteID3")
    private Short emoteID3;

    @Column(name = "EmoteDelay1")
    private Short emoteDelay1;

    @Column(name = "EmoteDelay2")
    private Short emoteDelay2;

    @Column(name = "EmoteDelay3")
    private Short emoteDelay3;

    @Column(name = "EmotesID")
    private Short emotesID;

    @Column(name = "LanguageID")
    private Byte languageID;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "ConditionID")
    private Integer conditionID;

    @Column(name = "SoundEntriesID1")
    private Integer soundEntriesID1;

    @Column(name = "SoundEntriesID2")
    private Integer soundEntriesID2;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
