package com.example.building.dto;

import com.example.building.model.Heater;
import com.example.building.model.HeaterStatus;

public class HeaterDto {

    private Long id;
    private String name;
    private HeaterStatus status;
    private Integer power;
    private Long room_id;
    private String room_name;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.status = heater.getStatus();
        this.power = heater.getPower();
        this.room_id = heater.getRoom().getId();
        this.room_name = heater.getRoom().getName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(HeaterStatus status) {
        this.status = status;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_name() {
        return room_name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HeaterStatus getStatus() {
        return status;
    }

    public Integer getPower() {
        return power;
    }

    public Long getRoom_id() {
        return room_id;
    }

}
