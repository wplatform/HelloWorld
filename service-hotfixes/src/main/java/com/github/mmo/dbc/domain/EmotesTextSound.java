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
@Table(name = "emotes_text_sound")
@Db2DataBind(name = "EmotesTextSound.db2", layoutHash = 0x6DFAF9BC, parentIndexField = 4, fields = {
        @Db2Field(name = "raceID", type = Db2Type.BYTE),
        @Db2Field(name = "sexID", type = Db2Type.BYTE),
        @Db2Field(name = "classID", type = Db2Type.BYTE),
        @Db2Field(name = "soundID", type = Db2Type.INT),
        @Db2Field(name = "emotesTextID", type = Db2Type.SHORT)
})
public class EmotesTextSound implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "RaceID")
    private Byte raceID;

    @Column(name = "SexID")
    private Byte sexID;

    @Column(name = "ClassID")
    private Byte classID;

    @Column(name = "SoundID")
    private Integer soundID;

    @Column(name = "EmotesTextID")
    private Short emotesTextID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
