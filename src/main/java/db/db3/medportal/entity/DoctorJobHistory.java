package db.db3.medportal.entity;

import java.util.Objects;

public class DoctorJobHistory {
    private Long id;
    private String placeName;
    private String startedYear;
    private String finishedYear;
    private String profession;
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

    public String getStartedYear() {
        return startedYear;
    }

    public void setStartedYear(String startedYear) {
        this.startedYear = startedYear;
    }

    public String getFinishedYear() {
        return finishedYear;
    }

    public void setFinishedYear(String finishedYear) {
        this.finishedYear = finishedYear;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
        DoctorJobHistory that = (DoctorJobHistory) o;
        return id.equals(that.id) &&
                placeName.equals(that.placeName) &&
                startedYear.equals(that.startedYear) &&
                finishedYear.equals(that.finishedYear) &&
                profession.equals(that.profession) &&
                doctor.equals(that.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placeName, startedYear, finishedYear, profession, doctor);
    }

    @Override
    public String toString() {
        return "DoctorJobHistory{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", startedYear='" + startedYear + '\'' +
                ", finishedYear='" + finishedYear + '\'' +
                ", profession='" + profession + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
