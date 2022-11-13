package com.example.building.dao;

import com.example.building.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindowDao extends JpaRepository<Window, Long> {
}
