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


@Table(name = "cinematic_sequence")
@Db2DataBind(name = "CinematicSequences.db2", layoutHash = 0x470FDA8C, fields = {
        @Db2Field(name = "soundID", type = Db2Type.INT),
        @Db2Field(name = {"camera1", "camera2", "camera3", "camera4", "camera5", "camera6", "camera7", "camera8"}, type = Db2Type.SHORT)
})
public class CinematicSequence implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SoundID")
    private Integer soundID;

    @Column("Camera1")
    private Short camera1;

    @Column("Camera2")
    private Short camera2;

    @Column("Camera3")
    private Short camera3;

    @Column("Camera4")
    private Short camera4;

    @Column("Camera5")
    private Short camera5;

    @Column("Camera6")
    private Short camera6;

    @Column("Camera7")
    private Short camera7;

    @Column("Camera8")
    private Short camera8;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
