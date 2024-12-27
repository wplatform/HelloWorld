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
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "transmog_set_item")
@Db2DataBind(name = "TransmogSetItem.db2", layoutHash = 0x0E96B3A2, indexField = 0, parentIndexField = 1, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "transmogSetID", type = Db2Type.INT),
        @Db2Field(name = "itemModifiedAppearanceID", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true)
})
public class TransmogSetItem implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "TransmogSetID")
    private Integer transmogSetID;

    @Column(name = "ItemModifiedAppearanceID")
    private Integer itemModifiedAppearanceID;

    @Column(name = "Flags")
    private Integer flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
