import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The WestminsterRentalVehicleManager class implements all the methods
 * of the manager's actions.
 * Student ID: 2018117
 * UoW ID: w1714893
 *
 * @author Shiromi Thevarajan
 * @version 1.0
 * @since 15-11-2019
 */
public class WestminsterRentalVehicleManager implements RentalVehicleManager {
    public static final String USERNAME = "Shiromi";
    public static final String PASSWORD = "5614";

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("w1714893PersistenceUnit");

    protected List<Car> carList = new ArrayList<>();
    protected List<Motorbike> motorbikeList = new ArrayList<>();
    protected List<Customer> customerList = new ArrayList<>();

    public WestminsterRentalVehicleManager() {
        super();
    }

    /**
     * This method is used to view all vehicles.
     */
    public void viewAllVehicle() {
        if (carList == null && motorbikeList == null) {
            System.out.println("No car or motorbike has been added!.\nPlease add a " +
                    "vehicle.");
        } else {
            Collections.sort(carList);
            System.out.println("Plate Number| Make | Model | Transmission " +
                    "| Rate Per Day | No of Doors | No of " +
                    "Seats | A/C availability");
            for (Car car : carList) {
                System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10d|%10d|%10s\n",
                        car.getvPlateNo()
                        , car.getvMake(), car.getvModel(), car.getvTransmission()
                        , car.getvRatePerDay(), car.getcNoOfDoors()
                        , car.getcNoOfSeats(), car.iscAirCondition());
            }

            Collections.sort(motorbikeList);
            System.out.println("Plate Number| Make | Model | Transmission " +
                    "| Rate Per Day | Petrol Capacity | Motorbike Type");
            for (Motorbike motorbike : motorbikeList) {
                System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10f|%10s|%10s\n"
                        , motorbike.getvPlateNo()
                        , motorbike.getvMake(), motorbike.getvModel(),
                        motorbike.getvTransmission()
                        , motorbike.getvRatePerDay(), motorbike.getmPetrolCapacity()
                        , motorbike.getmType());
            }
        }
    }

    /**
     * This method is used to check if the parking lot is full.
     */
    public boolean isParkingFull(List carList, List motorbikeList) {
        int noOfOccupiedLots = carList.size() + motorbikeList.size();
        if (noOfOccupiedLots > 50) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to add car to car list.
     *
     * @param car This is the car object that has to be added to the car list.
     */
    public void addCar(Car car) {
        if (!(isParkingFull(carList, motorbikeList))) {
            carList.add(car);
            System.out.println("Car Successfully Added!");
        } else {
            System.out.println("Sorry! Vehicle Parking in the garage is full.");
        }
    }

    /**
     * This method is used to delete car from the car list.
     *
     * @param car This is the car object that has to be deleted from the car list.
     */
    public void deleteCar(Car car) {
        carList.remove(car);
        System.out.println("Car Successfully Deleted!");
        int noOfOccupiedLots = carList.size() + motorbikeList.size();
        System.out.println("Available parking lots in the garage: " + (50 - noOfOccupiedLots));
    }

    /**
     * This method is used to view a car with the vehicle plate number user entered.
     *
     * @param car This the car object with the vehicle plate number user entered.
     */
    public void viewCar(Car car) {
        System.out.println(car);
    }

    public void viewAllCar() {
        if (carList == null) {
            System.out.println("No car has been added!.\nPlease add a car.");
        } else {
            Collections.sort(carList);
            System.out.println("Plate Number| Make | Model | Transmission " +
                    "| Rate Per Day | No of Doors | No of " +
                    "Seats | A/C Availability");
            for (Car car : carList) {
                System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10d|%10d|%10s\n",
                        car.getvPlateNo()
                        , car.getvMake(), car.getvModel(), car.getvTransmission()
                        , car.getvRatePerDay(), car.getcNoOfDoors()
                        , car.getcNoOfSeats(), car.iscAirCondition());
            }
        }
    }

    public void addMotorbike(Motorbike motorbike) {
        if (!(isParkingFull(carList, motorbikeList))) {
            motorbikeList.add(motorbike);
            System.out.println("Motorbike Successfully Added!");
        } else {
            System.out.println("Sorry! Vehicle Parking in the garage is full.");
        }
    }

    public void deleteMotorbike(Motorbike motorbike) {
        motorbikeList.remove(motorbike);
        System.out.println("Motorbike Successfully Deleted!");
        int noOfOccupiedLots = carList.size() + motorbikeList.size();
        System.out.println("Available parking lots in the garage: " + noOfOccupiedLots);
    }

    public void viewMotorbike(Motorbike motorbike) {
        System.out.println(motorbike);
    }

    public void viewAllMotorbike() {
        if (motorbikeList == null) {
            System.out.println("No motorbike has been added!.\nPlease add a motorbike.");
        } else {
            Collections.sort(motorbikeList);
            System.out.println("Plate Number| Make | Model | Transmission " +
                    "| Rate Per Day | Petrol Capacity | Motorbike Type");
            for (Motorbike motorbike : motorbikeList) {
                System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10d|%10d|%10s\n"
                        , motorbike.getvPlateNo()
                        , motorbike.getvMake(), motorbike.getvModel(),
                        motorbike.getvTransmission()
                        , motorbike.getvRatePerDay(), motorbike.getmPetrolCapacity()
                        , motorbike.getmType());
            }
        }
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
        System.out.println("Customer Successfully Added!");
    }

    public void deleteCustomer(Customer customer) {
        customerList.remove(customer);
        System.out.println("Customer Successfully Deleted!");
    }

    public void viewCustomer(Customer customer) {
        System.out.println(customer);
    }

    public void viewAllCustomer() {
        if (customerList == null) {
            System.out.println("No customer has been added!.\nPlease add a customer.");
        } else {
            Collections.sort(customerList);
            System.out.println("Customer ID| Customer Name | Contact Number | " +
                    "License Number");
            for (Customer customer : customerList) {
                System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10d|%10d|%10s\n"
                        , customer.getCusID(), customer.getCusName(),
                        customer.getCusContactNo(), customer.getCusLicenseNo());
            }
        }
    }

    public void readFromDatabase() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            carList =
                    entityManager.createQuery("select car from Car car").getResultList();
            motorbikeList =
                    entityManager.createQuery("select motorbike from Motorbike " +
                            "motorbike").getResultList();
            customerList =
                    entityManager.createQuery("select customer from Customer customer").getResultList();
            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void writeToDatabase() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            for (Car car : carList) {
                entityManager.persist(car);
            }
            for (Motorbike motorbike : motorbikeList) {
                entityManager.persist(motorbike);
            }
            for (Customer customer : customerList) {
                entityManager.persist(customer);
            }
            entityTransaction.commit();
        } catch (NullPointerException ex) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();

        } finally {
            entityManager.close();
        }
    }

    public void deleteFromDatabase() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            List<Car> carRemoveList =
                    entityManager.createQuery("select c from Car c").getResultList();
            List<Motorbike> motorbikeRemoveList = entityManager.createQuery("select m " +
                    "from Motorbike m").getResultList();
            List<Customer> customerRemoveList = entityManager.createQuery("select cu " +
                    "from Customer cu").getResultList();
            for (Car car : carRemoveList) {
                Car carManaged = entityManager.merge(car);
                entityManager.remove(carManaged);
            }
            for (Motorbike motorbike : motorbikeRemoveList) {
                Motorbike motorbikeManaged = entityManager.merge(motorbike);
                entityManager.remove(motorbikeManaged);
            }
            for (Customer customer : customerRemoveList) {
                Customer customerManaged = entityManager.merge(customer);
                entityManager.remove(customerManaged);
            }
            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public void openScheduleGUI() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("http://localhost:4200"));
            System.out.println("Please check your browser!");
        } catch (IOException | URISyntaxException e2) {
            System.out.println("Error! Please check your GUI connection.");
        }
    }
}
