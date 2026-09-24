package br.com.rafael.restaurant_booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookingTableId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "fk_booking_id", nullable = false)
    private Long bookingId;

    @Column(name = "fk_table_id", nullable = false)
    private Integer tableId;

    public BookingTableId() {
    }

    public BookingTableId(Long bookingId, Integer tableId) {
        this.bookingId = bookingId;
        this.tableId = tableId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public Integer getTableId() {
        return tableId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingTableId that)) {
            return false;
        }
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(tableId, that.tableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, tableId);
    }
}
