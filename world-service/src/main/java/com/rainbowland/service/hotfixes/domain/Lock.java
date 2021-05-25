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
@Table("lock")
public class Lock {

    @Column("ID")
    private Integer id;
    @Column("Flags")
    private Integer flags;
    @Column("Index1")
    private Integer index1;
    @Column("Index2")
    private Integer index2;
    @Column("Index3")
    private Integer index3;
    @Column("Index4")
    private Integer index4;
    @Column("Index5")
    private Integer index5;
    @Column("Index6")
    private Integer index6;
    @Column("Index7")
    private Integer index7;
    @Column("Index8")
    private Integer index8;
    @Column("Skill1")
    private Integer skill1;
    @Column("Skill2")
    private Integer skill2;
    @Column("Skill3")
    private Integer skill3;
    @Column("Skill4")
    private Integer skill4;
    @Column("Skill5")
    private Integer skill5;
    @Column("Skill6")
    private Integer skill6;
    @Column("Skill7")
    private Integer skill7;
    @Column("Skill8")
    private Integer skill8;
    @Column("Type1")
    private Integer type1;
    @Column("Type2")
    private Integer type2;
    @Column("Type3")
    private Integer type3;
    @Column("Type4")
    private Integer type4;
    @Column("Type5")
    private Integer type5;
    @Column("Type6")
    private Integer type6;
    @Column("Type7")
    private Integer type7;
    @Column("Type8")
    private Integer type8;
    @Column("Action1")
    private Integer action1;
    @Column("Action2")
    private Integer action2;
    @Column("Action3")
    private Integer action3;
    @Column("Action4")
    private Integer action4;
    @Column("Action5")
    private Integer action5;
    @Column("Action6")
    private Integer action6;
    @Column("Action7")
    private Integer action7;
    @Column("Action8")
    private Integer action8;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Lock> {

        public Lock convert(Row row) {
            Lock domain = new Lock();
            domain.setId(row.get("ID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setIndex1(row.get("Index1", Integer.class));
            domain.setIndex2(row.get("Index2", Integer.class));
            domain.setIndex3(row.get("Index3", Integer.class));
            domain.setIndex4(row.get("Index4", Integer.class));
            domain.setIndex5(row.get("Index5", Integer.class));
            domain.setIndex6(row.get("Index6", Integer.class));
            domain.setIndex7(row.get("Index7", Integer.class));
            domain.setIndex8(row.get("Index8", Integer.class));
            domain.setSkill1(row.get("Skill1", Integer.class));
            domain.setSkill2(row.get("Skill2", Integer.class));
            domain.setSkill3(row.get("Skill3", Integer.class));
            domain.setSkill4(row.get("Skill4", Integer.class));
            domain.setSkill5(row.get("Skill5", Integer.class));
            domain.setSkill6(row.get("Skill6", Integer.class));
            domain.setSkill7(row.get("Skill7", Integer.class));
            domain.setSkill8(row.get("Skill8", Integer.class));
            domain.setType1(row.get("Type1", Integer.class));
            domain.setType2(row.get("Type2", Integer.class));
            domain.setType3(row.get("Type3", Integer.class));
            domain.setType4(row.get("Type4", Integer.class));
            domain.setType5(row.get("Type5", Integer.class));
            domain.setType6(row.get("Type6", Integer.class));
            domain.setType7(row.get("Type7", Integer.class));
            domain.setType8(row.get("Type8", Integer.class));
            domain.setAction1(row.get("Action1", Integer.class));
            domain.setAction2(row.get("Action2", Integer.class));
            domain.setAction3(row.get("Action3", Integer.class));
            domain.setAction4(row.get("Action4", Integer.class));
            domain.setAction5(row.get("Action5", Integer.class));
            domain.setAction6(row.get("Action6", Integer.class));
            domain.setAction7(row.get("Action7", Integer.class));
            domain.setAction8(row.get("Action8", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Lock, OutboundRow> {

        public OutboundRow convert(Lock source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getIndex1()).ifPresent(e -> row.put("Index1", Parameter.from(e)));
            Optional.ofNullable(source.getIndex2()).ifPresent(e -> row.put("Index2", Parameter.from(e)));
            Optional.ofNullable(source.getIndex3()).ifPresent(e -> row.put("Index3", Parameter.from(e)));
            Optional.ofNullable(source.getIndex4()).ifPresent(e -> row.put("Index4", Parameter.from(e)));
            Optional.ofNullable(source.getIndex5()).ifPresent(e -> row.put("Index5", Parameter.from(e)));
            Optional.ofNullable(source.getIndex6()).ifPresent(e -> row.put("Index6", Parameter.from(e)));
            Optional.ofNullable(source.getIndex7()).ifPresent(e -> row.put("Index7", Parameter.from(e)));
            Optional.ofNullable(source.getIndex8()).ifPresent(e -> row.put("Index8", Parameter.from(e)));
            Optional.ofNullable(source.getSkill1()).ifPresent(e -> row.put("Skill1", Parameter.from(e)));
            Optional.ofNullable(source.getSkill2()).ifPresent(e -> row.put("Skill2", Parameter.from(e)));
            Optional.ofNullable(source.getSkill3()).ifPresent(e -> row.put("Skill3", Parameter.from(e)));
            Optional.ofNullable(source.getSkill4()).ifPresent(e -> row.put("Skill4", Parameter.from(e)));
            Optional.ofNullable(source.getSkill5()).ifPresent(e -> row.put("Skill5", Parameter.from(e)));
            Optional.ofNullable(source.getSkill6()).ifPresent(e -> row.put("Skill6", Parameter.from(e)));
            Optional.ofNullable(source.getSkill7()).ifPresent(e -> row.put("Skill7", Parameter.from(e)));
            Optional.ofNullable(source.getSkill8()).ifPresent(e -> row.put("Skill8", Parameter.from(e)));
            Optional.ofNullable(source.getType1()).ifPresent(e -> row.put("Type1", Parameter.from(e)));
            Optional.ofNullable(source.getType2()).ifPresent(e -> row.put("Type2", Parameter.from(e)));
            Optional.ofNullable(source.getType3()).ifPresent(e -> row.put("Type3", Parameter.from(e)));
            Optional.ofNullable(source.getType4()).ifPresent(e -> row.put("Type4", Parameter.from(e)));
            Optional.ofNullable(source.getType5()).ifPresent(e -> row.put("Type5", Parameter.from(e)));
            Optional.ofNullable(source.getType6()).ifPresent(e -> row.put("Type6", Parameter.from(e)));
            Optional.ofNullable(source.getType7()).ifPresent(e -> row.put("Type7", Parameter.from(e)));
            Optional.ofNullable(source.getType8()).ifPresent(e -> row.put("Type8", Parameter.from(e)));
            Optional.ofNullable(source.getAction1()).ifPresent(e -> row.put("Action1", Parameter.from(e)));
            Optional.ofNullable(source.getAction2()).ifPresent(e -> row.put("Action2", Parameter.from(e)));
            Optional.ofNullable(source.getAction3()).ifPresent(e -> row.put("Action3", Parameter.from(e)));
            Optional.ofNullable(source.getAction4()).ifPresent(e -> row.put("Action4", Parameter.from(e)));
            Optional.ofNullable(source.getAction5()).ifPresent(e -> row.put("Action5", Parameter.from(e)));
            Optional.ofNullable(source.getAction6()).ifPresent(e -> row.put("Action6", Parameter.from(e)));
            Optional.ofNullable(source.getAction7()).ifPresent(e -> row.put("Action7", Parameter.from(e)));
            Optional.ofNullable(source.getAction8()).ifPresent(e -> row.put("Action8", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
