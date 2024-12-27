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
@Table(name = "lock")
@Db2DataBind(name = "Lock.db2", layoutHash = 0xDAC7F42F, fields = {
        @Db2Field(name = {"index1", "index2", "index3", "index4", "index5", "index6", "index7", "index8"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"skill1", "skill2", "skill3", "skill4", "skill5", "skill6", "skill7", "skill8"}, type = Db2Type.SHORT),
        @Db2Field(name = {"type1", "type2", "type3", "type4", "type5", "type6", "type7", "type8"}, type = Db2Type.BYTE),
        @Db2Field(name = {"action1", "action2", "action3", "action4", "action5", "action6", "action7", "action8"}, type = Db2Type.BYTE)
})
public class Lock implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Index1")
    private Integer index1;

    @Column(name = "Index2")
    private Integer index2;

    @Column(name = "Index3")
    private Integer index3;

    @Column(name = "Index4")
    private Integer index4;

    @Column(name = "Index5")
    private Integer index5;

    @Column(name = "Index6")
    private Integer index6;

    @Column(name = "Index7")
    private Integer index7;

    @Column(name = "Index8")
    private Integer index8;

    @Column(name = "Skill1")
    private Short skill1;

    @Column(name = "Skill2")
    private Short skill2;

    @Column(name = "Skill3")
    private Short skill3;

    @Column(name = "Skill4")
    private Short skill4;

    @Column(name = "Skill5")
    private Short skill5;

    @Column(name = "Skill6")
    private Short skill6;

    @Column(name = "Skill7")
    private Short skill7;

    @Column(name = "Skill8")
    private Short skill8;

    @Column(name = "Type1")
    private Byte type1;

    @Column(name = "Type2")
    private Byte type2;

    @Column(name = "Type3")
    private Byte type3;

    @Column(name = "Type4")
    private Byte type4;

    @Column(name = "Type5")
    private Byte type5;

    @Column(name = "Type6")
    private Byte type6;

    @Column(name = "Type7")
    private Byte type7;

    @Column(name = "Type8")
    private Byte type8;

    @Column(name = "Action1")
    private Byte action1;

    @Column(name = "Action2")
    private Byte action2;

    @Column(name = "Action3")
    private Byte action3;

    @Column(name = "Action4")
    private Byte action4;

    @Column(name = "Action5")
    private Byte action5;

    @Column(name = "Action6")
    private Byte action6;

    @Column(name = "Action7")
    private Byte action7;

    @Column(name = "Action8")
    private Byte action8;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
