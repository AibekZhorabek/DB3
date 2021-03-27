package db.db3.medportal.entity;

import java.util.Objects;

public class Pharmacy {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Status status;
    private City city;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return id.equals(pharmacy.id) &&
                name.equals(pharmacy.name) &&
                address.equals(pharmacy.address) &&
                phone.equals(pharmacy.phone) &&
                status.equals(pharmacy.status) &&
                city.equals(pharmacy.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, status, city);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", city=" + city +
                '}';
    }
}
