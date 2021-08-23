package com.hitices.environment_statistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Schemas")
public class Schema
{
    @GenericGenerator(name = "schemaId", strategy = "uuid")
    @GeneratedValue(generator = "schemaId")
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name="Name")
    private String name;
    @Column(name="Description")
    @Lob
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SchemaId", referencedColumnName = "Id")
    @OrderBy(value="index ASC")
    private List<SchemaField> fields;

    public Schema()
    {
        fields = new ArrayList<>();
    }
}
