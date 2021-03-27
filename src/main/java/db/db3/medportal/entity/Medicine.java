package db.db3.medportal.entity;

import java.util.Objects;

public class Medicine {
    private Long id;
    private String name;
    private String manufacturer;
    private String shortDescription;
    private String pharmacology;
    private String dosage;
    private String sideEffect;
    private String indication;
    private String contraindication;
    private MedicineGroupFor groupFor;
    private MedicineGroupFrom groupFrom;
    private MedicineGroupHow groupHow;

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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPharmacology() {
        return pharmacology;
    }

    public void setPharmacology(String pharmacology) {
        this.pharmacology = pharmacology;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getContraindication() {
        return contraindication;
    }

    public void setContraindication(String contraindication) {
        this.contraindication = contraindication;
    }

    public MedicineGroupFor getGroupFor() {
        return groupFor;
    }

    public void setGroupFor(MedicineGroupFor groupFor) {
        this.groupFor = groupFor;
    }

    public MedicineGroupFrom getGroupFrom() {
        return groupFrom;
    }

    public void setGroupFrom(MedicineGroupFrom groupFrom) {
        this.groupFrom = groupFrom;
    }

    public MedicineGroupHow getGroupHow() {
        return groupHow;
    }

    public void setGroupHow(MedicineGroupHow groupHow) {
        this.groupHow = groupHow;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id.equals(medicine.id) &&
                name.equals(medicine.name) &&
                Objects.equals(manufacturer, medicine.manufacturer) &&
                Objects.equals(shortDescription, medicine.shortDescription) &&
                Objects.equals(pharmacology, medicine.pharmacology) &&
                Objects.equals(dosage, medicine.dosage) &&
                Objects.equals(sideEffect, medicine.sideEffect) &&
                Objects.equals(indication, medicine.indication) &&
                Objects.equals(contraindication, medicine.contraindication) &&
                Objects.equals(groupFor, medicine.groupFor) &&
                Objects.equals(groupFrom, medicine.groupFrom) &&
                Objects.equals(groupHow, medicine.groupHow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, shortDescription, pharmacology, dosage, sideEffect, indication, contraindication, groupFor, groupFrom, groupHow);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", pharmacology='" + pharmacology + '\'' +
                ", dosage='" + dosage + '\'' +
                ", sideEffect='" + sideEffect + '\'' +
                ", indication='" + indication + '\'' +
                ", contraindication='" + contraindication + '\'' +
                ", groupFor=" + groupFor +
                ", groupFrom=" + groupFrom +
                ", groupHow=" + groupHow +
                '}';
    }
}
