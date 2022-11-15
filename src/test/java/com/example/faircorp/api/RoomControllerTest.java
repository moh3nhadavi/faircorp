package com.example.faircorp.api;

import com.example.faircorp.dao.BuildingDao;
import com.example.faircorp.dao.RoomDao;
import com.example.faircorp.dto.RoomDto;
import com.example.faircorp.model.Building;
import com.example.faircorp.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoomController.class)
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RoomDao roomDao;

    @MockBean
    private BuildingDao buildingDao;

    @Test
    void findAll() throws Exception {

//        given(roomDao.findAll()).willReturn(List.of(
//                createRoom("r1"),
//                createRoom("r2")
//        ));
//
//        mockMvc.perform(get("/api/buildings/mmm/rooms").accept(APPLICATION_JSON))
//                // check the HTTP response
//                .andExpect(status().isOk())
//                // the content can be tested with Json path
//                .andExpect(jsonPath("[*].name").value(containsInAnyOrder("r1", "r2")));
    }

    @Test
    void ShouldUpdateRoom() throws Exception {
//        Room expectedRoom = createRoom("Room 1");
//        expectedRoom.setId(1L);
//        String json = objectMapper.writeValueAsString(new RoomDto(expectedRoom));
//
//        given(buildingDao.getReferenceById(any())).willReturn(expectedRoom.getBuilding());
//        given(roomDao.getReferenceById(anyLong())).willReturn(expectedRoom);
//
//        mockMvc.perform(post("/api/buildings/mmm/rooms").content(json).contentType(APPLICATION_JSON_VALUE))
//                // check the HTTP response
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Room 1"))
//                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    void shouldDeleteRoom() throws Exception {
        mockMvc.perform(delete("/api/buildings/mmm/rooms/999"))
                .andExpect(status().isOk());
    }

    private Room createRoom(String name) {
        Building building = buildingDao.findByUsernameIgnoreCase("mmm");
        return new Room(name, 1, 19.0, 12.2, building);
    }
}