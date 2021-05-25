package com.rainbowland.service.world.domain;

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
@Table("playerchoice_response_reward_currency")
public class PlayerchoiceResponseRewardCurrency {

    @Column("ChoiceId")
    private Integer choiceId;
    @Column("ResponseId")
    private Integer responseId;
    @Column("Index")
    private Integer index;
    @Column("CurrencyId")
    private Integer currencyId;
    @Column("Quantity")
    private Integer quantity;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerchoiceResponseRewardCurrency> {

        public PlayerchoiceResponseRewardCurrency convert(Row row) {
            PlayerchoiceResponseRewardCurrency domain = new PlayerchoiceResponseRewardCurrency();
            domain.setChoiceId(row.get("ChoiceId", Integer.class));
            domain.setResponseId(row.get("ResponseId", Integer.class));
            domain.setIndex(row.get("Index", Integer.class));
            domain.setCurrencyId(row.get("CurrencyId", Integer.class));
            domain.setQuantity(row.get("Quantity", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerchoiceResponseRewardCurrency, OutboundRow> {

        public OutboundRow convert(PlayerchoiceResponseRewardCurrency source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getChoiceId()).ifPresent(e -> row.put("ChoiceId", Parameter.from(e)));
            Optional.ofNullable(source.getResponseId()).ifPresent(e -> row.put("ResponseId", Parameter.from(e)));
            Optional.ofNullable(source.getIndex()).ifPresent(e -> row.put("Index", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId()).ifPresent(e -> row.put("CurrencyId", Parameter.from(e)));
            Optional.ofNullable(source.getQuantity()).ifPresent(e -> row.put("Quantity", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
