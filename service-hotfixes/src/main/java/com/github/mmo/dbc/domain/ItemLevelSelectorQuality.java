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


@Table(name = "item_level_selector_quality")
@Db2DataBind(name = "ItemLevelSelectorQuality.db2", layoutHash = 0xB7174A51, parentIndexField = 2, fields = {
        @Db2Field(name = "qualityItemBonusListID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "quality", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "parentILSQualitySetID", type = Db2Type.SHORT, signed = true)
})
public class ItemLevelSelectorQuality implements DbcEntity, Comparable<ItemLevelSelectorQuality> {
    @Id

    @Column("ID")
    private int id;

    @Column("QualityItemBonusListID")
    private Integer qualityItemBonusListID;

    @Column("Quality")
    private Byte quality;

    @Column("ParentILSQualitySetID")
    private Short parentILSQualitySetID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    @Override
    public int compareTo(ItemLevelSelectorQuality o) {
        return Byte.compare(this.quality, o.quality);
    }
}
