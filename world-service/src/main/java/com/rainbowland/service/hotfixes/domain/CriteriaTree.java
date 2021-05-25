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
@Table("criteria_tree")
public class CriteriaTree {

    @Column("ID")
    private Integer id;
    @Column("Description")
    private String description;
    @Column("Parent")
    private Integer parent;
    @Column("Amount")
    private Integer amount;
    @Column("Operator")
    private Integer operator;
    @Column("CriteriaID")
    private Integer criteriaId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CriteriaTree> {

        public CriteriaTree convert(Row row) {
            CriteriaTree domain = new CriteriaTree();
            domain.setId(row.get("ID", Integer.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setParent(row.get("Parent", Integer.class));
            domain.setAmount(row.get("Amount", Integer.class));
            domain.setOperator(row.get("Operator", Integer.class));
            domain.setCriteriaId(row.get("CriteriaID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CriteriaTree, OutboundRow> {

        public OutboundRow convert(CriteriaTree source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getParent()).ifPresent(e -> row.put("Parent", Parameter.from(e)));
            Optional.ofNullable(source.getAmount()).ifPresent(e -> row.put("Amount", Parameter.from(e)));
            Optional.ofNullable(source.getOperator()).ifPresent(e -> row.put("Operator", Parameter.from(e)));
            Optional.ofNullable(source.getCriteriaId()).ifPresent(e -> row.put("CriteriaID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
