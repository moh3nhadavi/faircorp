package com.example.building.dto;

import com.example.building.model.Building;
import com.example.building.model.Room;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BuildingDto {
    private String username;

    private String name;

    private Double out_temperature;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.username = building.getUsername();
        this.name = building.getName();
        this.out_temperature = building.getOut_temperature();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOut_temperature(Double out_temperature) {
        this.out_temperature = out_temperature;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Double getOut_temperature() {
        return out_temperature;
    }
}
