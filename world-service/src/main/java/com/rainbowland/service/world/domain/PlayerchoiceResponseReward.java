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
@Table("playerchoice_response_reward")
public class PlayerchoiceResponseReward {

    @Column("ChoiceId")
    private Integer choiceId;
    @Column("ResponseId")
    private Integer responseId;
    @Column("TitleId")
    private Integer titleId;
    @Column("PackageId")
    private Integer packageId;
    @Column("SkillLineId")
    private Integer skillLineId;
    @Column("SkillPointCount")
    private Integer skillPointCount;
    @Column("ArenaPointCount")
    private Integer arenaPointCount;
    @Column("HonorPointCount")
    private Integer honorPointCount;
    @Column("Money")
    private Long money;
    @Column("Xp")
    private Integer xp;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerchoiceResponseReward> {

        public PlayerchoiceResponseReward convert(Row row) {
            PlayerchoiceResponseReward domain = new PlayerchoiceResponseReward();
            domain.setChoiceId(row.get("ChoiceId", Integer.class));
            domain.setResponseId(row.get("ResponseId", Integer.class));
            domain.setTitleId(row.get("TitleId", Integer.class));
            domain.setPackageId(row.get("PackageId", Integer.class));
            domain.setSkillLineId(row.get("SkillLineId", Integer.class));
            domain.setSkillPointCount(row.get("SkillPointCount", Integer.class));
            domain.setArenaPointCount(row.get("ArenaPointCount", Integer.class));
            domain.setHonorPointCount(row.get("HonorPointCount", Integer.class));
            domain.setMoney(row.get("Money", Long.class));
            domain.setXp(row.get("Xp", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerchoiceResponseReward, OutboundRow> {

        public OutboundRow convert(PlayerchoiceResponseReward source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getChoiceId()).ifPresent(e -> row.put("ChoiceId", Parameter.from(e)));
            Optional.ofNullable(source.getResponseId()).ifPresent(e -> row.put("ResponseId", Parameter.from(e)));
            Optional.ofNullable(source.getTitleId()).ifPresent(e -> row.put("TitleId", Parameter.from(e)));
            Optional.ofNullable(source.getPackageId()).ifPresent(e -> row.put("PackageId", Parameter.from(e)));
            Optional.ofNullable(source.getSkillLineId()).ifPresent(e -> row.put("SkillLineId", Parameter.from(e)));
            Optional.ofNullable(source.getSkillPointCount()).ifPresent(e -> row.put("SkillPointCount", Parameter.from(e)));
            Optional.ofNullable(source.getArenaPointCount()).ifPresent(e -> row.put("ArenaPointCount", Parameter.from(e)));
            Optional.ofNullable(source.getHonorPointCount()).ifPresent(e -> row.put("HonorPointCount", Parameter.from(e)));
            Optional.ofNullable(source.getMoney()).ifPresent(e -> row.put("Money", Parameter.from(e)));
            Optional.ofNullable(source.getXp()).ifPresent(e -> row.put("Xp", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
