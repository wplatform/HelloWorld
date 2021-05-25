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
@Table("reward_pack_x_item")
public class RewardPackXItem {

    @Column("ID")
    private Integer id;
    @Column("ItemID")
    private Integer itemId;
    @Column("ItemQuantity")
    private Integer itemQuantity;
    @Column("RewardPackID")
    private Integer rewardPackId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RewardPackXItem> {

        public RewardPackXItem convert(Row row) {
            RewardPackXItem domain = new RewardPackXItem();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setItemQuantity(row.get("ItemQuantity", Integer.class));
            domain.setRewardPackId(row.get("RewardPackID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RewardPackXItem, OutboundRow> {

        public OutboundRow convert(RewardPackXItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getItemQuantity()).ifPresent(e -> row.put("ItemQuantity", Parameter.from(e)));
            Optional.ofNullable(source.getRewardPackId()).ifPresent(e -> row.put("RewardPackID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
