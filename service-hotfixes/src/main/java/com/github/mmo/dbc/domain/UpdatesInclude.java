package com.github.mmo.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "updates_include")
public class UpdatesInclude {
    @Id
    @Column(name = "path", nullable = false, length = 200)
    private String path;

    @ColumnDefault("'RELEASED'")
    @Lob
    @Column(name = "state", nullable = false)
    private String state;

}