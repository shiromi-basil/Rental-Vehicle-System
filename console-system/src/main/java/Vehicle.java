import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The Vehicle class implements all the attributes and methods
 * of vehicle object.
 * <p>
*
 * @author Shiromi Basil
 * @version 1.0
 * @since 15-11-2019
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // tables only for sub classes
public abstract class Vehicle implements Comparable<Vehicle>, Serializable {

    @Id
    private String vPlateNo;
    private String vMake;
    private String vModel;
    private String vTransmission;
    private BigDecimal vRatePerDay;

    public Vehicle() {
        super();
    }

    public Vehicle(String vPlateNo, String vMake, String vModel, String vTransmission,
                   BigDecimal vRatePerDay) {
        super();
        this.vPlateNo = vPlateNo;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vTransmission = vTransmission;
        this.vRatePerDay = vRatePerDay;
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

    @Override
    public String toString() {
        return "Vehicle {" +
                "vPlateNo='" + vPlateNo + '\'' +
                ", vMake='" + vMake + '\'' +
                ", vModel='" + vModel + '\'' +
                ", vTransmission='" + vTransmission + '\'' +
                ", vRatePerDay=" + vRatePerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Vehicle vehicle = (Vehicle) o;

        if (!vPlateNo.equals(vehicle.vPlateNo))
            return false;
        if (!vMake.equals(vehicle.vMake))
            return false;
        if (!vModel.equals(vehicle.vModel))
            return false;
        if (!vTransmission.equals(vehicle.vTransmission))
            return false;
        return vRatePerDay.equals(vehicle.vRatePerDay);
    }

    @Override
    public int hashCode() {
        int result = vPlateNo.hashCode();
        result = 31 * result + vMake.hashCode();
        result = 31 * result + vModel.hashCode();
        result = 31 * result + vTransmission.hashCode();
        result = 31 * result + vRatePerDay.hashCode();
        return result;
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return this.getvMake().compareTo(vehicle.getvMake());
    }
}
