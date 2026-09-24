package br.com.rafael.restaurant_booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    @PostMapping()
    public ResponseEntity<Void> createReservation(){
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/status")
    public ResponseEntity<Void> getReservationStatus(){
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/reschedule")
    public ResponseEntity<Void> rescheduleReservation(@PathVariable UUID id){
        try{


            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelResevation(@PathVariable UUID id){
        try {
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<Void> confirmReservation(@PathVariable UUID id){
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/{id}/verify")
    public ResponseEntity<Void> verifyBookerContact(@PathVariable UUID id){
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
