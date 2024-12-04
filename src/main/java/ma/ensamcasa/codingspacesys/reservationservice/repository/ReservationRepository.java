package ma.ensamcasa.codingspacesys.reservationservice.repository;

import ma.ensamcasa.codingspacesys.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
