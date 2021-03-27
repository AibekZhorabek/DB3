package db.db3.medportal.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class UserCommentMedicine {
    private Long id;
    private User user;
    private Medicine medicine;
    private String info;
    private Timestamp postDate;
    private Status status;

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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        UserCommentMedicine that = (UserCommentMedicine) o;
        return id.equals(that.id) &&
                user.equals(that.user) &&
                medicine.equals(that.medicine) &&
                info.equals(that.info) &&
                postDate.equals(that.postDate) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, medicine, info, postDate, status);
    }

    @Override
    public String toString() {
        return "UserCommentMedicine{" +
                "id=" + id +
                ", user=" + user +
                ", medicine=" + medicine +
                ", info='" + info + '\'' +
                ", postDate=" + postDate +
                ", status=" + status +
                '}';
    }
}
