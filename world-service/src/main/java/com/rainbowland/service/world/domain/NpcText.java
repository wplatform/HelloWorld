package com.rainbowland.service.world.domain;

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
@Table("npc_text")
public class NpcText {

    @Column("ID")
    private Integer id;
    @Column("Probability0")
    private Double probability0;
    @Column("Probability1")
    private Double probability1;
    @Column("Probability2")
    private Double probability2;
    @Column("Probability3")
    private Double probability3;
    @Column("Probability4")
    private Double probability4;
    @Column("Probability5")
    private Double probability5;
    @Column("Probability6")
    private Double probability6;
    @Column("Probability7")
    private Double probability7;
    @Column("BroadcastTextID0")
    private Integer broadcastTextId0;
    @Column("BroadcastTextID1")
    private Integer broadcastTextId1;
    @Column("BroadcastTextID2")
    private Integer broadcastTextId2;
    @Column("BroadcastTextID3")
    private Integer broadcastTextId3;
    @Column("BroadcastTextID4")
    private Integer broadcastTextId4;
    @Column("BroadcastTextID5")
    private Integer broadcastTextId5;
    @Column("BroadcastTextID6")
    private Integer broadcastTextId6;
    @Column("BroadcastTextID7")
    private Integer broadcastTextId7;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, NpcText> {

        public NpcText convert(Row row) {
            NpcText domain = new NpcText();
            domain.setId(row.get("ID", Integer.class));
            domain.setProbability0(row.get("Probability0", Double.class));
            domain.setProbability1(row.get("Probability1", Double.class));
            domain.setProbability2(row.get("Probability2", Double.class));
            domain.setProbability3(row.get("Probability3", Double.class));
            domain.setProbability4(row.get("Probability4", Double.class));
            domain.setProbability5(row.get("Probability5", Double.class));
            domain.setProbability6(row.get("Probability6", Double.class));
            domain.setProbability7(row.get("Probability7", Double.class));
            domain.setBroadcastTextId0(row.get("BroadcastTextID0", Integer.class));
            domain.setBroadcastTextId1(row.get("BroadcastTextID1", Integer.class));
            domain.setBroadcastTextId2(row.get("BroadcastTextID2", Integer.class));
            domain.setBroadcastTextId3(row.get("BroadcastTextID3", Integer.class));
            domain.setBroadcastTextId4(row.get("BroadcastTextID4", Integer.class));
            domain.setBroadcastTextId5(row.get("BroadcastTextID5", Integer.class));
            domain.setBroadcastTextId6(row.get("BroadcastTextID6", Integer.class));
            domain.setBroadcastTextId7(row.get("BroadcastTextID7", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<NpcText, OutboundRow> {

        public OutboundRow convert(NpcText source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getProbability0()).ifPresent(e -> row.put("Probability0", Parameter.from(e)));
            Optional.ofNullable(source.getProbability1()).ifPresent(e -> row.put("Probability1", Parameter.from(e)));
            Optional.ofNullable(source.getProbability2()).ifPresent(e -> row.put("Probability2", Parameter.from(e)));
            Optional.ofNullable(source.getProbability3()).ifPresent(e -> row.put("Probability3", Parameter.from(e)));
            Optional.ofNullable(source.getProbability4()).ifPresent(e -> row.put("Probability4", Parameter.from(e)));
            Optional.ofNullable(source.getProbability5()).ifPresent(e -> row.put("Probability5", Parameter.from(e)));
            Optional.ofNullable(source.getProbability6()).ifPresent(e -> row.put("Probability6", Parameter.from(e)));
            Optional.ofNullable(source.getProbability7()).ifPresent(e -> row.put("Probability7", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId0()).ifPresent(e -> row.put("BroadcastTextID0", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId1()).ifPresent(e -> row.put("BroadcastTextID1", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId2()).ifPresent(e -> row.put("BroadcastTextID2", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId3()).ifPresent(e -> row.put("BroadcastTextID3", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId4()).ifPresent(e -> row.put("BroadcastTextID4", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId5()).ifPresent(e -> row.put("BroadcastTextID5", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId6()).ifPresent(e -> row.put("BroadcastTextID6", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId7()).ifPresent(e -> row.put("BroadcastTextID7", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
