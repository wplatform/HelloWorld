package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "gm_complaint")
public class GmComplaint {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "playerGuid", nullable = false)
    private Long playerGuid;

    @Lob
    @Column(name = "note", nullable = false)
    private String note;

    @ColumnDefault("0")
    @Column(name = "createTime", nullable = false)
    private Long createTime;

    @ColumnDefault("'0'")
    @Column(name = "mapId", columnDefinition = "smallint UNSIGNED not null")
    private Integer mapId;

    @ColumnDefault("0")
    @Column(name = "posX", nullable = false)
    private Float posX;

    @ColumnDefault("0")
    @Column(name = "posY", nullable = false)
    private Float posY;

    @ColumnDefault("0")
    @Column(name = "posZ", nullable = false)
    private Float posZ;

    @ColumnDefault("0")
    @Column(name = "facing", nullable = false)
    private Float facing;

    @Column(name = "targetCharacterGuid", nullable = false)
    private Long targetCharacterGuid;

    @ColumnDefault("0")
    @Column(name = "reportType", nullable = false)
    private Integer reportType;

    @ColumnDefault("0")
    @Column(name = "reportMajorCategory", nullable = false)
    private Integer reportMajorCategory;

    @ColumnDefault("0")
    @Column(name = "reportMinorCategoryFlags", nullable = false)
    private Integer reportMinorCategoryFlags;

    @Column(name = "reportLineIndex", nullable = false)
    private Integer reportLineIndex;

    @ColumnDefault("0")
    @Column(name = "closedBy", nullable = false)
    private Long closedBy;

    @ColumnDefault("'0'")
    @Column(name = "assignedTo", nullable = false)
    private Long assignedTo;

    @Lob
    @Column(name = "comment", nullable = false)
    private String comment;

}