package br.com.rafael.restaurant_booking.model;

import br.com.rafael.restaurant_booking.enums.BookingStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerModel bookerId;

    @Generated(event = EventType.INSERT)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "booking_uuid", nullable = false, unique = true, insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "people_count", nullable = false)
    private int people;

    @Column(name = "booking_datetime", nullable = false)
    private Instant bookingDateTime;

    @Generated(event = EventType.INSERT)
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private Instant updatedAt;

    @ColumnDefault("false")
    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'ACTIVE'")
    @Column(name = "status", nullable = false, length = 20)
    private BookingStatus status = BookingStatus.ACTIVE;

    public ReservationModel() {
    }

    public ReservationModel(CustomerModel bookerId, int people, Instant bookingDateTime) {
        this.bookerId = bookerId;
        this.people = people;
        this.bookingDateTime = bookingDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Instant getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(Instant bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
