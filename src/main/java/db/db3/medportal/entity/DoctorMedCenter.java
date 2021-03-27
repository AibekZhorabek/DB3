package db.db3.medportal.entity;

import java.util.Objects;

public class DoctorMedCenter {
    private Long id;
    private Integer price;
    private Doctor doctor;
    private MedicalCenter medicalCenter;
    private Profession profession;
    private AppointmentType appointmentType;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public MedicalCenter getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(MedicalCenter medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
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
        DoctorMedCenter that = (DoctorMedCenter) o;
        return id.equals(that.id) &&
                price.equals(that.price) &&
                doctor.equals(that.doctor) &&
                medicalCenter.equals(that.medicalCenter) &&
                profession.equals(that.profession) &&
                appointmentType.equals(that.appointmentType) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, doctor, medicalCenter, profession, appointmentType, status);
    }

    @Override
    public String toString() {
        return "DoctorMedCenter{" +
                "id=" + id +
                ", price=" + price +
                ", doctor=" + doctor +
                ", medicalCenter=" + medicalCenter +
                ", profession=" + profession +
                ", appointmentType=" + appointmentType +
                ", status=" + status +
                '}';
    }
}
