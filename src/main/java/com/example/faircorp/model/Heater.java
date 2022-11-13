package com.example.faircorp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Heater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private HeaterStatus status;

    private Integer power;

    public Heater() {
    }

    public Heater(String name, Integer power, HeaterStatus status, Room room) {
        this.name = name;
        this.status = status;
        this.power = power;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


}
