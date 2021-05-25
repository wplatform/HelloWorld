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
@Table("garr_class_spec")
public class GarrClassSpec {

    @Column("ClassSpec")
    private String classSpec;
    @Column("ClassSpecMale")
    private String classSpecMale;
    @Column("ClassSpecFemale")
    private String classSpecFemale;
    @Column("ID")
    private Integer id;
    @Column("UiTextureAtlasMemberID")
    private Integer uiTextureAtlasMemberId;
    @Column("GarrFollItemSetID")
    private Integer garrFollItemSetId;
    @Column("FollowerClassLimit")
    private Integer followerClassLimit;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrClassSpec> {

        public GarrClassSpec convert(Row row) {
            GarrClassSpec domain = new GarrClassSpec();
            domain.setClassSpec(row.get("ClassSpec", String.class));
            domain.setClassSpecMale(row.get("ClassSpecMale", String.class));
            domain.setClassSpecFemale(row.get("ClassSpecFemale", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setUiTextureAtlasMemberId(row.get("UiTextureAtlasMemberID", Integer.class));
            domain.setGarrFollItemSetId(row.get("GarrFollItemSetID", Integer.class));
            domain.setFollowerClassLimit(row.get("FollowerClassLimit", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrClassSpec, OutboundRow> {

        public OutboundRow convert(GarrClassSpec source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getClassSpec()).ifPresent(e -> row.put("ClassSpec", Parameter.from(e)));
            Optional.ofNullable(source.getClassSpecMale()).ifPresent(e -> row.put("ClassSpecMale", Parameter.from(e)));
            Optional.ofNullable(source.getClassSpecFemale()).ifPresent(e -> row.put("ClassSpecFemale", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureAtlasMemberId()).ifPresent(e -> row.put("UiTextureAtlasMemberID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrFollItemSetId()).ifPresent(e -> row.put("GarrFollItemSetID", Parameter.from(e)));
            Optional.ofNullable(source.getFollowerClassLimit()).ifPresent(e -> row.put("FollowerClassLimit", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
