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
@Table("reward_pack_x_currency_type")
public class RewardPackXCurrencyType {

    @Column("ID")
    private Integer id;
    @Column("CurrencyTypeID")
    private Integer currencyTypeId;
    @Column("Quantity")
    private Integer quantity;
    @Column("RewardPackID")
    private Integer rewardPackId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RewardPackXCurrencyType> {

        public RewardPackXCurrencyType convert(Row row) {
            RewardPackXCurrencyType domain = new RewardPackXCurrencyType();
            domain.setId(row.get("ID", Integer.class));
            domain.setCurrencyTypeId(row.get("CurrencyTypeID", Integer.class));
            domain.setQuantity(row.get("Quantity", Integer.class));
            domain.setRewardPackId(row.get("RewardPackID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RewardPackXCurrencyType, OutboundRow> {

        public OutboundRow convert(RewardPackXCurrencyType source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyTypeId()).ifPresent(e -> row.put("CurrencyTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getQuantity()).ifPresent(e -> row.put("Quantity", Parameter.from(e)));
            Optional.ofNullable(source.getRewardPackId()).ifPresent(e -> row.put("RewardPackID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
