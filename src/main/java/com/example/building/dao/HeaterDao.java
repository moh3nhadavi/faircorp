package com.example.building.dao;

import com.example.building.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaterDao extends JpaRepository<Heater, Long> {
}
