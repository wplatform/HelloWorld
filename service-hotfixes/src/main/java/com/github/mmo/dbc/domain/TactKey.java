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


@Table(name = "tact_key")
@Db2DataBind(name = "TactKey.db2", layoutHash = 0xF0F98B62, fields = {
        @Db2Field(name = {"key1", "key2", "key3", "key4", "key5", "key6", "key7", "key8", "key9", "key10", "key11", "key12", "key13", "key14", "key15", "key16"}, type = Db2Type.BYTE)
})
public class TactKey implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("Key1")
    private Short key1;

    @Column("Key2")
    private Short key2;

    @Column("Key3")
    private Short key3;

    @Column("Key4")
    private Short key4;

    @Column("Key5")
    private Short key5;

    @Column("Key6")
    private Short key6;

    @Column("Key7")
    private Short key7;

    @Column("Key8")
    private Short key8;

    @Column("Key9")
    private Short key9;

    @Column("Key10")
    private Short key10;

    @Column("Key11")
    private Short key11;

    @Column("Key12")
    private Short key12;

    @Column("Key13")
    private Short key13;

    @Column("Key14")
    private Short key14;

    @Column("Key15")
    private Short key15;

    @Column("Key16")
    private Short key16;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
