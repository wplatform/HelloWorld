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
@Table("modifier_tree")
public class ModifierTree {

    @Column("ID")
    private Integer id;
    @Column("Parent")
    private Integer parent;
    @Column("Operator")
    private Integer operator;
    @Column("Amount")
    private Integer amount;
    @Column("Type")
    private Integer type;
    @Column("Asset")
    private Integer asset;
    @Column("SecondaryAsset")
    private Integer secondaryAsset;
    @Column("TertiaryAsset")
    private Integer tertiaryAsset;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ModifierTree> {

        public ModifierTree convert(Row row) {
            ModifierTree domain = new ModifierTree();
            domain.setId(row.get("ID", Integer.class));
            domain.setParent(row.get("Parent", Integer.class));
            domain.setOperator(row.get("Operator", Integer.class));
            domain.setAmount(row.get("Amount", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setAsset(row.get("Asset", Integer.class));
            domain.setSecondaryAsset(row.get("SecondaryAsset", Integer.class));
            domain.setTertiaryAsset(row.get("TertiaryAsset", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ModifierTree, OutboundRow> {

        public OutboundRow convert(ModifierTree source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getParent()).ifPresent(e -> row.put("Parent", Parameter.from(e)));
            Optional.ofNullable(source.getOperator()).ifPresent(e -> row.put("Operator", Parameter.from(e)));
            Optional.ofNullable(source.getAmount()).ifPresent(e -> row.put("Amount", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getAsset()).ifPresent(e -> row.put("Asset", Parameter.from(e)));
            Optional.ofNullable(source.getSecondaryAsset()).ifPresent(e -> row.put("SecondaryAsset", Parameter.from(e)));
            Optional.ofNullable(source.getTertiaryAsset()).ifPresent(e -> row.put("TertiaryAsset", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
