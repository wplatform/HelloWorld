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


@Table(name = "paragon_reputation")
@Db2DataBind(name = "ParagonReputation.db2", layoutHash = 0xD7712F98, parentIndexField = 2, fields = {
        @Db2Field(name = "factionID", type = Db2Type.INT),
        @Db2Field(name = "levelThreshold", type = Db2Type.INT, signed = true),
        @Db2Field(name = "questID", type = Db2Type.INT, signed = true)
})
public class ParagonReputation implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("FactionID")
    private Integer factionID;

    @Column("LevelThreshold")
    private Integer levelThreshold;

    @Column("QuestID")
    private Integer questID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
