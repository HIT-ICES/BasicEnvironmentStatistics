package com.hitices.environment_statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatumBean
{
    private String id;
    private String schemaId;
    private String[] values;
}
