import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The Car class implements all the attributes and methods
 * of car object.
 * Student ID: 2018117
 * UoW ID: w1714893
 *
 * @author Shiromi Thevarajan
 * @version 1.0
 * @since 15-11-2019
 */
@Entity
public class Car extends Vehicle implements Serializable {
    private int cNoOfDoors;
    private int cNoOfSeats;
    private boolean cAirCondition;

    public Car() {
        super();
    }

    public Car(String vPlateNo, String vMake, String vModel, String vTransmission,
               BigDecimal vRatePerDay, int cNoOfDoors,
               int cNoOfSeats, boolean cAirCondition) {
        super(vPlateNo, vMake, vModel, vTransmission, vRatePerDay);
        this.cNoOfDoors = cNoOfDoors;
        this.cNoOfSeats = cNoOfSeats;
        this.cAirCondition = cAirCondition;
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
        return "" + super.toString() +
                " Car {" +
                "cNoOfDoors=" + cNoOfDoors +
                ", cNoOfSeats=" + cNoOfSeats +
                ", cAirCondition=" + cAirCondition +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        Car car = (Car) o;

        if (cNoOfDoors != car.cNoOfDoors)
            return false;
        if (cNoOfSeats != car.cNoOfSeats)
            return false;
        return cAirCondition == car.cAirCondition;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cNoOfDoors;
        result = 31 * result + cNoOfSeats;
        result = 31 * result + (cAirCondition ? 1 : 0);
        return result;
    }
}
