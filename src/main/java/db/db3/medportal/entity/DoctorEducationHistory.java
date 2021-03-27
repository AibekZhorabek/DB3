package db.db3.medportal.entity;

import java.util.Objects;

public class DoctorEducationHistory {
    private Long id;
    private String placeName;
    private String year;
    private Doctor doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEducationHistory that = (DoctorEducationHistory) o;
        return id.equals(that.id) &&
                placeName.equals(that.placeName) &&
                year.equals(that.year) &&
                doctor.equals(that.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placeName, year, doctor);
    }

    @Override
    public String toString() {
        return "DoctorEducationHistory{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", year='" + year + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
