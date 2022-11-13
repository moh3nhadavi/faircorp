package com.example.faircorp.dao;

import com.example.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long> {
    List<Room> findByBuildingUsernameIgnoreCase(String building_username);
    List<Room> findByNameContainsAndBuildingUsernameIgnoreCase(String searchText,String building_username);
}
