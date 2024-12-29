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


@Table(name = "artifact_power_link")
@Db2DataBind(name = "ArtifactPowerLink.db2", layoutHash = 0xE179618C, fields = {
        @Db2Field(name = "powerA", type = Db2Type.SHORT),
        @Db2Field(name = "powerB", type = Db2Type.SHORT)
})
public class ArtifactPowerLink implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("PowerA")
    private Short powerA;

    @Column("PowerB")
    private Short powerB;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
