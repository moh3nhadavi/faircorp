package com.example.building.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Building {
    @Id
    private String username;

    @NotNull
    private String name;

    private Double out_temperature;

    public Building() {
    }

    public Building(String username, String name, Double out_temperature) {
        this.username = username;
        this.name = name;
        this.out_temperature = out_temperature;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;
}
