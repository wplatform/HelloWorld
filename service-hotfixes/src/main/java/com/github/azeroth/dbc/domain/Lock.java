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


@Table(name = "lock")
@Db2DataBind(name = "Lock.db2", layoutHash = 0xDAC7F42F, fields = {
        @Db2Field(name = {"index1", "index2", "index3", "index4", "index5", "index6", "index7", "index8"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"skill1", "skill2", "skill3", "skill4", "skill5", "skill6", "skill7", "skill8"}, type = Db2Type.SHORT),
        @Db2Field(name = {"type1", "type2", "type3", "type4", "type5", "type6", "type7", "type8"}, type = Db2Type.BYTE),
        @Db2Field(name = {"action1", "action2", "action3", "action4", "action5", "action6", "action7", "action8"}, type = Db2Type.BYTE)
})
public class Lock implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Index1")
    private Integer index1;

    @Column("Index2")
    private Integer index2;

    @Column("Index3")
    private Integer index3;

    @Column("Index4")
    private Integer index4;

    @Column("Index5")
    private Integer index5;

    @Column("Index6")
    private Integer index6;

    @Column("Index7")
    private Integer index7;

    @Column("Index8")
    private Integer index8;

    @Column("Skill1")
    private Short skill1;

    @Column("Skill2")
    private Short skill2;

    @Column("Skill3")
    private Short skill3;

    @Column("Skill4")
    private Short skill4;

    @Column("Skill5")
    private Short skill5;

    @Column("Skill6")
    private Short skill6;

    @Column("Skill7")
    private Short skill7;

    @Column("Skill8")
    private Short skill8;

    @Column("Type1")
    private Byte type1;

    @Column("Type2")
    private Byte type2;

    @Column("Type3")
    private Byte type3;

    @Column("Type4")
    private Byte type4;

    @Column("Type5")
    private Byte type5;

    @Column("Type6")
    private Byte type6;

    @Column("Type7")
    private Byte type7;

    @Column("Type8")
    private Byte type8;

    @Column("Action1")
    private Byte action1;

    @Column("Action2")
    private Byte action2;

    @Column("Action3")
    private Byte action3;

    @Column("Action4")
    private Byte action4;

    @Column("Action5")
    private Byte action5;

    @Column("Action6")
    private Byte action6;

    @Column("Action7")
    private Byte action7;

    @Column("Action8")
    private Byte action8;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
