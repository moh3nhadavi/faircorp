package com.example.building.dao;

import com.example.building.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, String> {
    Building findByUsernameIgnoreCase(String username);
}
