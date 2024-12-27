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
@Table(name = "mount_type_x_capability")
@Db2DataBind(name = "MountTypeXCapability.db2", layoutHash = 0xA34A8445, parentIndexField = 0, fields = {
        @Db2Field(name = "mountTypeID", type = Db2Type.SHORT),
        @Db2Field(name = "mountCapabilityID", type = Db2Type.SHORT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE)
})
public class MountTypeXCapability implements DbcEntity, Comparable<MountTypeXCapability> {

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "MountTypeID")
    private Short mountTypeID;

    @Column(name = "MountCapabilityID")
    private Short mountCapabilityID;

    @Column(name = "OrderIndex")
    private Byte orderIndex;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;


    @Override
    public int compareTo(MountTypeXCapability o) {
        int result = Short.compare(mountTypeID, o.mountTypeID);
        if (result == 0) {
            result = Byte.compare(orderIndex, o.orderIndex);
        }
        return result;
    }


}
