package br.com.rafael.restaurant_booking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tables")
public class TableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;
    private int capacity;
    private String location;
    private String status;

    public TableModel(int id, String status, String location, int capacity, int number) {
        this.id = id;
        this.status = status;
        this.location = location;
        this.capacity = capacity;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
