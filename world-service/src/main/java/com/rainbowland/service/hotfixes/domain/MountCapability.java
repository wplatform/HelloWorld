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
@Table("mount_capability")
public class MountCapability {

    @Column("ID")
    private Integer id;
    @Column("Flags")
    private Integer flags;
    @Column("ReqRidingSkill")
    private Integer reqRidingSkill;
    @Column("ReqAreaID")
    private Integer reqAreaId;
    @Column("ReqSpellAuraID")
    private Integer reqSpellAuraId;
    @Column("ReqSpellKnownID")
    private Integer reqSpellKnownId;
    @Column("ModSpellAuraID")
    private Integer modSpellAuraId;
    @Column("ReqMapID")
    private Integer reqMapId;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MountCapability> {

        public MountCapability convert(Row row) {
            MountCapability domain = new MountCapability();
            domain.setId(row.get("ID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setReqRidingSkill(row.get("ReqRidingSkill", Integer.class));
            domain.setReqAreaId(row.get("ReqAreaID", Integer.class));
            domain.setReqSpellAuraId(row.get("ReqSpellAuraID", Integer.class));
            domain.setReqSpellKnownId(row.get("ReqSpellKnownID", Integer.class));
            domain.setModSpellAuraId(row.get("ModSpellAuraID", Integer.class));
            domain.setReqMapId(row.get("ReqMapID", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MountCapability, OutboundRow> {

        public OutboundRow convert(MountCapability source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getReqRidingSkill()).ifPresent(e -> row.put("ReqRidingSkill", Parameter.from(e)));
            Optional.ofNullable(source.getReqAreaId()).ifPresent(e -> row.put("ReqAreaID", Parameter.from(e)));
            Optional.ofNullable(source.getReqSpellAuraId()).ifPresent(e -> row.put("ReqSpellAuraID", Parameter.from(e)));
            Optional.ofNullable(source.getReqSpellKnownId()).ifPresent(e -> row.put("ReqSpellKnownID", Parameter.from(e)));
            Optional.ofNullable(source.getModSpellAuraId()).ifPresent(e -> row.put("ModSpellAuraID", Parameter.from(e)));
            Optional.ofNullable(source.getReqMapId()).ifPresent(e -> row.put("ReqMapID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
