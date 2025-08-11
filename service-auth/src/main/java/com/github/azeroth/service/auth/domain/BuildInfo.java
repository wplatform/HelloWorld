package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("build_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildInfo {
    
    @Id
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
}
