package db.db3.medportal.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class DoctorWorkingHour {
    private Long id;
    private Doctor doctor;
    private DoctorMedCenter doctorMedCenter;
    private Date numOfDay;
    private Time time;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DoctorMedCenter getDoctorMedCenter() {
        return doctorMedCenter;
    }

    public void setDoctorMedCenter(DoctorMedCenter doctorMedCenter) {
        this.doctorMedCenter = doctorMedCenter;
    }

    public Date getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(Date numOfDay) {
        this.numOfDay = numOfDay;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorWorkingHour that = (DoctorWorkingHour) o;
        return id.equals(that.id) &&
                doctor.equals(that.doctor) &&
                doctorMedCenter.equals(that.doctorMedCenter) &&
                numOfDay.equals(that.numOfDay) &&
                time.equals(that.time) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, doctorMedCenter, numOfDay, time, status);
    }

    @Override
    public String toString() {
        return "DoctorWorkingHour{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", doctorMedCenter=" + doctorMedCenter +
                ", numOfDay=" + numOfDay +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}
