package com.example.faircorp.api;

import com.example.faircorp.dao.BuildingDao;
import com.example.faircorp.dao.RoomDao;
import com.example.faircorp.dto.RoomDto;
import com.example.faircorp.model.Building;
import com.example.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/buildings/{building_username}/rooms")
public class RoomController {
    private final BuildingDao buildingDao;
    private final RoomDao roomDao;

    public RoomController(BuildingDao buildingDao, RoomDao roomDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> findAll(@PathVariable String building_username) {
        return roomDao.findByBuildingUsernameIgnoreCase(building_username).stream().map(RoomDto::new).collect(Collectors.toList());
//        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    @GetMapping(path = "/search/{text}")
    public List<RoomDto> findByName(@PathVariable String building_username, @PathVariable String text) {
        return roomDao.findByNameContainsAndBuildingUsernameIgnoreCase(text, building_username).stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping(path = "/create")
    public RoomDto create(@PathVariable String building_username, @RequestBody RoomDto roomDto) throws Exception {
        Building building = buildingDao.findByUsernameIgnoreCase(building_username);
        if(building == null) throw new Exception();
        Room room = null;
        if (roomDto.getId() == null) {
            room = roomDao.save(new Room(roomDto.getName(), roomDto.getFloor(), roomDto.getCurrent_temperature(), roomDto.getTarget_temperature(), building));
        } else {
            room = roomDao.getReferenceById(roomDto.getId());
            room.setFloor(roomDto.getFloor());
            room.setName(roomDto.getName());
            room.setCurrent_temperature(roomDto.getCurrent_temperature());
            room.setTarget_temperature(roomDto.getTarget_temperature());
            room.setBuilding(building);
            room = roomDao.save(room);
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}
