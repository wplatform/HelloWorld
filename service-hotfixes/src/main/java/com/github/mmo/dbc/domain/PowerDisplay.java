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


@Table(name = "power_display")
@Db2DataBind(name = "PowerDisplay.db2", layoutHash = 0xFD152E5B, fields = {
        @Db2Field(name = "globalStringBaseTag", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "actualType", type = Db2Type.BYTE),
        @Db2Field(name = "red", type = Db2Type.BYTE),
        @Db2Field(name = "green", type = Db2Type.BYTE),
        @Db2Field(name = "blue", type = Db2Type.BYTE)
})
public class PowerDisplay implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("GlobalStringBaseTag")
    private String globalStringBaseTag;

    @Column("ActualType")
    private Byte actualType;

    @Column("Red")
    private Short red;

    @Column("Green")
    private Short green;

    @Column("Blue")
    private Short blue;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
