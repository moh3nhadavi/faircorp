package com.example.faircorp.dto;

import com.example.faircorp.model.Room;

public class RoomDto {

    private Long id;
    private String name;
    private Integer floor;
    private Double current_temperature;
    private Double target_temperature;
    private String building_name;
    private Double out_temperature;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.building_name = room.getBuilding().getName();
        this.out_temperature = room.getBuilding().getOut_temperature();
    }

    // Getters and Setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getFloor() {
        return this.floor;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double getCurrent_temperature() {
        return this.current_temperature;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public Double getTarget_temperature() {
        return this.target_temperature;
    }

    public Double getOut_temperature() {
        return out_temperature;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setOut_temperature(Double out_temperature) {
        this.out_temperature = out_temperature;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }
    //    @ManyToOne
//    @JoinColumn(name = "building_id")
//    private BuildingDto building;

}
