package com.rental.backend.Modal;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sID")
    private int sID;
    private Date sPickUpDate;
    private Date sDropOffDate;
    private String cusID;
    private String vPlateNo;

    public Schedule() {
        super();
    }

    @PersistenceConstructor
    public Schedule(int sID, Date sPickUpDate, Date sDropOffDate, String cusID,
                    String vPlateNo) {
        this.sID = sID;
        this.sPickUpDate = sPickUpDate;
        this.sDropOffDate = sDropOffDate;
        this.cusID = cusID;
        this.vPlateNo = vPlateNo;
    }

    public Schedule(java.sql.Date sPickUpDate, java.sql.Date sDropOffDate, String cusID,
                    String vPlateNo) {
        this.sPickUpDate = sPickUpDate;
        this.sDropOffDate = sDropOffDate;
        this.cusID = cusID;
        this.vPlateNo = vPlateNo;
    }

    public int getsID() {
        return sID;
    }

    public Date getsPickUpDate() {
        return sPickUpDate;
    }

    public void setsPickUpDate(Date sPickUpDate) {
        this.sPickUpDate = sPickUpDate;
    }

    public Date getsDropOffDate() {
        return sDropOffDate;
    }

    public void setsDropOffDate(Date sDropOffDate) {
        this.sDropOffDate = sDropOffDate;
    }

    public String getCusID() {
        return cusID;
    }

    public String getvPlateNo() {
        return vPlateNo;
    }

    @Override
    public String toString() {
        return "Schedule {" +
                "sID='" + sID + '\'' +
                ", sPickUpDate=" + sPickUpDate +
                ", sDropOffDate=" + sDropOffDate +
                ", cusID='" + cusID + '\'' +
                ", vPlateNo='" + vPlateNo + '\'' +
                '}';
    }
}
