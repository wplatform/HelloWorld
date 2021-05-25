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
@Table("transmog_set")
public class TransmogSet {

    @Column("Name")
    private String name;
    @Column("ID")
    private Integer id;
    @Column("ClassMask")
    private Integer classMask;
    @Column("TrackingQuestID")
    private Integer trackingQuestId;
    @Column("Flags")
    private Integer flags;
    @Column("TransmogSetGroupID")
    private Integer transmogSetGroupId;
    @Column("ItemNameDescriptionID")
    private Integer itemNameDescriptionId;
    @Column("ParentTransmogSetID")
    private Integer parentTransmogSetId;
    @Column("Unknown810")
    private Integer unknown810;
    @Column("ExpansionID")
    private Integer expansionId;
    @Column("PatchID")
    private Integer patchId;
    @Column("UiOrder")
    private Integer uiOrder;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TransmogSet> {

        public TransmogSet convert(Row row) {
            TransmogSet domain = new TransmogSet();
            domain.setName(row.get("Name", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setClassMask(row.get("ClassMask", Integer.class));
            domain.setTrackingQuestId(row.get("TrackingQuestID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setTransmogSetGroupId(row.get("TransmogSetGroupID", Integer.class));
            domain.setItemNameDescriptionId(row.get("ItemNameDescriptionID", Integer.class));
            domain.setParentTransmogSetId(row.get("ParentTransmogSetID", Integer.class));
            domain.setUnknown810(row.get("Unknown810", Integer.class));
            domain.setExpansionId(row.get("ExpansionID", Integer.class));
            domain.setPatchId(row.get("PatchID", Integer.class));
            domain.setUiOrder(row.get("UiOrder", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TransmogSet, OutboundRow> {

        public OutboundRow convert(TransmogSet source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getClassMask()).ifPresent(e -> row.put("ClassMask", Parameter.from(e)));
            Optional.ofNullable(source.getTrackingQuestId()).ifPresent(e -> row.put("TrackingQuestID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogSetGroupId()).ifPresent(e -> row.put("TransmogSetGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getItemNameDescriptionId()).ifPresent(e -> row.put("ItemNameDescriptionID", Parameter.from(e)));
            Optional.ofNullable(source.getParentTransmogSetId()).ifPresent(e -> row.put("ParentTransmogSetID", Parameter.from(e)));
            Optional.ofNullable(source.getUnknown810()).ifPresent(e -> row.put("Unknown810", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionId()).ifPresent(e -> row.put("ExpansionID", Parameter.from(e)));
            Optional.ofNullable(source.getPatchId()).ifPresent(e -> row.put("PatchID", Parameter.from(e)));
            Optional.ofNullable(source.getUiOrder()).ifPresent(e -> row.put("UiOrder", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
