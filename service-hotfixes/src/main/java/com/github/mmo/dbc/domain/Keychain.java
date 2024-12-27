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
@Table(name = "keychain")
@Db2DataBind(name = "Keychain.db2", layoutHash = 0x5B214E82, fields = {
        @Db2Field(name = {"key1", "key2", "key3", "key4", "key5", "key6", "key7", "key8", "key9", "key10", "key11", "key12", "key13", "key14", "key15", "key16", "key17", "key18", "key19", "key20", "key21", "key22", "key23", "key24", "key25", "key26", "key27", "key28", "key29", "key30", "key31", "key32"}, type = Db2Type.BYTE)
})
public class Keychain implements DbcEntity {
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

    @Column(name = "Key17")
    private Short key17;

    @Column(name = "Key18")
    private Short key18;

    @Column(name = "Key19")
    private Short key19;

    @Column(name = "Key20")
    private Short key20;

    @Column(name = "Key21")
    private Short key21;

    @Column(name = "Key22")
    private Short key22;

    @Column(name = "Key23")
    private Short key23;

    @Column(name = "Key24")
    private Short key24;

    @Column(name = "Key25")
    private Short key25;

    @Column(name = "Key26")
    private Short key26;

    @Column(name = "Key27")
    private Short key27;

    @Column(name = "Key28")
    private Short key28;

    @Column(name = "Key29")
    private Short key29;

    @Column(name = "Key30")
    private Short key30;

    @Column(name = "Key31")
    private Short key31;

    @Column(name = "Key32")
    private Short key32;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
