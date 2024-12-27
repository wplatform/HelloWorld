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
@Table(name = "import_price_armor")
@Db2DataBind(name = "ImportPriceArmor.db2", layoutHash = 0x1F7A850F, fields = {
        @Db2Field(name = "clothModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "leatherModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "chainModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "plateModifier", type = Db2Type.FLOAT)
})
public class ImportPriceArmor implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ClothModifier")
    private Float clothModifier;

    @Column(name = "LeatherModifier")
    private Float leatherModifier;

    @Column(name = "ChainModifier")
    private Float chainModifier;

    @Column(name = "PlateModifier")
    private Float plateModifier;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
