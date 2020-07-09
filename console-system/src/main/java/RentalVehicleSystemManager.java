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
 * The RentalVehicleSystemManager class implements all the methods
 * of the manager's actions.
 *
 * @author Shiromi Basil
 * @version 1.0
 * @since 15-11-2019
 */
public class RentalVehicleSystemManager implements RentalVehicleManager {
    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "1234";

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("PersistenceUnit");

    protected List<Vehicle> vehicleList = new ArrayList<>();
    protected List<Customer> customerList = new ArrayList<>();

    public RentalVehicleSystemManager() {
        super();
    }

    /**
     * This method is used to view all vehicles.
     */
    public void viewAllVehicle() {
        if (vehicleList == null) {
            System.out.println("No car or motorbike has been added!.\nPlease add a " +
                    "vehicle.");
        } else {
            Collections.sort(vehicleList);
            System.out.println("Plate Number| Make | Model | Transmission " +
                    "| Rate Per Day | No of Doors | No of " +
                    "Seats | A/C availability");
            for (Vehicle car : vehicleList) {
                if (car instanceof Car) {
                    System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10d|%10d|%10s\n",
                            car.getvPlateNo()
                            , car.getvMake(), car.getvModel(), car.getvTransmission()
                            , car.getvRatePerDay(), ((Car) car).getcNoOfDoors()
                            , ((Car) car).getcNoOfSeats(), ((Car) car).iscAirCondition());
                }
            }

            System.out.println("\nPlate Number| Make | Model | Transmission " +
                    "| Rate Per Day | Petrol Capacity | Motorbike Type | Model Year");
            for (Vehicle motorbike : vehicleList) {
                if (motorbike instanceof Motorbike) {
                    System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10s|%10s|%10d\n"
                            , motorbike.getvPlateNo()
                            , motorbike.getvMake(), motorbike.getvModel(),
                            motorbike.getvTransmission()
                            , motorbike.getvRatePerDay(),
                            ((Motorbike) motorbike).getmPetrolCapacity()
                            , ((Motorbike) motorbike).getmType(),
                            ((Motorbike) motorbike).getmModelYear());
                }
            }
        }
    }

    /**
     * This method is used to check if the parking lot is full.
     */
    public boolean isParkingFull(List vehicleList) {
        int noOfOccupiedLots = vehicleList.size();
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
    public void addCar(Vehicle car) {
        if (!(isParkingFull(vehicleList))) {
            vehicleList.add(car);
            System.out.println(car);
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
    public void deleteCar(Vehicle car) {
        vehicleList.remove(car);
        System.out.println("Car Successfully Deleted!");
        int noOfOccupiedLots = vehicleList.size();
        System.out.println("Available parking lots in the garage: " + (50 - noOfOccupiedLots));
    }

    /**
     * This method is used to view a car with the vehicle plate number user entered.
     *
     * @param car This the car object with the vehicle plate number user entered.
     */
    public void viewCar(Vehicle car) {
        System.out.println(car);
    }

    public void viewAllCar() {
        int carCount = 0;
        System.out.println("Plate Number| Make | Model | Transmission " +
                "| Rate Per Day | No of Doors | No of " +
                "Seats | A/C Availability");

        Collections.sort(vehicleList);
        for (Vehicle car : vehicleList) {
            if (car instanceof Car) {
                System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10d|%10d|%10s\n",
                        car.getvPlateNo()
                        , car.getvMake(), car.getvModel(), car.getvTransmission()
                        , car.getvRatePerDay(), ((Car) car).getcNoOfDoors()
                        , ((Car) car).getcNoOfSeats(), ((Car) car).iscAirCondition());
                carCount++;
            }
        }

        if (carCount == 0) {
            System.out.println("No car has been added!.\nPlease add a car.");
        }
    }

    public void addMotorbike(Vehicle motorbike) {
        if (!(isParkingFull(vehicleList))) {
            vehicleList.add(motorbike);
            System.out.println(motorbike);
            System.out.println("Motorbike Successfully Added!");
        } else {
            System.out.println("Sorry! Vehicle Parking in the garage is full.");
        }
    }

    public void deleteMotorbike(Vehicle motorbike) {
        vehicleList.remove(motorbike);
        System.out.println("Motorbike Successfully Deleted!");
        int noOfOccupiedLots = vehicleList.size();
        System.out.println("Available parking lots in the garage: " + noOfOccupiedLots);
    }

    public void viewMotorbike(Vehicle motorbike) {
        System.out.println(motorbike);
    }

    public void viewAllMotorbike() {
        int bikeCount = 0;
        System.out.println("Plate Number| Make | Model | Transmission " +
                "| Rate Per Day | Petrol Capacity | Motorbike Type | Model Year");

        Collections.sort(vehicleList);
        for (Vehicle motorbike : vehicleList) {
            if (motorbike instanceof Motorbike) {
                System.out.printf("%10s|%10s|%10s|%10s|%10.2f|%10s|%10s|%10d\n"
                        , motorbike.getvPlateNo()
                        , motorbike.getvMake(), motorbike.getvModel(),
                        motorbike.getvTransmission()
                        , motorbike.getvRatePerDay(),
                        ((Motorbike) motorbike).getmPetrolCapacity()
                        , ((Motorbike) motorbike).getmType(),
                        ((Motorbike) motorbike).getmModelYear());
                bikeCount++;
            }
        }

        if (bikeCount == 0) {
            System.out.println("No motorbike has been added!.\nPlease add a motorbike.");
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
            vehicleList =
                    entityManager.createQuery("select car from Car car").getResultList();

            List bikeList =
                    entityManager.createQuery("select motorbike from Motorbike " +
                            "motorbike").getResultList();
            for (Object bike : bikeList) {
                vehicleList.add((Vehicle) bike);
            }

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

            for (Vehicle vehicle : vehicleList) {
                entityManager.persist(vehicle);
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
