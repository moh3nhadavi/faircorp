package com.example.faircorp.dao;

import com.example.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long> {
    List<Window> findByRoomId(Long room_id);
}
