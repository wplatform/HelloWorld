package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "transmog_set")
@Db2DataBind(name = "TransmogSet.db2", layoutHash = 0xBEDFD7D1, indexField = 4, parentIndexField = 1, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "parentTransmogSetID", type = Db2Type.SHORT),
        @Db2Field(name = "uiOrder", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "expansionID", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "trackingQuestID", type = Db2Type.INT),
        @Db2Field(name = "classMask", type = Db2Type.INT, signed = true),
        @Db2Field(name = "itemNameDescriptionID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "transmogSetGroupID", type = Db2Type.INT)
})
public class TransmogSet implements DbcEntity {
    @Column("Name")
    private LocalizedString name;

    @Column("ParentTransmogSetID")
    private Short parentTransmogSetID;

    @Column("UiOrder")
    private Short uiOrder;

    @Column("ExpansionID")
    private Byte expansionID;

    @Id

    @Column("ID")
    private int id;

    @Column("Flags")
    private Integer flags;

    @Column("TrackingQuestID")
    private Integer trackingQuestID;

    @Column("ClassMask")
    private Integer classMask;

    @Column("ItemNameDescriptionID")
    private Integer itemNameDescriptionID;

    @Column("TransmogSetGroupID")
    private Integer transmogSetGroupID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
