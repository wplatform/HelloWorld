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
@Table("faction")
public class Faction {

    @Column("ReputationRaceMask1")
    private Long reputationRaceMask1;
    @Column("ReputationRaceMask2")
    private Long reputationRaceMask2;
    @Column("ReputationRaceMask3")
    private Long reputationRaceMask3;
    @Column("ReputationRaceMask4")
    private Long reputationRaceMask4;
    @Column("Name")
    private String name;
    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("ReputationIndex")
    private Integer reputationIndex;
    @Column("ParentFactionID")
    private Integer parentFactionId;
    @Column("Expansion")
    private Integer expansion;
    @Column("FriendshipRepID")
    private Integer friendshipRepId;
    @Column("Flags")
    private Integer flags;
    @Column("ParagonFactionID")
    private Integer paragonFactionId;
    @Column("ReputationClassMask1")
    private Integer reputationClassMask1;
    @Column("ReputationClassMask2")
    private Integer reputationClassMask2;
    @Column("ReputationClassMask3")
    private Integer reputationClassMask3;
    @Column("ReputationClassMask4")
    private Integer reputationClassMask4;
    @Column("ReputationFlags1")
    private Integer reputationFlags1;
    @Column("ReputationFlags2")
    private Integer reputationFlags2;
    @Column("ReputationFlags3")
    private Integer reputationFlags3;
    @Column("ReputationFlags4")
    private Integer reputationFlags4;
    @Column("ReputationBase1")
    private Integer reputationBase1;
    @Column("ReputationBase2")
    private Integer reputationBase2;
    @Column("ReputationBase3")
    private Integer reputationBase3;
    @Column("ReputationBase4")
    private Integer reputationBase4;
    @Column("ReputationMax1")
    private Integer reputationMax1;
    @Column("ReputationMax2")
    private Integer reputationMax2;
    @Column("ReputationMax3")
    private Integer reputationMax3;
    @Column("ReputationMax4")
    private Integer reputationMax4;
    @Column("ParentFactionMod1")
    private Double parentFactionMod1;
    @Column("ParentFactionMod2")
    private Double parentFactionMod2;
    @Column("ParentFactionCap1")
    private Integer parentFactionCap1;
    @Column("ParentFactionCap2")
    private Integer parentFactionCap2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Faction> {

        public Faction convert(Row row) {
            Faction domain = new Faction();
            domain.setReputationRaceMask1(row.get("ReputationRaceMask1", Long.class));
            domain.setReputationRaceMask2(row.get("ReputationRaceMask2", Long.class));
            domain.setReputationRaceMask3(row.get("ReputationRaceMask3", Long.class));
            domain.setReputationRaceMask4(row.get("ReputationRaceMask4", Long.class));
            domain.setName(row.get("Name", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setReputationIndex(row.get("ReputationIndex", Integer.class));
            domain.setParentFactionId(row.get("ParentFactionID", Integer.class));
            domain.setExpansion(row.get("Expansion", Integer.class));
            domain.setFriendshipRepId(row.get("FriendshipRepID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setParagonFactionId(row.get("ParagonFactionID", Integer.class));
            domain.setReputationClassMask1(row.get("ReputationClassMask1", Integer.class));
            domain.setReputationClassMask2(row.get("ReputationClassMask2", Integer.class));
            domain.setReputationClassMask3(row.get("ReputationClassMask3", Integer.class));
            domain.setReputationClassMask4(row.get("ReputationClassMask4", Integer.class));
            domain.setReputationFlags1(row.get("ReputationFlags1", Integer.class));
            domain.setReputationFlags2(row.get("ReputationFlags2", Integer.class));
            domain.setReputationFlags3(row.get("ReputationFlags3", Integer.class));
            domain.setReputationFlags4(row.get("ReputationFlags4", Integer.class));
            domain.setReputationBase1(row.get("ReputationBase1", Integer.class));
            domain.setReputationBase2(row.get("ReputationBase2", Integer.class));
            domain.setReputationBase3(row.get("ReputationBase3", Integer.class));
            domain.setReputationBase4(row.get("ReputationBase4", Integer.class));
            domain.setReputationMax1(row.get("ReputationMax1", Integer.class));
            domain.setReputationMax2(row.get("ReputationMax2", Integer.class));
            domain.setReputationMax3(row.get("ReputationMax3", Integer.class));
            domain.setReputationMax4(row.get("ReputationMax4", Integer.class));
            domain.setParentFactionMod1(row.get("ParentFactionMod1", Double.class));
            domain.setParentFactionMod2(row.get("ParentFactionMod2", Double.class));
            domain.setParentFactionCap1(row.get("ParentFactionCap1", Integer.class));
            domain.setParentFactionCap2(row.get("ParentFactionCap2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Faction, OutboundRow> {

        public OutboundRow convert(Faction source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getReputationRaceMask1()).ifPresent(e -> row.put("ReputationRaceMask1", Parameter.from(e)));
            Optional.ofNullable(source.getReputationRaceMask2()).ifPresent(e -> row.put("ReputationRaceMask2", Parameter.from(e)));
            Optional.ofNullable(source.getReputationRaceMask3()).ifPresent(e -> row.put("ReputationRaceMask3", Parameter.from(e)));
            Optional.ofNullable(source.getReputationRaceMask4()).ifPresent(e -> row.put("ReputationRaceMask4", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getReputationIndex()).ifPresent(e -> row.put("ReputationIndex", Parameter.from(e)));
            Optional.ofNullable(source.getParentFactionId()).ifPresent(e -> row.put("ParentFactionID", Parameter.from(e)));
            Optional.ofNullable(source.getExpansion()).ifPresent(e -> row.put("Expansion", Parameter.from(e)));
            Optional.ofNullable(source.getFriendshipRepId()).ifPresent(e -> row.put("FriendshipRepID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getParagonFactionId()).ifPresent(e -> row.put("ParagonFactionID", Parameter.from(e)));
            Optional.ofNullable(source.getReputationClassMask1()).ifPresent(e -> row.put("ReputationClassMask1", Parameter.from(e)));
            Optional.ofNullable(source.getReputationClassMask2()).ifPresent(e -> row.put("ReputationClassMask2", Parameter.from(e)));
            Optional.ofNullable(source.getReputationClassMask3()).ifPresent(e -> row.put("ReputationClassMask3", Parameter.from(e)));
            Optional.ofNullable(source.getReputationClassMask4()).ifPresent(e -> row.put("ReputationClassMask4", Parameter.from(e)));
            Optional.ofNullable(source.getReputationFlags1()).ifPresent(e -> row.put("ReputationFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getReputationFlags2()).ifPresent(e -> row.put("ReputationFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getReputationFlags3()).ifPresent(e -> row.put("ReputationFlags3", Parameter.from(e)));
            Optional.ofNullable(source.getReputationFlags4()).ifPresent(e -> row.put("ReputationFlags4", Parameter.from(e)));
            Optional.ofNullable(source.getReputationBase1()).ifPresent(e -> row.put("ReputationBase1", Parameter.from(e)));
            Optional.ofNullable(source.getReputationBase2()).ifPresent(e -> row.put("ReputationBase2", Parameter.from(e)));
            Optional.ofNullable(source.getReputationBase3()).ifPresent(e -> row.put("ReputationBase3", Parameter.from(e)));
            Optional.ofNullable(source.getReputationBase4()).ifPresent(e -> row.put("ReputationBase4", Parameter.from(e)));
            Optional.ofNullable(source.getReputationMax1()).ifPresent(e -> row.put("ReputationMax1", Parameter.from(e)));
            Optional.ofNullable(source.getReputationMax2()).ifPresent(e -> row.put("ReputationMax2", Parameter.from(e)));
            Optional.ofNullable(source.getReputationMax3()).ifPresent(e -> row.put("ReputationMax3", Parameter.from(e)));
            Optional.ofNullable(source.getReputationMax4()).ifPresent(e -> row.put("ReputationMax4", Parameter.from(e)));
            Optional.ofNullable(source.getParentFactionMod1()).ifPresent(e -> row.put("ParentFactionMod1", Parameter.from(e)));
            Optional.ofNullable(source.getParentFactionMod2()).ifPresent(e -> row.put("ParentFactionMod2", Parameter.from(e)));
            Optional.ofNullable(source.getParentFactionCap1()).ifPresent(e -> row.put("ParentFactionCap1", Parameter.from(e)));
            Optional.ofNullable(source.getParentFactionCap2()).ifPresent(e -> row.put("ParentFactionCap2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
