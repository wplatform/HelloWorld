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


@Table(name = "armor_location")
@Db2DataBind(name = "ArmorLocation.db2", layoutHash = 0xCCFBD16E, fields = {
        @Db2Field(name = "clothModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "leatherModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "chainModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "plateModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "Modifier", type = Db2Type.FLOAT)
})
public class ArmorLocation implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Clothmodifier")
    private Float clothModifier;

    @Column("Leathermodifier")
    private Float leatherModifier;

    @Column("Chainmodifier")
    private Float chainModifier;

    @Column("Platemodifier")
    private Float plateModifier;

    @Column("Modifier")
    private Float Modifier;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
