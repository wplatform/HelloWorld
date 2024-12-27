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
    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "ParentTransmogSetID")
    private Short parentTransmogSetID;

    @Column(name = "UiOrder")
    private Short uiOrder;

    @Column(name = "ExpansionID")
    private Byte expansionID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "TrackingQuestID")
    private Integer trackingQuestID;

    @Column(name = "ClassMask")
    private Integer classMask;

    @Column(name = "ItemNameDescriptionID")
    private Integer itemNameDescriptionID;

    @Column(name = "TransmogSetGroupID")
    private Integer transmogSetGroupID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
