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
@Table("chr_customization_element")
public class ChrCustomizationElement {

    @Column("ID")
    private Integer id;
    @Column("ChrCustomizationChoiceID")
    private Integer chrCustomizationChoiceId;
    @Column("RelatedChrCustomizationChoiceID")
    private Integer relatedChrCustomizationChoiceId;
    @Column("ChrCustomizationGeosetID")
    private Integer chrCustomizationGeosetId;
    @Column("ChrCustomizationSkinnedModelID")
    private Integer chrCustomizationSkinnedModelId;
    @Column("ChrCustomizationMaterialID")
    private Integer chrCustomizationMaterialId;
    @Column("ChrCustomizationBoneSetID")
    private Integer chrCustomizationBoneSetId;
    @Column("ChrCustomizationCondModelID")
    private Integer chrCustomizationCondModelId;
    @Column("ChrCustomizationDisplayInfoID")
    private Integer chrCustomizationDisplayInfoId;
    @Column("ChrCustItemGeoModifyID")
    private Integer chrCustItemGeoModifyId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrCustomizationElement> {

        public ChrCustomizationElement convert(Row row) {
            ChrCustomizationElement domain = new ChrCustomizationElement();
            domain.setId(row.get("ID", Integer.class));
            domain.setChrCustomizationChoiceId(row.get("ChrCustomizationChoiceID", Integer.class));
            domain.setRelatedChrCustomizationChoiceId(row.get("RelatedChrCustomizationChoiceID", Integer.class));
            domain.setChrCustomizationGeosetId(row.get("ChrCustomizationGeosetID", Integer.class));
            domain.setChrCustomizationSkinnedModelId(row.get("ChrCustomizationSkinnedModelID", Integer.class));
            domain.setChrCustomizationMaterialId(row.get("ChrCustomizationMaterialID", Integer.class));
            domain.setChrCustomizationBoneSetId(row.get("ChrCustomizationBoneSetID", Integer.class));
            domain.setChrCustomizationCondModelId(row.get("ChrCustomizationCondModelID", Integer.class));
            domain.setChrCustomizationDisplayInfoId(row.get("ChrCustomizationDisplayInfoID", Integer.class));
            domain.setChrCustItemGeoModifyId(row.get("ChrCustItemGeoModifyID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrCustomizationElement, OutboundRow> {

        public OutboundRow convert(ChrCustomizationElement source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationChoiceId()).ifPresent(e -> row.put("ChrCustomizationChoiceID", Parameter.from(e)));
            Optional.ofNullable(source.getRelatedChrCustomizationChoiceId()).ifPresent(e -> row.put("RelatedChrCustomizationChoiceID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationGeosetId()).ifPresent(e -> row.put("ChrCustomizationGeosetID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationSkinnedModelId()).ifPresent(e -> row.put("ChrCustomizationSkinnedModelID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationMaterialId()).ifPresent(e -> row.put("ChrCustomizationMaterialID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationBoneSetId()).ifPresent(e -> row.put("ChrCustomizationBoneSetID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationCondModelId()).ifPresent(e -> row.put("ChrCustomizationCondModelID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationDisplayInfoId()).ifPresent(e -> row.put("ChrCustomizationDisplayInfoID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustItemGeoModifyId()).ifPresent(e -> row.put("ChrCustItemGeoModifyID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
