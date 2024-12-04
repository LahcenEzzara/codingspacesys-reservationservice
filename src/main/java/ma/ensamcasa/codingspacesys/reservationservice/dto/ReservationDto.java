package ma.ensamcasa.codingspacesys.reservationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {
    private Long studentId;
    private Long pcId;
    private String startTime;
    private String endTime;

}
