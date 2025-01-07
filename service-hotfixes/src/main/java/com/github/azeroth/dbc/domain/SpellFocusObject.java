package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
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


@Table(name = "spell_focus_object")
@Db2DataBind(name = "SpellFocusObject.db2", layoutHash = 0x96663ABF, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING)
})
public class SpellFocusObject implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
