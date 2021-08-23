package com.hitices.environment_statistics.dao;

import com.hitices.environment_statistics.entity.Datum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatumRepository extends JpaRepository<Datum, String>
{
}
