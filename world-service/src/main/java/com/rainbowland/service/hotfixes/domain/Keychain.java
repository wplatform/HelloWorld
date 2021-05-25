package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("keychain")
public class Keychain {

    @Column("ID")
    private Integer id;
    @Column("Key1")
    private Integer key1;
    @Column("Key2")
    private Integer key2;
    @Column("Key3")
    private Integer key3;
    @Column("Key4")
    private Integer key4;
    @Column("Key5")
    private Integer key5;
    @Column("Key6")
    private Integer key6;
    @Column("Key7")
    private Integer key7;
    @Column("Key8")
    private Integer key8;
    @Column("Key9")
    private Integer key9;
    @Column("Key10")
    private Integer key10;
    @Column("Key11")
    private Integer key11;
    @Column("Key12")
    private Integer key12;
    @Column("Key13")
    private Integer key13;
    @Column("Key14")
    private Integer key14;
    @Column("Key15")
    private Integer key15;
    @Column("Key16")
    private Integer key16;
    @Column("Key17")
    private Integer key17;
    @Column("Key18")
    private Integer key18;
    @Column("Key19")
    private Integer key19;
    @Column("Key20")
    private Integer key20;
    @Column("Key21")
    private Integer key21;
    @Column("Key22")
    private Integer key22;
    @Column("Key23")
    private Integer key23;
    @Column("Key24")
    private Integer key24;
    @Column("Key25")
    private Integer key25;
    @Column("Key26")
    private Integer key26;
    @Column("Key27")
    private Integer key27;
    @Column("Key28")
    private Integer key28;
    @Column("Key29")
    private Integer key29;
    @Column("Key30")
    private Integer key30;
    @Column("Key31")
    private Integer key31;
    @Column("Key32")
    private Integer key32;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Keychain> {

        public Keychain convert(Row row) {
            Keychain domain = new Keychain();
            domain.setId(row.get("ID", Integer.class));
            domain.setKey1(row.get("Key1", Integer.class));
            domain.setKey2(row.get("Key2", Integer.class));
            domain.setKey3(row.get("Key3", Integer.class));
            domain.setKey4(row.get("Key4", Integer.class));
            domain.setKey5(row.get("Key5", Integer.class));
            domain.setKey6(row.get("Key6", Integer.class));
            domain.setKey7(row.get("Key7", Integer.class));
            domain.setKey8(row.get("Key8", Integer.class));
            domain.setKey9(row.get("Key9", Integer.class));
            domain.setKey10(row.get("Key10", Integer.class));
            domain.setKey11(row.get("Key11", Integer.class));
            domain.setKey12(row.get("Key12", Integer.class));
            domain.setKey13(row.get("Key13", Integer.class));
            domain.setKey14(row.get("Key14", Integer.class));
            domain.setKey15(row.get("Key15", Integer.class));
            domain.setKey16(row.get("Key16", Integer.class));
            domain.setKey17(row.get("Key17", Integer.class));
            domain.setKey18(row.get("Key18", Integer.class));
            domain.setKey19(row.get("Key19", Integer.class));
            domain.setKey20(row.get("Key20", Integer.class));
            domain.setKey21(row.get("Key21", Integer.class));
            domain.setKey22(row.get("Key22", Integer.class));
            domain.setKey23(row.get("Key23", Integer.class));
            domain.setKey24(row.get("Key24", Integer.class));
            domain.setKey25(row.get("Key25", Integer.class));
            domain.setKey26(row.get("Key26", Integer.class));
            domain.setKey27(row.get("Key27", Integer.class));
            domain.setKey28(row.get("Key28", Integer.class));
            domain.setKey29(row.get("Key29", Integer.class));
            domain.setKey30(row.get("Key30", Integer.class));
            domain.setKey31(row.get("Key31", Integer.class));
            domain.setKey32(row.get("Key32", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Keychain, OutboundRow> {

        public OutboundRow convert(Keychain source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getKey1()).ifPresent(e -> row.put("Key1", Parameter.from(e)));
            Optional.ofNullable(source.getKey2()).ifPresent(e -> row.put("Key2", Parameter.from(e)));
            Optional.ofNullable(source.getKey3()).ifPresent(e -> row.put("Key3", Parameter.from(e)));
            Optional.ofNullable(source.getKey4()).ifPresent(e -> row.put("Key4", Parameter.from(e)));
            Optional.ofNullable(source.getKey5()).ifPresent(e -> row.put("Key5", Parameter.from(e)));
            Optional.ofNullable(source.getKey6()).ifPresent(e -> row.put("Key6", Parameter.from(e)));
            Optional.ofNullable(source.getKey7()).ifPresent(e -> row.put("Key7", Parameter.from(e)));
            Optional.ofNullable(source.getKey8()).ifPresent(e -> row.put("Key8", Parameter.from(e)));
            Optional.ofNullable(source.getKey9()).ifPresent(e -> row.put("Key9", Parameter.from(e)));
            Optional.ofNullable(source.getKey10()).ifPresent(e -> row.put("Key10", Parameter.from(e)));
            Optional.ofNullable(source.getKey11()).ifPresent(e -> row.put("Key11", Parameter.from(e)));
            Optional.ofNullable(source.getKey12()).ifPresent(e -> row.put("Key12", Parameter.from(e)));
            Optional.ofNullable(source.getKey13()).ifPresent(e -> row.put("Key13", Parameter.from(e)));
            Optional.ofNullable(source.getKey14()).ifPresent(e -> row.put("Key14", Parameter.from(e)));
            Optional.ofNullable(source.getKey15()).ifPresent(e -> row.put("Key15", Parameter.from(e)));
            Optional.ofNullable(source.getKey16()).ifPresent(e -> row.put("Key16", Parameter.from(e)));
            Optional.ofNullable(source.getKey17()).ifPresent(e -> row.put("Key17", Parameter.from(e)));
            Optional.ofNullable(source.getKey18()).ifPresent(e -> row.put("Key18", Parameter.from(e)));
            Optional.ofNullable(source.getKey19()).ifPresent(e -> row.put("Key19", Parameter.from(e)));
            Optional.ofNullable(source.getKey20()).ifPresent(e -> row.put("Key20", Parameter.from(e)));
            Optional.ofNullable(source.getKey21()).ifPresent(e -> row.put("Key21", Parameter.from(e)));
            Optional.ofNullable(source.getKey22()).ifPresent(e -> row.put("Key22", Parameter.from(e)));
            Optional.ofNullable(source.getKey23()).ifPresent(e -> row.put("Key23", Parameter.from(e)));
            Optional.ofNullable(source.getKey24()).ifPresent(e -> row.put("Key24", Parameter.from(e)));
            Optional.ofNullable(source.getKey25()).ifPresent(e -> row.put("Key25", Parameter.from(e)));
            Optional.ofNullable(source.getKey26()).ifPresent(e -> row.put("Key26", Parameter.from(e)));
            Optional.ofNullable(source.getKey27()).ifPresent(e -> row.put("Key27", Parameter.from(e)));
            Optional.ofNullable(source.getKey28()).ifPresent(e -> row.put("Key28", Parameter.from(e)));
            Optional.ofNullable(source.getKey29()).ifPresent(e -> row.put("Key29", Parameter.from(e)));
            Optional.ofNullable(source.getKey30()).ifPresent(e -> row.put("Key30", Parameter.from(e)));
            Optional.ofNullable(source.getKey31()).ifPresent(e -> row.put("Key31", Parameter.from(e)));
            Optional.ofNullable(source.getKey32()).ifPresent(e -> row.put("Key32", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
