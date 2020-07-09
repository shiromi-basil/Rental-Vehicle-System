/**
 * The RentalVehicleManager interface holds the declaration of all the methods
 * that has to be implemented in RentalVehicleSystemManager class.
 * <p>
*
 * @author Shiromi Basil
 * @version 1.0
 * @since 15-11-2019
 */
public interface RentalVehicleManager {

    void viewAllVehicle();

    void addCar(Vehicle car);

    void deleteCar(Vehicle car);

    void viewCar(Vehicle car);

    void viewAllCar();

    void addMotorbike(Vehicle motorbike);

    void deleteMotorbike(Vehicle motorbike);

    void viewMotorbike(Vehicle motorbike);

    void viewAllMotorbike();

    void addCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void viewCustomer(Customer customer);

    void viewAllCustomer();

    void readFromDatabase();

    void writeToDatabase();

    void openScheduleGUI();
}
