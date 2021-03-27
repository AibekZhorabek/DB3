package db.db3.medportal.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class DoctorReviewMedicine {
    private Long id;
    private Doctor doctor;
    private Medicine medicine;
    private String pros;
    private String cons;
    private String info;
    private Integer efficiencyRating;
    private Integer priceAndQualityRating;
    private Integer sideEffectsRating;
    private Timestamp postDate;
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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getEfficiencyRating() {
        return efficiencyRating;
    }

    public void setEfficiencyRating(Integer efficiencyRating) {
        this.efficiencyRating = efficiencyRating;
    }

    public Integer getPriceAndQualityRating() {
        return priceAndQualityRating;
    }

    public void setPriceAndQualityRating(Integer priceAndQualityRating) {
        this.priceAndQualityRating = priceAndQualityRating;
    }

    public Integer getSideEffectsRating() {
        return sideEffectsRating;
    }

    public void setSideEffectsRating(Integer sideEffectsRating) {
        this.sideEffectsRating = sideEffectsRating;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
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
        DoctorReviewMedicine that = (DoctorReviewMedicine) o;
        return id.equals(that.id) &&
                doctor.equals(that.doctor) &&
                medicine.equals(that.medicine) &&
                pros.equals(that.pros) &&
                cons.equals(that.cons) &&
                info.equals(that.info) &&
                efficiencyRating.equals(that.efficiencyRating) &&
                priceAndQualityRating.equals(that.priceAndQualityRating) &&
                sideEffectsRating.equals(that.sideEffectsRating) &&
                postDate.equals(that.postDate) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, medicine, pros, cons, info, efficiencyRating, priceAndQualityRating, sideEffectsRating, postDate, status);
    }

    @Override
    public String toString() {
        return "DoctorReviewMedicine{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", medicine=" + medicine +
                ", pros='" + pros + '\'' +
                ", cons='" + cons + '\'' +
                ", info='" + info + '\'' +
                ", efficiencyRating=" + efficiencyRating +
                ", priceAndQualityRating=" + priceAndQualityRating +
                ", sideEffectsRating=" + sideEffectsRating +
                ", postDate=" + postDate +
                ", status=" + status +
                '}';
    }
}
