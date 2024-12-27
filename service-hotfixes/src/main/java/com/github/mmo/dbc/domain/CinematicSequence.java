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
@Table(name = "cinematic_sequence")
@Db2DataBind(name = "CinematicSequences.db2", layoutHash = 0x470FDA8C, fields = {
        @Db2Field(name = "soundID", type = Db2Type.INT),
        @Db2Field(name = {"camera1", "camera2", "camera3", "camera4", "camera5", "camera6", "camera7", "camera8"}, type = Db2Type.SHORT)
})
public class CinematicSequence implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SoundID")
    private Integer soundID;

    @Column(name = "Camera1")
    private Short camera1;

    @Column(name = "Camera2")
    private Short camera2;

    @Column(name = "Camera3")
    private Short camera3;

    @Column(name = "Camera4")
    private Short camera4;

    @Column(name = "Camera5")
    private Short camera5;

    @Column(name = "Camera6")
    private Short camera6;

    @Column(name = "Camera7")
    private Short camera7;

    @Column(name = "Camera8")
    private Short camera8;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
