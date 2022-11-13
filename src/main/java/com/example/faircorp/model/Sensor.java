package com.example.faircorp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double temperature;

    public Sensor() {
    }

    public Sensor(String name, Double temperature, Room room) {
        this.name = name;
        this.temperature = temperature;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Room getRoom() {
        return room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @ManyToOne
    private Room room;
}
