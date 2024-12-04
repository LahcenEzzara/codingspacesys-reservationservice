package ma.ensamcasa.codingspacesys.reservationservice.controller;

import ma.ensamcasa.codingspacesys.reservationservice.dto.ReservationDto;
import ma.ensamcasa.codingspacesys.reservationservice.entity.Reservation;
import ma.ensamcasa.codingspacesys.reservationservice.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Create a new reservation
    @PostMapping("/create")
    public ResponseEntity<String> createReservation(@RequestBody ReservationDto ReservationDto) {
        String response = reservationService.createReservation(ReservationDto.getStudentEmail(), ReservationDto.getPcId(), ReservationDto.getTimeSlot());
        return ResponseEntity.ok(response);
    }

    // Update an existing reservation
    @PutMapping("/update/{reservationId}")
    public ResponseEntity<String> updateReservation(@PathVariable Long reservationId, @RequestBody ReservationDto ReservationDto) {
        Optional<Reservation> updatedReservation = reservationService.updateReservation(reservationId, ReservationDto.getPcId(), ReservationDto.getTimeSlot());
        if (updatedReservation.isPresent()) {
            return ResponseEntity.ok("Reservation updated successfully.");
        }
        return ResponseEntity.status(404).body("Reservation not found.");
    }

    // Cancel a reservation
    @DeleteMapping("/cancel/{reservationId}")
    public ResponseEntity<String> cancelReservation(@PathVariable Long reservationId) {
        boolean isCancelled = reservationService.cancelReservation(reservationId);
        if (isCancelled) {
            return ResponseEntity.ok("Reservation cancelled successfully.");
        }
        return ResponseEntity.status(404).body("Reservation not found.");
    }

    // Get a reservation by ID
    @GetMapping("/{reservationId}")
    public ResponseEntity<Object> getReservationById(@PathVariable Long reservationId) {
        Optional<Reservation> reservation = reservationService.getReservationById(reservationId);
        return reservation.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).body("Reservation not found."));
    }

    // Get all reservations
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
}
