package br.com.rafael.restaurant_booking.model;

import br.com.rafael.restaurant_booking.enums.TableLocation;
import br.com.rafael.restaurant_booking.enums.TableStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "restaurant_tables")
public class TableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id", nullable = false)
    private Integer id;

    @Generated(event = EventType.INSERT)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "table_uuid", nullable = false, unique = true, insertable = false, updatable = false)
    private UUID uuid;

    @ColumnDefault("1")
    @Column(name = "table_capacity", nullable = false)
    private int capacity = 1;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'INTERIOR'")
    @Column(name = "table_location", nullable = false, length = 20)
    private TableLocation location = TableLocation.INTERIOR;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'AVAILABLE'")
    @Column(name = "table_status", nullable = false, length = 20)
    private TableStatus status = TableStatus.AVAILABLE;

    @Generated(event = EventType.INSERT)
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private Instant updatedAt;

    public TableModel() {
    }

    public TableModel(int capacity, TableLocation location) {
        this.capacity = capacity;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public TableLocation getLocation() {
        return location;
    }

    public void setLocation(TableLocation location) {
        this.location = location;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

}
