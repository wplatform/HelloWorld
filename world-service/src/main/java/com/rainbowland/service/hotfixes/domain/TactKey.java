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
@Table("tact_key")
public class TactKey {

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
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TactKey> {

        public TactKey convert(Row row) {
            TactKey domain = new TactKey();
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
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TactKey, OutboundRow> {

        public OutboundRow convert(TactKey source) {
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
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
