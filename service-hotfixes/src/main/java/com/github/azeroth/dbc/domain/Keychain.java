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


@Table(name = "keychain")
@Db2DataBind(name = "Keychain.db2", layoutHash = 0x5B214E82, fields = {
        @Db2Field(name = {"key1", "key2", "key3", "key4", "key5", "key6", "key7", "key8", "key9", "key10", "key11", "key12", "key13", "key14", "key15", "key16", "key17", "key18", "key19", "key20", "key21", "key22", "key23", "key24", "key25", "key26", "key27", "key28", "key29", "key30", "key31", "key32"}, type = Db2Type.BYTE)
})
public class Keychain implements DbcEntity {
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

    @Column("Key17")
    private Short key17;

    @Column("Key18")
    private Short key18;

    @Column("Key19")
    private Short key19;

    @Column("Key20")
    private Short key20;

    @Column("Key21")
    private Short key21;

    @Column("Key22")
    private Short key22;

    @Column("Key23")
    private Short key23;

    @Column("Key24")
    private Short key24;

    @Column("Key25")
    private Short key25;

    @Column("Key26")
    private Short key26;

    @Column("Key27")
    private Short key27;

    @Column("Key28")
    private Short key28;

    @Column("Key29")
    private Short key29;

    @Column("Key30")
    private Short key30;

    @Column("Key31")
    private Short key31;

    @Column("Key32")
    private Short key32;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
