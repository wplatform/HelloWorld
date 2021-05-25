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
@Table("pvp_talent_category")
public class PvpTalentCategory {

    @Column("ID")
    private Integer id;
    @Column("TalentSlotMask")
    private Integer talentSlotMask;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PvpTalentCategory> {

        public PvpTalentCategory convert(Row row) {
            PvpTalentCategory domain = new PvpTalentCategory();
            domain.setId(row.get("ID", Integer.class));
            domain.setTalentSlotMask(row.get("TalentSlotMask", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PvpTalentCategory, OutboundRow> {

        public OutboundRow convert(PvpTalentCategory source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getTalentSlotMask()).ifPresent(e -> row.put("TalentSlotMask", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
