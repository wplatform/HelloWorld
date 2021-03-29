package com.rainbowland.service.auth.domain;

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
@Table("battlenet_account_mounts")
public class BattlenetAccountMount {

    @Column("battlenetAccountId")
    private Long battlenetAccountId;
    @Column("mountSpellId")
    private Integer mountSpellId;
    @Column("flags")
    private Integer flags;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlenetAccountMount> {

        public BattlenetAccountMount convert(Row row) {
            BattlenetAccountMount domain = new BattlenetAccountMount();
            domain.setBattlenetAccountId(row.get("battlenetAccountId", Long.class));
            domain.setMountSpellId(row.get("mountSpellId", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlenetAccountMount, OutboundRow> {

        public OutboundRow convert(BattlenetAccountMount source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getBattlenetAccountId()).ifPresent(e -> row.put("battlenetAccountId", Parameter.from(e)));
            Optional.ofNullable(source.getMountSpellId()).ifPresent(e -> row.put("mountSpellId", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            return row;
        }
    }

}
