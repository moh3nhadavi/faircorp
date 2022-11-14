package com.example.faircorp.api;


import com.example.faircorp.dao.BuildingDao;
import com.example.faircorp.dto.BuildingDto;
import com.example.faircorp.model.Building;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/buildings")
public class BuildingController {
    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    @GetMapping(path = "/{username}")
    public Object findByUsername(@PathVariable String username){
        Building building = buildingDao.findByUsernameIgnoreCase(username);
        if(building == null) return "";
        return new BuildingDto(building);
    }
}
