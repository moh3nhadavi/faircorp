package com.example.faircorp.dao;

import com.example.faircorp.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDao extends JpaRepository<Sensor,Long> {
    List<Sensor> findByRoomId(Long room_id);
}
