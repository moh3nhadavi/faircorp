package com.example.faircorp.dao;

import com.example.faircorp.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, String> {
    Building findByUsernameIgnoreCase(String username);
}
