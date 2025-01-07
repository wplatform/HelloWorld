package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
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


@Table(name = "curve_point")
@Db2DataBind(name = "CurvePoint.db2", layoutHash = 0xF36752EB, fields = {
        @Db2Field(name = {"posX", "posY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "curveID", type = Db2Type.SHORT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE)
})
public class CurvePoint implements DbcEntity,Comparable<CurvePoint> {
    @Id
    
    @Column("ID")
    private int id;

    @Column("PosX")
    private Float posX;

    @Column("PosY")
    private Float posY;

    @Column("CurveID")
    private Short curveID;

    @Column("OrderIndex")
    private Byte orderIndex;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    @Override
    public int compareTo(CurvePoint o) {
        return Byte.compare(this.orderIndex, o.orderIndex);
    }
}
