package com.rental.backend.Modal;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "motorbike")
public class Motorbike {

    @Id
    private String vPlateNo;
    private String vMake;
    private String vModel;
    private String vTransmission;
    private BigDecimal vRatePerDay;
    private double mPetrolCapacity;
    private String mType;
    private int mModelYear;

    public Motorbike() {
        super();
    }

    @PersistenceConstructor
    public Motorbike(String vPlateNo, String vMake, String vModel, String vTransmission
            , BigDecimal vRatePerDay, double mPetrolCapacity, String mType, int mModelYear) {
        this.vPlateNo = vPlateNo;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vTransmission = vTransmission;
        this.vRatePerDay = vRatePerDay;
        this.mPetrolCapacity = mPetrolCapacity;
        this.mType = mType;
        this.mModelYear = mModelYear;
    }

    public String getvPlateNo() {
        return vPlateNo;
    }

    public String getvMake() {
        return vMake;
    }

    public String getvModel() {
        return vModel;
    }

    public String getvTransmission() {
        return vTransmission;
    }

    public BigDecimal getvRatePerDay() {
        return vRatePerDay;
    }

    public void setvRatePerDay(BigDecimal vRatePerDay) {
        this.vRatePerDay = vRatePerDay;
    }

    public double getmPetrolCapacity() {
        return mPetrolCapacity;
    }

    public String getmType() {
        return mType;
    }

    public int getmModelYear() { return mModelYear; }

    @Override
    public String toString() {
        return "Motorbike{" +
                "vPlateNo='" + vPlateNo + '\'' +
                ", vMake='" + vMake + '\'' +
                ", vModel='" + vModel + '\'' +
                ", vTransmission='" + vTransmission + '\'' +
                ", vRatePerDay=" + vRatePerDay +
                ", mPetrolCapacity=" + mPetrolCapacity +
                ", mType='" + mType + '\'' +
                ", mModelYear='" + mModelYear + '\'' +
                '}';
    }
}
