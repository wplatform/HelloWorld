package com.rainbowland.service.characters.domain;

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
@Table("item_instance_azerite_empowered")
public class ItemInstanceAzeriteEmpowered {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("azeritePowerId1")
    private Integer azeritePowerId1;
    @Column("azeritePowerId2")
    private Integer azeritePowerId2;
    @Column("azeritePowerId3")
    private Integer azeritePowerId3;
    @Column("azeritePowerId4")
    private Integer azeritePowerId4;
    @Column("azeritePowerId5")
    private Integer azeritePowerId5;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceAzeriteEmpowered> {

        public ItemInstanceAzeriteEmpowered convert(Row row) {
            ItemInstanceAzeriteEmpowered domain = new ItemInstanceAzeriteEmpowered();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setAzeritePowerId1(row.get("azeritePowerId1", Integer.class));
            domain.setAzeritePowerId2(row.get("azeritePowerId2", Integer.class));
            domain.setAzeritePowerId3(row.get("azeritePowerId3", Integer.class));
            domain.setAzeritePowerId4(row.get("azeritePowerId4", Integer.class));
            domain.setAzeritePowerId5(row.get("azeritePowerId5", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceAzeriteEmpowered, OutboundRow> {

        public OutboundRow convert(ItemInstanceAzeriteEmpowered source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerId1()).ifPresent(e -> row.put("azeritePowerId1", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerId2()).ifPresent(e -> row.put("azeritePowerId2", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerId3()).ifPresent(e -> row.put("azeritePowerId3", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerId4()).ifPresent(e -> row.put("azeritePowerId4", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerId5()).ifPresent(e -> row.put("azeritePowerId5", Parameter.from(e)));
            return row;
        }
    }

}
