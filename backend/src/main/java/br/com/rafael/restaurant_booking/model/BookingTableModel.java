package br.com.rafael.restaurant_booking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_tables_customers")
public class BookingTableModel {
    @EmbeddedId
    private BookingTableId id = new BookingTableId();

    @MapsId("bookingId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_booking_id", nullable = false)
    private ReservationModel booking;

    @MapsId("tableId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_table_id", nullable = false)
    private TableModel table;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_customer_id", nullable = false)
    private CustomerModel customer;

    protected BookingTableModel() {
    }

    public BookingTableModel(ReservationModel booking, TableModel table, CustomerModel customer) {
        this.booking = booking;
        this.table = table;
        this.customer = customer;
    }

    public BookingTableId getId() {
        return id;
    }

    public ReservationModel getBooking() {
        return booking;
    }

    public TableModel getTable() {
        return table;
    }

    public CustomerModel getCustomer() {
        return customer;
    }
}
