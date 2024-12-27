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
@Table(name = "achievement")
@Db2DataBind(name = "Achievement.db2", layoutHash = 0x2C4BE18C, indexField = 12, parentIndexField = 7, fields = {
        @Db2Field(name = "title", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "reward", type = Db2Type.STRING),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "instanceID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "supercedes", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "category", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "uiOrder", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "sharesCriteria", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "faction", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "points", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minimumCriteria", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "iconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "criteriaTree", type = Db2Type.INT)
})
public class Achievement implements DbcEntity {
    @Column(name = "Title")
    private LocalizedString title;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "Reward")
    private LocalizedString reward;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "InstanceID")
    private Short instanceID;

    @Column(name = "Supercedes")
    private Short supercedes;

    @Column(name = "Category")
    private Short category;

    @Column(name = "UiOrder")
    private Short uiOrder;

    @Column(name = "SharesCriteria")
    private Short sharesCriteria;

    @Column(name = "Faction")
    private Byte faction;

    @Column(name = "Points")
    private Byte points;

    @Column(name = "MinimumCriteria")
    private Byte minimumCriteria;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "IconFileID")
    private Integer iconFileID;

    @Column(name = "CriteriaTree")
    private Integer criteriaTree;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
