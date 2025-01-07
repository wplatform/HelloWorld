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
    @Column("Title")
    private LocalizedString title;

    @Column("Description")
    private LocalizedString description;

    @Column("Reward")
    private LocalizedString reward;

    @Column("Flags")
    private Integer flags;

    @Column("InstanceID")
    private Short instanceID;

    @Column("Supercedes")
    private Short supercedes;

    @Column("Category")
    private Short category;

    @Column("UiOrder")
    private Short uiOrder;

    @Column("SharesCriteria")
    private Short sharesCriteria;

    @Column("Faction")
    private Byte faction;

    @Column("Points")
    private Byte points;

    @Column("MinimumCriteria")
    private Byte minimumCriteria;

    @Id
    
    @Column("ID")
    private int id;

    @Column("IconFileID")
    private Integer iconFileID;

    @Column("CriteriaTree")
    private Integer criteriaTree;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
