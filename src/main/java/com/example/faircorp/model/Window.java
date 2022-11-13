package com.example.faircorp.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RWINDOW")
public class Window {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private WindowStatus status;

    public Window() {

    }

    public Window(String name, WindowStatus status, Room room) {
        this.name = name;
        this.status = status;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public String getName() {
        return name;
    }

    public WindowStatus getStatus() {
        return status;
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

    public void setRoom(Room room) {
        this.room = room;
    }


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
