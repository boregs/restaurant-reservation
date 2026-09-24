package br.com.rafael.restaurant_booking.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    private CustomerModel bookerId;

    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private int people;
    private Date bookingDate;
    private Date createdAt;
    private Date updatedAt;
    private boolean confirmed;
    private String status;

    public ReservationModel(int id, CustomerModel bookerId, UUID uuid, int people, Date bookingDate,
                            Date createdAt, Date updatedAt, boolean confirmed, String status) {
        this.id = id;
        this.bookerId = bookerId;
        this.uuid = uuid;
        this.people = people;
        this.bookingDate = bookingDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.confirmed = confirmed;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerModel getBookerId() {
        return bookerId;
    }

    public void setBookerId(CustomerModel bookerId) {
        this.bookerId = bookerId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
