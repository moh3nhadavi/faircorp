package com.example.faircorp.api;

import com.example.faircorp.dao.RoomDao;
import com.example.faircorp.dto.RoomDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
public class SingleRoomController {
    private final RoomDao roomDao;
    public SingleRoomController(RoomDao roomDao){
        this.roomDao = roomDao;
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }
}
