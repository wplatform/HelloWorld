package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("faction_template")
public class FactionTemplate {

    @Column("ID")
    private Integer id;
    @Column("Faction")
    private Integer faction;
    @Column("Flags")
    private Integer flags;
    @Column("FactionGroup")
    private Integer factionGroup;
    @Column("FriendGroup")
    private Integer friendGroup;
    @Column("EnemyGroup")
    private Integer enemyGroup;
    @Column("Enemies1")
    private Integer enemies1;
    @Column("Enemies2")
    private Integer enemies2;
    @Column("Enemies3")
    private Integer enemies3;
    @Column("Enemies4")
    private Integer enemies4;
    @Column("Friend1")
    private Integer friend1;
    @Column("Friend2")
    private Integer friend2;
    @Column("Friend3")
    private Integer friend3;
    @Column("Friend4")
    private Integer friend4;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, FactionTemplate> {

        public FactionTemplate convert(Row row) {
            FactionTemplate domain = new FactionTemplate();
            domain.setId(row.get("ID", Integer.class));
            domain.setFaction(row.get("Faction", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setFactionGroup(row.get("FactionGroup", Integer.class));
            domain.setFriendGroup(row.get("FriendGroup", Integer.class));
            domain.setEnemyGroup(row.get("EnemyGroup", Integer.class));
            domain.setEnemies1(row.get("Enemies1", Integer.class));
            domain.setEnemies2(row.get("Enemies2", Integer.class));
            domain.setEnemies3(row.get("Enemies3", Integer.class));
            domain.setEnemies4(row.get("Enemies4", Integer.class));
            domain.setFriend1(row.get("Friend1", Integer.class));
            domain.setFriend2(row.get("Friend2", Integer.class));
            domain.setFriend3(row.get("Friend3", Integer.class));
            domain.setFriend4(row.get("Friend4", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<FactionTemplate, OutboundRow> {

        public OutboundRow convert(FactionTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("Faction", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getFactionGroup()).ifPresent(e -> row.put("FactionGroup", Parameter.from(e)));
            Optional.ofNullable(source.getFriendGroup()).ifPresent(e -> row.put("FriendGroup", Parameter.from(e)));
            Optional.ofNullable(source.getEnemyGroup()).ifPresent(e -> row.put("EnemyGroup", Parameter.from(e)));
            Optional.ofNullable(source.getEnemies1()).ifPresent(e -> row.put("Enemies1", Parameter.from(e)));
            Optional.ofNullable(source.getEnemies2()).ifPresent(e -> row.put("Enemies2", Parameter.from(e)));
            Optional.ofNullable(source.getEnemies3()).ifPresent(e -> row.put("Enemies3", Parameter.from(e)));
            Optional.ofNullable(source.getEnemies4()).ifPresent(e -> row.put("Enemies4", Parameter.from(e)));
            Optional.ofNullable(source.getFriend1()).ifPresent(e -> row.put("Friend1", Parameter.from(e)));
            Optional.ofNullable(source.getFriend2()).ifPresent(e -> row.put("Friend2", Parameter.from(e)));
            Optional.ofNullable(source.getFriend3()).ifPresent(e -> row.put("Friend3", Parameter.from(e)));
            Optional.ofNullable(source.getFriend4()).ifPresent(e -> row.put("Friend4", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
