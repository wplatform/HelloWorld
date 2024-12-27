package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
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
@Table(name = "auction_house")
@Db2DataBind(name = "AuctionHouse.db2", layoutHash = 0x51CFEEFF, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "factionID", type = Db2Type.SHORT),
        @Db2Field(name = "depositRate", type = Db2Type.BYTE),
        @Db2Field(name = "consignmentRate", type = Db2Type.BYTE)
})
public class AuctionHouse implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "FactionID")
    private Short factionID;

    @Column(name = "DepositRate")
    private Byte depositRate;

    @Column(name = "ConsignmentRate")
    private Byte consignmentRate;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
