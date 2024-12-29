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


@Table(name = "battle_pet_breed_quality")
@Db2DataBind(name = "BattlePetBreedQuality.db2", layoutHash = 0xBDE74E1D, fields = {
        @Db2Field(name = "stateMultiplier", type = Db2Type.FLOAT),
        @Db2Field(name = "qualityEnum", type = Db2Type.BYTE)
})
public class BattlePetBreedQuality implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("StateMultiplier")
    private Float stateMultiplier;

    @Column("QualityEnum")
    private Byte qualityEnum;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
