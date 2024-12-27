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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Clothmodifier")
    private Float clothModifier;

    @Column(name = "Leathermodifier")
    private Float leatherModifier;

    @Column(name = "Chainmodifier")
    private Float chainModifier;

    @Column(name = "Platemodifier")
    private Float plateModifier;

    @Column(name = "Modifier")
    private Float Modifier;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
