package com.hitices.environment_statistics.bean;

import com.hitices.environment_statistics.entity.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchemaBean
{
    private String id;
    private String name;
    private String description;
    private List<SchemaFieldBean> fields;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SchemaFieldBean{
        private String name;
        private String description;
        private FieldType type;
        private String value;
    }
}
