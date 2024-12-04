package ma.ensamcasa.codingspacesys.reservationservice.dto;

public class ReservationDto {
    private Long id;

    private String studentEmail;
    private int pcId;
    private int timeSlot;


    public Long getId() {
        return id;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public int getPcId() {
        return pcId;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
}
