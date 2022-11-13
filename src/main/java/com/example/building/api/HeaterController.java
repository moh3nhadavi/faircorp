package com.example.building.api;

import com.example.building.dao.HeaterDao;
import com.example.building.dao.RoomDao;
import com.example.building.dto.HeaterDto;
import com.example.building.model.Heater;
import com.example.building.model.HeaterStatus;
import com.example.building.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/heaters")
public class HeaterController {
    private HeaterDao heaterDao;
    private RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }

    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto heaterDto) {
        Room room = roomDao.getReferenceById(heaterDto.getRoom_id());
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
        heater.setStatus(heater.getStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        heater = heaterDao.save(heater);
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
