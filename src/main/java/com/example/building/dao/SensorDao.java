package com.example.building.dao;

import com.example.building.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDao extends JpaRepository<Sensor,Long> {
}
