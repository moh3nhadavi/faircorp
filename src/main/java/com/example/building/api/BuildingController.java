package com.example.building.api;


import com.example.building.dao.BuildingDao;
import com.example.building.dto.BuildingDto;
import com.example.building.model.Building;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController {
    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    @GetMapping(path = "/{username}")
    public BuildingDto findByUsername(@PathVariable String username){
        Building building = buildingDao.findByUsernameIgnoreCase(username);
        return new BuildingDto(building);
    }
}
