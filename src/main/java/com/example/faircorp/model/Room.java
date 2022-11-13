package com.example.faircorp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer floor;
    private Double current_temperature;
    private Double target_temperature;

    public Room(){}

    public Room(String name,Integer floor,Double current_temperature, Double target_temperature, Building building){
        this.name = name;
        this.floor = floor;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.building = building;
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

    public void setFloor(Integer floor){
        this.floor = floor;
    }

    public Integer getFloor(){
        return this.floor;
    }

    public void setCurrent_temperature(Double current_temperature){
        this.current_temperature = current_temperature;
    }

    public Double getCurrent_temperature(){
        return this.current_temperature;
    }

    public void setTarget_temperature(Double target_temperature){
        this.target_temperature = target_temperature;
    }
    public Double getTarget_temperature(){
        return this.target_temperature;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @ManyToOne
    private Building building;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Heater> heaters;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Window> windows;

}
