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


@Table(name = "transmog_set_item")
@Db2DataBind(name = "TransmogSetItem.db2", layoutHash = 0x0E96B3A2, indexField = 0, parentIndexField = 1, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "transmogSetID", type = Db2Type.INT),
        @Db2Field(name = "itemModifiedAppearanceID", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true)
})
public class TransmogSetItem implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("TransmogSetID")
    private Integer transmogSetID;

    @Column("ItemModifiedAppearanceID")
    private Integer itemModifiedAppearanceID;

    @Column("Flags")
    private Integer flags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
