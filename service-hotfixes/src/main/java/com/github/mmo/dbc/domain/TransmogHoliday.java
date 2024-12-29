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


@Table(name = "transmog_holiday")
@Db2DataBind(name = "TransmogHoliday.db2", layoutHash = 0xB420EB18, indexField = 0, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "requiredTransmogHoliday", type = Db2Type.INT, signed = true)
})
public class TransmogHoliday implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("RequiredTransmogHoliday")
    private Integer requiredTransmogHoliday;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
