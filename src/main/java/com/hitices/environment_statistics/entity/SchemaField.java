package com.hitices.environment_statistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "SchemaFields")
@IdClass(SchemaField.SchemaFieldPrimaryKey.class)
public class SchemaField implements Serializable
{
    @Embeddable
    @Getter
    @Setter
    public static class SchemaFieldPrimaryKey implements Serializable{
        private String schemaId;
        private Integer index;

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SchemaFieldPrimaryKey that = (SchemaFieldPrimaryKey) o;
            return Objects.equals(schemaId, that.schemaId) && Objects.equals(index, that.index);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(schemaId, index);
        }
    }
    @Id
    @Column(name = "SchemaId")
    private String schemaId;
    @Id
    @Column(name = "Index")
    private Integer index;
    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    private FieldType type;
    @Column(name="Name")
    private String name;
    @Column(name="Description")
    @Lob
    private String description;
    @Column(name="Value")
    @Lob
    private String value;
    public SchemaField()
    {

    }
}
