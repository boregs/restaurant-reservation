package br.com.rafael.restaurant_booking.dto;

public class ReservationDTO {
    private Long reservationId;
    private String bookerName;
    private int people;
    private String date;
    private String createdAt;
    private String updatedAt;
    private String status;

    public ReservationDTO(Long reservationId, String bookerName, int people, String date, String createdAt, String updatedAt, String status) {
        this.reservationId = reservationId;
        this.bookerName = bookerName;
        this.people = people;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
