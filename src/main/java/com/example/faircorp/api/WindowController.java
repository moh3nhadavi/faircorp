package com.example.faircorp.api;

import com.example.faircorp.dao.WindowDao;
import com.example.faircorp.dao.RoomDao;
import com.example.faircorp.dto.WindowDto;
import com.example.faircorp.model.Window;
import com.example.faircorp.model.WindowStatus;
import com.example.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/rooms/{room_id}/windows")
public class WindowController {
    private WindowDao windowDao;
    private RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<WindowDto> findAll(@PathVariable Long room_id) {
        return windowDao.findByRoomId(room_id).stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null); // (7)
    }

    @PostMapping
    public WindowDto create(@PathVariable Long room_id, @RequestBody WindowDto windowDto) {
        Room room = roomDao.getReferenceById(room_id);
        Window window = null;
        if (windowDto.getId() == null) {
            window = windowDao.save(new Window(windowDto.getName(), windowDto.getStatus(), room));
        } else {
            window = windowDao.getReferenceById(windowDto.getId());
            window.setStatus(windowDto.getStatus());
            window.setName(windowDto.getName());
            window.setRoom(room);
            window = windowDao.save(window);
        }
        return new WindowDto(window);
    }

    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setStatus(window.getStatus() == WindowStatus.OPEN ? WindowStatus.CLOSE : WindowStatus.OPEN);
        window = windowDao.save(window);
        return new WindowDto(window);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}
