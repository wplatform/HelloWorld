package com.rainbowland.service.auth.domain;

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
@Table("build_info")
public class BuildInfo {

    @Column("build")
    private Long build;
    @Column("majorVersion")
    private Integer majorVersion;
    @Column("minorVersion")
    private Integer minorVersion;
    @Column("bugfixVersion")
    private Integer bugfixVersion;
    @Column("hotfixVersion")
    private String hotfixVersion;
    @Column("winAuthSeed")
    private String winAuthSeed;
    @Column("win64AuthSeed")
    private String win64AuthSeed;
    @Column("mac64AuthSeed")
    private String mac64AuthSeed;
    @Column("winChecksumSeed")
    private String winChecksumSeed;
    @Column("macChecksumSeed")
    private String macChecksumSeed;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BuildInfo> {

        public BuildInfo convert(Row row) {
            BuildInfo domain = new BuildInfo();
            domain.setBuild(row.get("build", Long.class));
            domain.setMajorVersion(row.get("majorVersion", Integer.class));
            domain.setMinorVersion(row.get("minorVersion", Integer.class));
            domain.setBugfixVersion(row.get("bugfixVersion", Integer.class));
            domain.setHotfixVersion(row.get("hotfixVersion", String.class));
            domain.setWinAuthSeed(row.get("winAuthSeed", String.class));
            domain.setWin64AuthSeed(row.get("win64AuthSeed", String.class));
            domain.setMac64AuthSeed(row.get("mac64AuthSeed", String.class));
            domain.setWinChecksumSeed(row.get("winChecksumSeed", String.class));
            domain.setMacChecksumSeed(row.get("macChecksumSeed", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BuildInfo, OutboundRow> {

        public OutboundRow convert(BuildInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getBuild()).ifPresent(e -> row.put("build", Parameter.from(e)));
            Optional.ofNullable(source.getMajorVersion()).ifPresent(e -> row.put("majorVersion", Parameter.from(e)));
            Optional.ofNullable(source.getMinorVersion()).ifPresent(e -> row.put("minorVersion", Parameter.from(e)));
            Optional.ofNullable(source.getBugfixVersion()).ifPresent(e -> row.put("bugfixVersion", Parameter.from(e)));
            Optional.ofNullable(source.getHotfixVersion()).ifPresent(e -> row.put("hotfixVersion", Parameter.from(e)));
            Optional.ofNullable(source.getWinAuthSeed()).ifPresent(e -> row.put("winAuthSeed", Parameter.from(e)));
            Optional.ofNullable(source.getWin64AuthSeed()).ifPresent(e -> row.put("win64AuthSeed", Parameter.from(e)));
            Optional.ofNullable(source.getMac64AuthSeed()).ifPresent(e -> row.put("mac64AuthSeed", Parameter.from(e)));
            Optional.ofNullable(source.getWinChecksumSeed()).ifPresent(e -> row.put("winChecksumSeed", Parameter.from(e)));
            Optional.ofNullable(source.getMacChecksumSeed()).ifPresent(e -> row.put("macChecksumSeed", Parameter.from(e)));
            return row;
        }
    }

}
