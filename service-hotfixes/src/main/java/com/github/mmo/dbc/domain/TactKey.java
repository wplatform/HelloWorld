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
@Table(name = "tact_key")
@Db2DataBind(name = "TactKey.db2", layoutHash = 0xF0F98B62, fields = {
        @Db2Field(name = {"key1", "key2", "key3", "key4", "key5", "key6", "key7", "key8", "key9", "key10", "key11", "key12", "key13", "key14", "key15", "key16"}, type = Db2Type.BYTE)
})
public class TactKey implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Key1")
    private Short key1;

    @Column(name = "Key2")
    private Short key2;

    @Column(name = "Key3")
    private Short key3;

    @Column(name = "Key4")
    private Short key4;

    @Column(name = "Key5")
    private Short key5;

    @Column(name = "Key6")
    private Short key6;

    @Column(name = "Key7")
    private Short key7;

    @Column(name = "Key8")
    private Short key8;

    @Column(name = "Key9")
    private Short key9;

    @Column(name = "Key10")
    private Short key10;

    @Column(name = "Key11")
    private Short key11;

    @Column(name = "Key12")
    private Short key12;

    @Column(name = "Key13")
    private Short key13;

    @Column(name = "Key14")
    private Short key14;

    @Column(name = "Key15")
    private Short key15;

    @Column(name = "Key16")
    private Short key16;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
