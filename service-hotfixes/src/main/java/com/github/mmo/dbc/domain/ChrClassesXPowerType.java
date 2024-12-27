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
@Table(name = "chr_classes_x_power_types")
@Db2DataBind(name = "ChrClassesXPowerTypes.db2", layoutHash = 0xAF977B23, parentIndexField = 1, fields = {
        @Db2Field(name = "powerType", type = Db2Type.BYTE),
        @Db2Field(name = "classID", type = Db2Type.BYTE)
})
public class ChrClassesXPowerType implements DbcEntity, Comparable<ChrClassesXPowerType> {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "PowerType")
    private Byte powerType;

    @Column(name = "ClassID")
    private Byte classID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Override
    public int compareTo(ChrClassesXPowerType o) {
        int result = Byte.compare(this.classID, o.classID);
        if (result == 0) {
            result = Byte.compare(this.powerType, o.powerType);
        }
        return result;
    }
}
