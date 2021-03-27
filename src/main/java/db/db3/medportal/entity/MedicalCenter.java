package db.db3.medportal.entity;

import java.util.Objects;

public class MedicalCenter {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String type;
    private String briefInfo;
    private String info;
    private Status status;
    private City city;
    private ClinicGroup clinicGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ClinicGroup getClinicGroup() {
        return clinicGroup;
    }

    public void setClinicGroup(ClinicGroup clinicGroup) {
        this.clinicGroup = clinicGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalCenter that = (MedicalCenter) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                phone.equals(that.phone) &&
                address.equals(that.address) &&
                type.equals(that.type) &&
                briefInfo.equals(that.briefInfo) &&
                info.equals(that.info) &&
                status.equals(that.status) &&
                city.equals(that.city) &&
                clinicGroup.equals(that.clinicGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, address, type, briefInfo, info, status, city, clinicGroup);
    }

    @Override
    public String toString() {
        return "MedicalCenter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", briefInfo='" + briefInfo + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", city=" + city +
                ", clinicGroup=" + clinicGroup +
                '}';
    }
}
