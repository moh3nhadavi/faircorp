package com.example.building.dto;


import com.example.building.model.Room;
import com.example.building.model.Window;
import com.example.building.model.WindowStatus;

public class WindowDto {
    private Long id;

    private String name;

    private WindowStatus status;

    private Long room_id;
    private String room_name;


    public WindowDto() {
    }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.status = window.getStatus();
        this.room_id = window.getRoom().getId();
        this.room_name = window.getRoom().getName();
    }


    public Long getId() {
        return id;
    }

    public WindowStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getRoom_name() {
        return room_name;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(WindowStatus status) {
        this.status = status;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}
