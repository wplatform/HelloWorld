package com.rainbowland.service.characters.domain;

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
@Table("guild_member_withdraw")
public class GuildMemberWithdraw {

    @Column("guid")
    private Long guid;
    @Column("tab0")
    private Integer tab0;
    @Column("tab1")
    private Integer tab1;
    @Column("tab2")
    private Integer tab2;
    @Column("tab3")
    private Integer tab3;
    @Column("tab4")
    private Integer tab4;
    @Column("tab5")
    private Integer tab5;
    @Column("tab6")
    private Integer tab6;
    @Column("tab7")
    private Integer tab7;
    @Column("money")
    private Long money;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildMemberWithdraw> {

        public GuildMemberWithdraw convert(Row row) {
            GuildMemberWithdraw domain = new GuildMemberWithdraw();
            domain.setGuid(row.get("guid", Long.class));
            domain.setTab0(row.get("tab0", Integer.class));
            domain.setTab1(row.get("tab1", Integer.class));
            domain.setTab2(row.get("tab2", Integer.class));
            domain.setTab3(row.get("tab3", Integer.class));
            domain.setTab4(row.get("tab4", Integer.class));
            domain.setTab5(row.get("tab5", Integer.class));
            domain.setTab6(row.get("tab6", Integer.class));
            domain.setTab7(row.get("tab7", Integer.class));
            domain.setMoney(row.get("money", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildMemberWithdraw, OutboundRow> {

        public OutboundRow convert(GuildMemberWithdraw source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getTab0()).ifPresent(e -> row.put("tab0", Parameter.from(e)));
            Optional.ofNullable(source.getTab1()).ifPresent(e -> row.put("tab1", Parameter.from(e)));
            Optional.ofNullable(source.getTab2()).ifPresent(e -> row.put("tab2", Parameter.from(e)));
            Optional.ofNullable(source.getTab3()).ifPresent(e -> row.put("tab3", Parameter.from(e)));
            Optional.ofNullable(source.getTab4()).ifPresent(e -> row.put("tab4", Parameter.from(e)));
            Optional.ofNullable(source.getTab5()).ifPresent(e -> row.put("tab5", Parameter.from(e)));
            Optional.ofNullable(source.getTab6()).ifPresent(e -> row.put("tab6", Parameter.from(e)));
            Optional.ofNullable(source.getTab7()).ifPresent(e -> row.put("tab7", Parameter.from(e)));
            Optional.ofNullable(source.getMoney()).ifPresent(e -> row.put("money", Parameter.from(e)));
            return row;
        }
    }

}
