package com.github.mmo.dbc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Embeddable
public class HotfixBlobId implements Serializable {
    private static final long serialVersionUID = -1857299270108049483L;
    @Column(name = "TableHash", columnDefinition = "int UNSIGNED not null")
    private Long tableHash;

    @Column(name = "RecordId", nullable = false)
    private Integer recordId;

    @Column(name = "locale", nullable = false, length = 4)
    private String locale;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HotfixBlobId entity = (HotfixBlobId) o;
        return Objects.equals(this.recordId, entity.recordId) &&
                Objects.equals(this.locale, entity.locale) &&
                Objects.equals(this.tableHash, entity.tableHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, locale, tableHash);
    }

}