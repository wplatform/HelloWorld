package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ip_banned")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpBanned {
    
    @Id
    @Column("ip")
    private String ip;
    
    @Column("bandate")
    private Long banDate;
    
    @Column("unbandate")
    private Long unbanDate;
    
    @Column("bannedby")
    private String bannedBy;
    
    @Column("banreason")
    private String banReason;
}
