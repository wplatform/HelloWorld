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


@Table(name = "guild_color_border")
@Db2DataBind(name = "GuildColorBorder.db2", layoutHash = 0xCC0CEFF1, fields = {
        @Db2Field(name = "red", type = Db2Type.BYTE),
        @Db2Field(name = "green", type = Db2Type.BYTE),
        @Db2Field(name = "blue", type = Db2Type.BYTE)
})
public class GuildColorBorder implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

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
