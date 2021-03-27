package db.db3.medportal.entity;

import java.util.Objects;

public class Appointment {
    private Long id;
    private User user;
    private DoctorMedCenter doctorMedCenter;
    private Status status;
    private DoctorWorkingHour doctorWorkingHour;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DoctorMedCenter getDoctorMedCenter() {
        return doctorMedCenter;
    }

    public void setDoctorMedCenter(DoctorMedCenter doctorMedCenter) {
        this.doctorMedCenter = doctorMedCenter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DoctorWorkingHour getDoctorWorkingHour() {
        return doctorWorkingHour;
    }

    public void setDoctorWorkingHour(DoctorWorkingHour doctorWorkingHour) {
        this.doctorWorkingHour = doctorWorkingHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id.equals(that.id) &&
                user.equals(that.user) &&
                doctorMedCenter.equals(that.doctorMedCenter) &&
                status.equals(that.status) &&
                doctorWorkingHour.equals(that.doctorWorkingHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, doctorMedCenter, status, doctorWorkingHour);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", user=" + user +
                ", doctorMedCenter=" + doctorMedCenter +
                ", status=" + status +
                ", doctorWorkingHour=" + doctorWorkingHour +
                '}';
    }
}
