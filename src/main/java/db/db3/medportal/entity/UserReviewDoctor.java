package db.db3.medportal.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class UserReviewDoctor {
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
    private Integer carefulnessRating;
    private Integer efficiencyRating;
    private Integer attitudeRating;
    private Integer informingRating;
    private Integer willAdviseRating;

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

    public Integer getCarefulnessRating() {
        return carefulnessRating;
    }

    public void setCarefulnessRating(Integer carefulnessRating) {
        this.carefulnessRating = carefulnessRating;
    }

    public Integer getEfficiencyRating() {
        return efficiencyRating;
    }

    public void setEfficiencyRating(Integer efficiencyRating) {
        this.efficiencyRating = efficiencyRating;
    }

    public Integer getAttitudeRating() {
        return attitudeRating;
    }

    public void setAttitudeRating(Integer attitudeRating) {
        this.attitudeRating = attitudeRating;
    }

    public Integer getInformingRating() {
        return informingRating;
    }

    public void setInformingRating(Integer informingRating) {
        this.informingRating = informingRating;
    }

    public Integer getWillAdviseRating() {
        return willAdviseRating;
    }

    public void setWillAdviseRating(Integer willAdviseRating) {
        this.willAdviseRating = willAdviseRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReviewDoctor that = (UserReviewDoctor) o;
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
                carefulnessRating.equals(that.carefulnessRating) &&
                efficiencyRating.equals(that.efficiencyRating) &&
                attitudeRating.equals(that.attitudeRating) &&
                informingRating.equals(that.informingRating) &&
                willAdviseRating.equals(that.willAdviseRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, medicalCenter, doctor, appointmentDate, info, pros, cons, postDate, status, carefulnessRating, efficiencyRating, attitudeRating, informingRating, willAdviseRating);
    }

    @Override
    public String toString() {
        return "UserReviewDoctor{" +
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
                ", carefulnessRating=" + carefulnessRating +
                ", efficiencyRating=" + efficiencyRating +
                ", attitudeRating=" + attitudeRating +
                ", informingRating=" + informingRating +
                ", willAdviseRating=" + willAdviseRating +
                '}';
    }
}
