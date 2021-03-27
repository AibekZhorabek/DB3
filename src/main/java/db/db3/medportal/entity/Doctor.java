package db.db3.medportal.entity;

import java.util.Objects;

public class Doctor {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String gender;
    private String briefInfo;
    private Integer experience;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
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
        Doctor doctor = (Doctor) o;
        return id.equals(doctor.id) &&
                email.equals(doctor.email) &&
                password.equals(doctor.password) &&
                name.equals(doctor.name) &&
                surname.equals(doctor.surname) &&
                phone.equals(doctor.phone) &&
                gender.equals(doctor.gender) &&
                briefInfo.equals(doctor.briefInfo) &&
                experience.equals(doctor.experience) &&
                status.equals(doctor.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, surname, phone, gender, briefInfo, experience, status);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", briefInfo='" + briefInfo + '\'' +
                ", experience=" + experience +
                ", status=" + status +
                '}';
    }
}
