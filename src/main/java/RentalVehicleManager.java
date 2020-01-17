/**
 * The RentalVehicleManager interface holds the declaration of all the methods
 * that has to be implemented in WestminsterRentalVehicleManager class.
 * <p>
 * Student ID: 2018117
 * UoW ID: w1714893
 *
 * @author Shiromi Thevarajan
 * @version 1.0
 * @since 15-11-2019
 */
public interface RentalVehicleManager {

    void viewAllVehicle();

    void addCar(Car car);

    void deleteCar(Car car);

    void viewCar(Car car);

    void viewAllCar();

    void addMotorbike(Motorbike motorbike);

    void deleteMotorbike(Motorbike motorbike);

    void viewMotorbike(Motorbike motorbike);

    void viewAllMotorbike();

    void addCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void viewCustomer(Customer customer);

    void viewAllCustomer();

    void readFromDatabase();

    void writeToDatabase();

    void openScheduleGUI();
}
