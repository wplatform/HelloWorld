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
@Table(name = "item_armor_quality")
@Db2DataBind(name = "ItemArmorQuality.db2", layoutHash = 0x85642CC0, fields = {
        @Db2Field(name = {"qualitymod1", "qualitymod2", "qualitymod3", "qualitymod4", "qualitymod5", "qualitymod6", "qualitymod7"}, type = Db2Type.FLOAT),
        @Db2Field(name = "itemLevel", type = Db2Type.SHORT, signed = true)
})
public class ItemArmorQuality implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Qualitymod1")
    private Float qualitymod1;

    @Column(name = "Qualitymod2")
    private Float qualitymod2;

    @Column(name = "Qualitymod3")
    private Float qualitymod3;

    @Column(name = "Qualitymod4")
    private Float qualitymod4;

    @Column(name = "Qualitymod5")
    private Float qualitymod5;

    @Column(name = "Qualitymod6")
    private Float qualitymod6;

    @Column(name = "Qualitymod7")
    private Float qualitymod7;

    @Column(name = "ItemLevel")
    private Short itemLevel;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
