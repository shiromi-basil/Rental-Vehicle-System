package com.rental.backend.Modal;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "car")
public class Car {
    @Id
    private String vPlateNo;
    private String vMake;
    private String vModel;
    private String vTransmission;
    private BigDecimal vRatePerDay;
    private int cNoOfDoors;
    private int cNoOfSeats;
    private boolean cAirCondition;

    public Car() { super();
    }

    @PersistenceConstructor
    public Car(String vPlateNo, String vMake, String vModel, String vTransmission,
               BigDecimal vRatePerDay, int cNoOfDoors, int cNoOfSeats,
               boolean cAirCondition) {
        this.vPlateNo = vPlateNo;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vTransmission = vTransmission;
        this.vRatePerDay = vRatePerDay;
        this.cNoOfDoors = cNoOfDoors;
        this.cNoOfSeats = cNoOfSeats;
        this.cAirCondition = cAirCondition;
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

    public int getcNoOfDoors() {
        return cNoOfDoors;
    }

    public int getcNoOfSeats() {
        return cNoOfSeats;
    }

    public boolean iscAirCondition() {
        return cAirCondition;
    }

    public void setcAirCondition(boolean cAirCondition) {
        this.cAirCondition = cAirCondition;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vPlateNo='" + vPlateNo + '\'' +
                ", vMake='" + vMake + '\'' +
                ", vModel='" + vModel + '\'' +
                ", vTransmission='" + vTransmission + '\'' +
                ", vRatePerDay=" + vRatePerDay +
                ", cNoOfDoors=" + cNoOfDoors +
                ", cNoOfSeats=" + cNoOfSeats +
                ", cAirCondition=" + cAirCondition +
                '}';
    }
}
