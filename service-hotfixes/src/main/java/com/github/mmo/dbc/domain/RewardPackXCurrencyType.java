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


@Getter
@Setter
@ToString


@Table(name = "reward_pack_x_currency_type")
@Db2DataBind(name = "RewardPackXCurrencyType.db2", layoutHash = 0x217E6712, parentIndexField = 2, fields = {
        @Db2Field(name = "currencyTypeID", type = Db2Type.INT),
        @Db2Field(name = "quantity", type = Db2Type.INT, signed = true),
        @Db2Field(name = "rewardPackID", type = Db2Type.INT)
})
public class RewardPackXCurrencyType implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("CurrencyTypeID")
    private Integer currencyTypeID;

    @Column("Quantity")
    private Integer quantity;

    @Column("RewardPackID")
    private Integer rewardPackID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
