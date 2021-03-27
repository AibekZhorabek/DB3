package db.db3.medportal.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class UserReviewMedCenter {
    private Long id;
    private User user;
    private MedicalCenter medicalCenter;
    private Doctor doctor;
    private Date appointmentDate;
    private String info;
    private String pros;
    private String cons;
    private Timestamp postDate;
    private Status status;
    private Integer buildingRating;
    private Integer equipmentRating;
    private Integer attitudeRating;
    private Integer comfortRating;
    private Integer punctualityRating;


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

    public MedicalCenter getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(MedicalCenter medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public Integer getBuildingRating() {
        return buildingRating;
    }

    public void setBuildingRating(Integer buildingRating) {
        this.buildingRating = buildingRating;
    }

    public Integer getEquipmentRating() {
        return equipmentRating;
    }

    public void setEquipmentRating(Integer equipmentRating) {
        this.equipmentRating = equipmentRating;
    }

    public Integer getAttitudeRating() {
        return attitudeRating;
    }

    public void setAttitudeRating(Integer attitudeRating) {
        this.attitudeRating = attitudeRating;
    }

    public Integer getComfortRating() {
        return comfortRating;
    }

    public void setComfortRating(Integer comfortRating) {
        this.comfortRating = comfortRating;
    }

    public Integer getPunctualityRating() {
        return punctualityRating;
    }

    public void setPunctualityRating(Integer punctualityRating) {
        this.punctualityRating = punctualityRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReviewMedCenter that = (UserReviewMedCenter) o;
        return id.equals(that.id) &&
                user.equals(that.user) &&
                medicalCenter.equals(that.medicalCenter) &&
                doctor.equals(that.doctor) &&
                appointmentDate.equals(that.appointmentDate) &&
                info.equals(that.info) &&
                pros.equals(that.pros) &&
                cons.equals(that.cons) &&
                postDate.equals(that.postDate) &&
                status.equals(that.status) &&
                buildingRating.equals(that.buildingRating) &&
                equipmentRating.equals(that.equipmentRating) &&
                attitudeRating.equals(that.attitudeRating) &&
                comfortRating.equals(that.comfortRating) &&
                punctualityRating.equals(that.punctualityRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, medicalCenter, doctor, appointmentDate, info, pros, cons, postDate, status, buildingRating, equipmentRating, attitudeRating, comfortRating, punctualityRating);
    }

    @Override
    public String toString() {
        return "UserReviewMedCenter{" +
                "id=" + id +
                ", user=" + user +
                ", medicalCenter=" + medicalCenter +
                ", doctor=" + doctor +
                ", appointmentDate=" + appointmentDate +
                ", info='" + info + '\'' +
                ", pros='" + pros + '\'' +
                ", cons='" + cons + '\'' +
                ", postDate=" + postDate +
                ", status=" + status +
                ", buildingRating=" + buildingRating +
                ", equipmentRating=" + equipmentRating +
                ", attitudeRating=" + attitudeRating +
                ", comfortRating=" + comfortRating +
                ", punctualityRating=" + punctualityRating +
                '}';
    }
}
