package com.cinema.collection.service.back.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.Objects;

import static java.sql.Types.LONGVARCHAR;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "collections")
@AllArgsConstructor
@Builder
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private boolean enable;

    private Long previewId;

    @Lob
    @JdbcTypeCode(LONGVARCHAR)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_category_id")
    private Categories categories;

    public Collection(String name, Categories categories) {
        this.name = name;
        this.categories = categories;
        this.enable = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Collection that = (Collection) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
