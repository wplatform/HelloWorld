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
@Table("destructible_model_data")
public class DestructibleModelData {

    @Column("ID")
    private Integer id;
    @Column("State0ImpactEffectDoodadSet")
    private Integer state0ImpactEffectDoodadSet;
    @Column("State0AmbientDoodadSet")
    private Integer state0AmbientDoodadSet;
    @Column("State1Wmo")
    private Integer state1Wmo;
    @Column("State1DestructionDoodadSet")
    private Integer state1DestructionDoodadSet;
    @Column("State1ImpactEffectDoodadSet")
    private Integer state1ImpactEffectDoodadSet;
    @Column("State1AmbientDoodadSet")
    private Integer state1AmbientDoodadSet;
    @Column("State2Wmo")
    private Integer state2Wmo;
    @Column("State2DestructionDoodadSet")
    private Integer state2DestructionDoodadSet;
    @Column("State2ImpactEffectDoodadSet")
    private Integer state2ImpactEffectDoodadSet;
    @Column("State2AmbientDoodadSet")
    private Integer state2AmbientDoodadSet;
    @Column("State3Wmo")
    private Integer state3Wmo;
    @Column("State3InitDoodadSet")
    private Integer state3InitDoodadSet;
    @Column("State3AmbientDoodadSet")
    private Integer state3AmbientDoodadSet;
    @Column("EjectDirection")
    private Integer ejectDirection;
    @Column("DoNotHighlight")
    private Integer doNotHighlight;
    @Column("State0Wmo")
    private Integer state0Wmo;
    @Column("HealEffect")
    private Integer healEffect;
    @Column("HealEffectSpeed")
    private Integer healEffectSpeed;
    @Column("State0NameSet")
    private Integer state0NameSet;
    @Column("State1NameSet")
    private Integer state1NameSet;
    @Column("State2NameSet")
    private Integer state2NameSet;
    @Column("State3NameSet")
    private Integer state3NameSet;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, DestructibleModelData> {

        public DestructibleModelData convert(Row row) {
            DestructibleModelData domain = new DestructibleModelData();
            domain.setId(row.get("ID", Integer.class));
            domain.setState0ImpactEffectDoodadSet(row.get("State0ImpactEffectDoodadSet", Integer.class));
            domain.setState0AmbientDoodadSet(row.get("State0AmbientDoodadSet", Integer.class));
            domain.setState1Wmo(row.get("State1Wmo", Integer.class));
            domain.setState1DestructionDoodadSet(row.get("State1DestructionDoodadSet", Integer.class));
            domain.setState1ImpactEffectDoodadSet(row.get("State1ImpactEffectDoodadSet", Integer.class));
            domain.setState1AmbientDoodadSet(row.get("State1AmbientDoodadSet", Integer.class));
            domain.setState2Wmo(row.get("State2Wmo", Integer.class));
            domain.setState2DestructionDoodadSet(row.get("State2DestructionDoodadSet", Integer.class));
            domain.setState2ImpactEffectDoodadSet(row.get("State2ImpactEffectDoodadSet", Integer.class));
            domain.setState2AmbientDoodadSet(row.get("State2AmbientDoodadSet", Integer.class));
            domain.setState3Wmo(row.get("State3Wmo", Integer.class));
            domain.setState3InitDoodadSet(row.get("State3InitDoodadSet", Integer.class));
            domain.setState3AmbientDoodadSet(row.get("State3AmbientDoodadSet", Integer.class));
            domain.setEjectDirection(row.get("EjectDirection", Integer.class));
            domain.setDoNotHighlight(row.get("DoNotHighlight", Integer.class));
            domain.setState0Wmo(row.get("State0Wmo", Integer.class));
            domain.setHealEffect(row.get("HealEffect", Integer.class));
            domain.setHealEffectSpeed(row.get("HealEffectSpeed", Integer.class));
            domain.setState0NameSet(row.get("State0NameSet", Integer.class));
            domain.setState1NameSet(row.get("State1NameSet", Integer.class));
            domain.setState2NameSet(row.get("State2NameSet", Integer.class));
            domain.setState3NameSet(row.get("State3NameSet", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<DestructibleModelData, OutboundRow> {

        public OutboundRow convert(DestructibleModelData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getState0ImpactEffectDoodadSet()).ifPresent(e -> row.put("State0ImpactEffectDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState0AmbientDoodadSet()).ifPresent(e -> row.put("State0AmbientDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState1Wmo()).ifPresent(e -> row.put("State1Wmo", Parameter.from(e)));
            Optional.ofNullable(source.getState1DestructionDoodadSet()).ifPresent(e -> row.put("State1DestructionDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState1ImpactEffectDoodadSet()).ifPresent(e -> row.put("State1ImpactEffectDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState1AmbientDoodadSet()).ifPresent(e -> row.put("State1AmbientDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState2Wmo()).ifPresent(e -> row.put("State2Wmo", Parameter.from(e)));
            Optional.ofNullable(source.getState2DestructionDoodadSet()).ifPresent(e -> row.put("State2DestructionDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState2ImpactEffectDoodadSet()).ifPresent(e -> row.put("State2ImpactEffectDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState2AmbientDoodadSet()).ifPresent(e -> row.put("State2AmbientDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState3Wmo()).ifPresent(e -> row.put("State3Wmo", Parameter.from(e)));
            Optional.ofNullable(source.getState3InitDoodadSet()).ifPresent(e -> row.put("State3InitDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getState3AmbientDoodadSet()).ifPresent(e -> row.put("State3AmbientDoodadSet", Parameter.from(e)));
            Optional.ofNullable(source.getEjectDirection()).ifPresent(e -> row.put("EjectDirection", Parameter.from(e)));
            Optional.ofNullable(source.getDoNotHighlight()).ifPresent(e -> row.put("DoNotHighlight", Parameter.from(e)));
            Optional.ofNullable(source.getState0Wmo()).ifPresent(e -> row.put("State0Wmo", Parameter.from(e)));
            Optional.ofNullable(source.getHealEffect()).ifPresent(e -> row.put("HealEffect", Parameter.from(e)));
            Optional.ofNullable(source.getHealEffectSpeed()).ifPresent(e -> row.put("HealEffectSpeed", Parameter.from(e)));
            Optional.ofNullable(source.getState0NameSet()).ifPresent(e -> row.put("State0NameSet", Parameter.from(e)));
            Optional.ofNullable(source.getState1NameSet()).ifPresent(e -> row.put("State1NameSet", Parameter.from(e)));
            Optional.ofNullable(source.getState2NameSet()).ifPresent(e -> row.put("State2NameSet", Parameter.from(e)));
            Optional.ofNullable(source.getState3NameSet()).ifPresent(e -> row.put("State3NameSet", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
