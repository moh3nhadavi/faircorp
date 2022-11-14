package com.example.faircorp.api;

import com.example.faircorp.dao.HeaterDao;
import com.example.faircorp.dao.RoomDao;
import com.example.faircorp.dto.HeaterDto;
import com.example.faircorp.model.Heater;
import com.example.faircorp.model.HeaterStatus;
import com.example.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/rooms/{room_id}/heaters")
public class HeaterController {
    private HeaterDao heaterDao;
    private RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll(@PathVariable Long room_id) {
        return heaterDao.findByRoomId(room_id).stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }

    @PostMapping
    public HeaterDto create(@PathVariable Long room_id, @RequestBody HeaterDto heaterDto) {
        Room room = roomDao.getReferenceById(room_id);
        Heater heater = null;
        if (heaterDto.getId() == null) {
            heater = heaterDao.save(new Heater(heaterDto.getName(), heaterDto.getPower(), heaterDto.getStatus(), room));
        } else {
            heater = heaterDao.getReferenceById(heaterDto.getId());
            heater.setStatus(heaterDto.getStatus());
            heater.setName(heaterDto.getName());
            heater.setRoom(room);
            heater.setPower(heaterDto.getPower());
            heater = heaterDao.save(heater);
        }
        return new HeaterDto(heater);
    }

    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setStatus(heater.getStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        heater = heaterDao.save(heater);
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
