package com.example.faircorp.dto;

import com.example.faircorp.model.Sensor;

public class SensorDto {
    private Long id;
    private String name;
    private Double temperature;
    private Long room_id;
    private String room_name;

    public SensorDto() {
    }

    public SensorDto(Sensor sensor) {
        this.id = sensor.getId();
        this.name = sensor.getName();
        this.temperature = sensor.getTemperature();
        this.room_id = sensor.getRoom().getId();
        this.room_name = sensor.getRoom().getName();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public String getRoom_name() {
        return room_name;
    }
}
