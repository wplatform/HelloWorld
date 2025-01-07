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


@Table(name = "artifact_unlock")
@Db2DataBind(name = "ArtifactUnlock.db2", layoutHash = 0x52839A77, parentIndexField = 4, fields = {
        @Db2Field(name = "itemBonusListID", type = Db2Type.SHORT),
        @Db2Field(name = "powerRank", type = Db2Type.BYTE),
        @Db2Field(name = "powerID", type = Db2Type.INT),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT),
        @Db2Field(name = "artifactID", type = Db2Type.BYTE)
})
public class ArtifactUnlock implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("ItemBonusListID")
    private Short itemBonusListID;

    @Column("PowerRank")
    private Byte powerRank;

    @Column("PowerID")
    private Integer powerID;

    @Column("PlayerConditionID")
    private Integer playerConditionID;

    @Column("ArtifactID")
    private Byte artifactID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
