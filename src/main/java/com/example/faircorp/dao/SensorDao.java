package com.example.faircorp.dao;

import com.example.faircorp.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDao extends JpaRepository<Sensor,Long> {
}
