package com.hitices.environment_statistics.dao;

import com.hitices.environment_statistics.entity.Schema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemaRepository extends JpaRepository<Schema, String>
{
}
