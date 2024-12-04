package ma.ensamcasa.codingspacesys.reservationservice.service;

import ma.ensamcasa.codingspacesys.reservationservice.entity.Reservation;
import ma.ensamcasa.codingspacesys.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public String createReservation(String studentEmail, int pcId, int timeSlot) {
        Reservation reservation = new Reservation();
        reservation.setStudentEmail(studentEmail);
        reservation.setPcId(pcId);
        reservation.setTimeSlot(timeSlot);
        reservationRepository.save(reservation);

        return "Reservation created successfully.";
    }

    public Optional<Reservation> updateReservation(Long reservationId, int pcId, int timeSlot) {
        Optional<Reservation> existingReservation = reservationRepository.findById(reservationId);
        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            reservation.setPcId(pcId);
            reservation.setTimeSlot(timeSlot);
            return Optional.of(reservationRepository.save(reservation));
        }
        return Optional.empty();
    }

    public boolean cancelReservation(Long reservationId) {
        Optional<Reservation> existingReservation = reservationRepository.findById(reservationId);
        if (existingReservation.isPresent()) {
            reservationRepository.delete(existingReservation.get());
            return true;
        }
        return false;
    }

    public Optional<Reservation> getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
