import javax.persistence.*;
import java.sql.Date;

/**
 * The Schedule class implements all the attributes and methods
 * of schedule object.
 * <p>
 * Student ID: 2018117
 * UoW ID: w1714893
 *
 * @author Shiromi Thevarajan
 * @version 1.0
 * @since 15-11-2019
 */
@Entity
public class Schedule implements Comparable<Schedule> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sID")
    private int sID;
    private Date sPickUpDate;
    private Date sDropOffDate;
    private String cusID;
    private String vPlateNo;

    public Schedule() {
        super();
    }

    public Schedule(int sID, Date sPickUpDate, Date sDropOffDate, String cusID,
                    String vPlateNo) {
        this.sID = sID;
        this.sPickUpDate = sPickUpDate;
        this.sDropOffDate = sDropOffDate;
        this.cusID = cusID;
        this.vPlateNo = vPlateNo;
    }

    public Schedule(Date sPickUpDate, Date sDropOffDate, String cusID,
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Schedule schedule = (Schedule) o;

        if (sID != schedule.sID)
            return false;
        if (!sPickUpDate.equals(schedule.sPickUpDate))
            return false;
        if (!sDropOffDate.equals(schedule.sDropOffDate))
            return false;
        if (!cusID.equals(schedule.cusID))
            return false;
        return vPlateNo.equals(schedule.vPlateNo);
    }

    @Override
    public int hashCode() {
        int result = sID;
        result = 31 * result + sPickUpDate.hashCode();
        result = 31 * result + sDropOffDate.hashCode();
        result = 31 * result + cusID.hashCode();
        result = 31 * result + vPlateNo.hashCode();
        return result;
    }

    @Override
    public int compareTo(Schedule schedule) {
        return this.getvPlateNo().compareTo(schedule.getvPlateNo());
    }
}
