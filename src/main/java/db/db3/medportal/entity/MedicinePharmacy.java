package db.db3.medportal.entity;

import java.util.Objects;

public class MedicinePharmacy {
    private Long id;
    private Pharmacy pharmacy;
    private Medicine medicine;
    private Integer price;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        MedicinePharmacy that = (MedicinePharmacy) o;
        return id.equals(that.id) &&
                pharmacy.equals(that.pharmacy) &&
                medicine.equals(that.medicine) &&
                price.equals(that.price) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pharmacy, medicine, price, status);
    }

    @Override
    public String toString() {
        return "MedicinePharmacy{" +
                "id=" + id +
                ", pharmacy=" + pharmacy +
                ", medicine=" + medicine +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
