package com.example.faircorp.api;

import com.example.faircorp.dao.RoomDao;
import com.example.faircorp.dao.SensorDao;
import com.example.faircorp.dto.SensorDto;
import com.example.faircorp.model.Room;
import com.example.faircorp.model.Sensor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    private SensorDao sensorDao;
    private RoomDao roomDao;

    public SensorController(SensorDao sensorDao, RoomDao roomDao) {
        this.sensorDao = sensorDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<SensorDto> findAll() {
        return sensorDao.findAll().stream().map(SensorDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public SensorDto findById(@PathVariable Long id) {
        return sensorDao.findById(id).map(SensorDto::new).orElse(null); // (7)
    }

    @PostMapping
    public SensorDto create(@RequestBody SensorDto sensorDto) {
        Room room = roomDao.getReferenceById(sensorDto.getRoom_id());
        Sensor sensor = null;
        if (sensorDto.getId() == null) {
            sensor = sensorDao.save(new Sensor(sensorDto.getName(), sensorDto.getTemperature(), room));
        } else {
            sensor = sensorDao.getReferenceById(sensorDto.getId());
            sensor.setTemperature(sensorDto.getTemperature());
            sensor.setName(sensorDto.getName());
            sensor.setRoom(room);
            sensor = sensorDao.save(sensor);
        }
        return new SensorDto(sensor);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        sensorDao.deleteById(id);
    }
}
