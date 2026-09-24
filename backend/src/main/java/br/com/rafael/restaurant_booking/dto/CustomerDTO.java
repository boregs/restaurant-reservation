package br.com.rafael.restaurant_booking.dto;

import java.util.UUID;

public class CustomerDTO {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String cpf;
    private UUID uuid;
    private boolean isPhoneNumberVerified;
    private boolean isEmailVerified;
    private String createdAt;

    public CustomerDTO(String name, String surname, String email,
                       String phoneNumber, String cpf, UUID uuid, boolean isPhoneNumberVerified, boolean isEmailVerified, String createdAt) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        this.uuid = uuid;
        this.isPhoneNumberVerified = isPhoneNumberVerified;
        this.isEmailVerified = isEmailVerified;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isPhoneNumberVerified() {
        return isPhoneNumberVerified;
    }

    public void setPhoneNumberVerified(boolean phoneNumberVerified) {
        isPhoneNumberVerified = phoneNumberVerified;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
