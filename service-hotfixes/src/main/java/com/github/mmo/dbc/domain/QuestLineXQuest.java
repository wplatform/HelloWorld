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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "quest_line_x_quest")
@Db2DataBind(name = "QuestLineXQuest.db2", layoutHash = 0x83C5B32B, parentIndexField = 0, fields = {
        @Db2Field(name = "questLineID", type = Db2Type.SHORT),
        @Db2Field(name = "questID", type = Db2Type.SHORT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE)
})
public class QuestLineXQuest implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @ColumnDefault("'0'")
    @Column(name = "QuestLineID", columnDefinition = "int UNSIGNED not null")
    private Long questLineID;

    @ColumnDefault("'0'")
    @Column(name = "QuestID", columnDefinition = "int UNSIGNED not null")
    private Long questID;

    @ColumnDefault("'0'")
    @Column(name = "OrderIndex", columnDefinition = "int UNSIGNED not null")
    private Long orderIndex;

}