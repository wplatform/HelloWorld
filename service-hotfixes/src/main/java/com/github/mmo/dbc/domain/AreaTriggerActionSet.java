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
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "area_trigger_action_set")
@Db2DataBind(name = "AreaTriggerActionSet.db2", layoutHash = 0x5DA480BD, fields = {
        @Db2Field(name = "flags", type = Db2Type.SHORT, signed = true)
})
public class AreaTriggerActionSet implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("Flags")
    private Short flags;

}