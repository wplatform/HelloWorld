package com.rainbowland.service.auth.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.annotation.Transient;
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
@Table("realmlist")
public class Realmlist {

    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("address")
    private String address;
    @Column("localAddress")
    private String localAddress;
    @Column("localSubnetMask")
    private String localSubnetMask;
    @Column("port")
    private Integer port;
    @Column("icon")
    private Integer icon;
    @Column("flag")
    private Integer flag;
    @Column("timezone")
    private Integer timezone;
    @Column("allowedSecurityLevel")
    private Integer allowedSecurityLevel;
    @Column("population")
    private Float population;
    @Column("gamebuild")
    private Long gamebuild;
    @Column("Region")
    private Integer region;
    @Column("Battlegroup")
    private Integer battlegroup;

    @Transient
    private Integer numchars;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Realmlist> {

        public Realmlist convert(Row row) {
            Realmlist domain = new Realmlist();
            domain.setId(row.get("id", Long.class));
            domain.setName(row.get("name", String.class));
            domain.setAddress(row.get("address", String.class));
            domain.setLocalAddress(row.get("localAddress", String.class));
            domain.setLocalSubnetMask(row.get("localSubnetMask", String.class));
            domain.setPort(row.get("port", Integer.class));
            domain.setIcon(row.get("icon", Integer.class));
            domain.setFlag(row.get("flag", Integer.class));
            domain.setTimezone(row.get("timezone", Integer.class));
            domain.setAllowedSecurityLevel(row.get("allowedSecurityLevel", Integer.class));
            domain.setPopulation(row.get("population", Float.class));
            domain.setGamebuild(row.get("gamebuild", Long.class));
            domain.setRegion(row.get("Region", Integer.class));
            domain.setBattlegroup(row.get("Battlegroup", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Realmlist, OutboundRow> {

        public OutboundRow convert(Realmlist source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getAddress()).ifPresent(e -> row.put("address", Parameter.from(e)));
            Optional.ofNullable(source.getLocalAddress()).ifPresent(e -> row.put("localAddress", Parameter.from(e)));
            Optional.ofNullable(source.getLocalSubnetMask()).ifPresent(e -> row.put("localSubnetMask", Parameter.from(e)));
            Optional.ofNullable(source.getPort()).ifPresent(e -> row.put("port", Parameter.from(e)));
            Optional.ofNullable(source.getIcon()).ifPresent(e -> row.put("icon", Parameter.from(e)));
            Optional.ofNullable(source.getFlag()).ifPresent(e -> row.put("flag", Parameter.from(e)));
            Optional.ofNullable(source.getTimezone()).ifPresent(e -> row.put("timezone", Parameter.from(e)));
            Optional.ofNullable(source.getAllowedSecurityLevel()).ifPresent(e -> row.put("allowedSecurityLevel", Parameter.from(e)));
            Optional.ofNullable(source.getPopulation()).ifPresent(e -> row.put("population", Parameter.from(e)));
            Optional.ofNullable(source.getGamebuild()).ifPresent(e -> row.put("gamebuild", Parameter.from(e)));
            Optional.ofNullable(source.getRegion()).ifPresent(e -> row.put("Region", Parameter.from(e)));
            Optional.ofNullable(source.getBattlegroup()).ifPresent(e -> row.put("Battlegroup", Parameter.from(e)));
            return row;
        }
    }

}
