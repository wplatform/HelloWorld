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


@Table(name = "artifact_power_picker")
@Db2DataBind(name = "ArtifactPowerPicker.db2", layoutHash = 0x2D6AF006, fields = {
        @Db2Field(name = "playerConditionID", type = Db2Type.INT)
})
public class ArtifactPowerPicker implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("PlayerConditionID")
    private Integer playerConditionID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
