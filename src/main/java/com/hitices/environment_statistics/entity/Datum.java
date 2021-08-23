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
@Table(name ="Data")
public class Datum
{
    @GenericGenerator(name = "datumId", strategy = "uuid")
    @GeneratedValue(generator = "datumId")
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "SchemaId")
    private String schemaId;

    @Column(name = "UpdateTime")
    private Date updateTime;

    @Column(name="Value")
    @Lob
    public String value;
    public Datum()
    {

    }
}
