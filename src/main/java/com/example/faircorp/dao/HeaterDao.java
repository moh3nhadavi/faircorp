package com.example.faircorp.dao;

import com.example.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long> {
    List<Heater> findByRoomId(Long room_id);
}
