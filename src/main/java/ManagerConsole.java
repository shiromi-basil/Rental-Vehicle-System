import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The ManagerConsole class implements all the methods
 * needed for the functionality and menus needed for manager's console.
 * Student ID: 2018117
 * UoW ID: w1714893
 *
 * @author Shiromi Thevarajan
 * @version 1.0
 * @since 15-11-2019
 */
public class ManagerConsole {
    WestminsterRentalVehicleManager manager = new WestminsterRentalVehicleManager();
    Scanner userInput = new Scanner(System.in);

    public ManagerConsole() {
        super();
    }

    /**
     * This method is used to validate the manager's login credentials.
     */
    public void login() {
        System.out.println("Welcome Westminster Rental Vehicle Service!");
        boolean loginFlag = false;
        while (!loginFlag) {
            System.out.println("Please enter your username: ");
            String username = userInput.next();
            System.out.println("Please enter your password: ");
            String password = userInput.next();

            // Checking if the entered username and password is correct
            if ((username.equals(WestminsterRentalVehicleManager.USERNAME)) &&
                    (password.equals(WestminsterRentalVehicleManager.PASSWORD))) {
                loginFlag = true;
                break;
                // In case of wrong username or password, error message must be displayed
            } else {
                System.out.println("Incorrect username or password!\n" +
                        "Please re-enter your username and password.");
            }
        }
        if (loginFlag) {
            manager.readFromDatabase();
            displayMainMenu();
        }
    }

    /**
     * This is method is used to display main menu and validate user's input.
     */
    public void displayMainMenu() {
        boolean userInputOption = false;

        while (!userInputOption) {
            System.out.println("----------------Main Menu--------------------");
            System.out.println("Please select the entity you want to add/delete/update " +
                    "or " +
                    "view.\n" +
                    "1 - Car\n" +
                    "2 - Motorbike\n" +
                    "3 - Customer\n" +
                    "4 - View All Vehicle\n" +
                    "5 - Schedule (Open GUI)\n" +
                    "0 - Exit Program");
            System.out.println("Please enter the option: ");
            String mainOption = userInput.next();

            switch (mainOption) {
                case "1":
                    System.out.println("You have chosen Car.\n");
                    displayCarMenu();
                    break;

                case "2":
                    System.out.println("You have chosen Motorbike.\n");
                    displayMotorbikeMenu();
                    break;

                case "3":
                    System.out.println("You have chosen Customer.");
                    displayCustomerMenu();
                    break;

                case "4":
                    System.out.println("You have chosen to view all vehicles.\n");
                    manager.viewAllVehicle();
                    break;

                case "5":
                    System.out.println("You have chosen Schedule.");
                    System.out.println("Please wait while the schedule is loading.\n");
                    manager.openScheduleGUI();
                    break;

                case "0":
                    userInputOption = true;
                    break;

                default:
                    System.out.println("Incorrect option has been entered. Please enter" +
                            " an option between 0 - 5." +
                            ".");
                    break;
            }
        }

        if (userInputOption) {
            logout();
        }
    }

    /**
     * This is method is used to display car menu and validate user's input.
     */
    public void displayCarMenu() {
        boolean userInputOption = false;

        while (!userInputOption) {
            System.out.println("----------------Car Sub Menu--------------------");
            System.out.println("Please enter the appropriate number,\n" +
                    "1 - Add Car\n" +
                    "2 - Delete Car\n" +
                    "3 - View Car\n" +
                    "4 - View All Car\n" +
                    "5 - Main Menu\n" +
                    "0 - Exit Program");
            System.out.println("Please enter the option: ");
            String mainOption = userInput.next();

            switch (mainOption) {
                case "1":
                    System.out.println("You have chosen Add Car.\n");
                    Car addCar = userInputAddCar();
                    manager.addCar(addCar);
                    break;

                case "2":
                    System.out.println("You have chosen Delete Car.\n");
                    System.out.println("Please enter the Plate No of the car you want " +
                            "to delete: ");
                    Car deleteCar = userInputSearchCar();
                    manager.deleteCar(deleteCar);
                    break;

                case "3":
                    System.out.println("You have chosen View Car.\n");
                    System.out.println("Please enter the Plate No of the car you want " +
                            "to view: ");
                    Car viewCar = userInputSearchCar();
                    manager.viewCar(viewCar);
                    break;

                case "4":
                    System.out.println("You have chosen view all cars.\n");
                    manager.viewAllCar();
                    break;

                case "5":
                    displayMainMenu();
                    break;

                case "0":
                    userInputOption = true;
                    break;

                default:
                    System.out.println("Incorrect option has been entered. Please enter" +
                            " an option between 0 - 5.");
                    break;
            }
        }

        if (userInputOption) {
            logout();
        }
    }

    /**
     * This is method is used to display motorbike menu and validate user's input.
     */
    public void displayMotorbikeMenu() {
        boolean userInputOption = false;

        while (!userInputOption) {
            System.out.println("----------------Motorbike Sub Menu--------------------");
            System.out.println("Please enter the appropriate number,\n" +
                    "1 - Add Motorbike\n" +
                    "2 - Delete Motorbike\n" +
                    "3 - View Motorbike\n" +
                    "4 - View All Motorbike\n" +
                    "5 - Main Menu\n" +
                    "0 - Exit Program");
            System.out.println("Please enter the option: ");
            String mainOption = userInput.next();

            switch (mainOption) {
                case "1":
                    System.out.println("You have chosen Add Motorbike.\n");
                    Motorbike addMotorbike = userInputAddMotorbike();
                    manager.addMotorbike(addMotorbike);
                    break;

                case "2":
                    System.out.println("You have chosen Delete Motorbike.\n");
                    System.out.println("Please enter the Plate No of the motorbike you " +
                            "want to delete: ");
                    Motorbike deleteMotorbike = userInputSearchMotorbike();
                    manager.deleteMotorbike(deleteMotorbike);
                    break;

                case "3":
                    System.out.println("You have chosen View Motorbike.\n");
                    System.out.println("Please enter the Plate No of the motorbike you " +
                            "want to view: ");
                    Motorbike viewMotorbike = userInputSearchMotorbike();
                    manager.viewMotorbike(viewMotorbike);
                    break;

                case "4":
                    System.out.println("You have chosen view all motorbikes.\n");
                    manager.viewAllMotorbike();
                    break;

                case "5":
                    displayMainMenu();
                    break;

                case "0":
                    userInputOption = true;
                    break;

                default:
                    System.out.println("Incorrect option has been entered. Please enter" +
                            " an option between 0 - 5.");
                    break;
            }
        }

        if (userInputOption) {
            logout();
        }
    }

    /**
     * This is method is used to display customer menu and validate user's input.
     */
    public void displayCustomerMenu() {
        boolean userInputOption = false;

        while (!userInputOption) {
            System.out.println("----------------Customer Sub Menu--------------------");
            System.out.println("Please enter the appropriate number,\n" +
                    "1 - Add Customer\n" +
                    "2 - Delete Customer\n" +
                    "3 - View Customer\n" +
                    "4 - View All Customer\n" +
                    "5 - Main Menu\n" +
                    "0 - Exit Program");
            System.out.println("Please enter the option: ");
            String mainOption = userInput.next();

            switch (mainOption) {
                case "1":
                    System.out.println("You have chosen Add Customer.\n");
                    Customer addCustomer = userInputAddCustomer();
                    manager.addCustomer(addCustomer);
                    break;

                case "2":
                    System.out.println("You have chosen Delete Customer.\n");
                    System.out.println("Please enter the ID of the customer you " +
                            "want to delete: ");
                    Customer deleteCustomer = userInputSearchCustomer();
                    manager.deleteCustomer(deleteCustomer);
                    break;

                case "3":
                    System.out.println("You have chosen View Customer.\n");
                    System.out.println("Please enter the ID of the customer you " +
                            "want to view: ");
                    Customer viewCustomer = userInputSearchCustomer();
                    manager.viewCustomer(viewCustomer);
                    break;

                case "4":
                    System.out.println("You have chosen View All Customer.\n");
                    manager.viewAllCustomer();
                    break;

                case "5":
                    displayMainMenu();
                    break;

                case "0":
                    userInputOption = true;
                    break;

                default:
                    System.out.println("Incorrect option has been entered. Please enter" +
                            " an option between 0 - 5.");
                    break;
            }
        }

        if (userInputOption) {
            logout();
        }
    }

    /**
     * This is method is used to validate integer input.
     *
     * @param integer This is user's input.
     * @return boolean This will return true if the input is an integer.
     */
    public boolean isIntValid(int integer) {
        if (integer != 0 && integer > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int userInputInt(String message) {
        System.out.println(message);

        try {
            int integer = Integer.parseInt(userInput.next());
            if (isIntValid(integer)) {
                return integer;
            } else {
                System.out.println("Please enter a value greater than zero!");
                return userInputInt(message);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Please enter an integer value!");
            return userInputInt(message);
        }
    }

    /**
     * This is method is used to validate big decimal input.
     *
     * @param bigDecimal This is user's input.
     * @return boolean This will return true if the input is a big decimal.
     */
    public boolean isBigDecimalValid(BigDecimal bigDecimal) {
        if (bigDecimal.signum() != 0 && bigDecimal.signum() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal userInputBigDecimal(String message) {
        System.out.println(message);

        try {
            BigDecimal bigDecimal = new BigDecimal(userInput.next());
            if (isBigDecimalValid(bigDecimal)) {
                return bigDecimal;
            } else {
                System.out.println("Please enter a value greater than zero!");
                return userInputBigDecimal(message);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Please enter a big decimal value!");
            return userInputBigDecimal(message);
        }
    }

    /**
     * This is method is used to validate boolean input.
     *
     * @param stringBool This is user's input.
     * @return boolean This will return true if the input is a boolean.
     */
    public boolean isBooleanValid(String stringBool) {
        if ((stringBool.equals("true")) || (stringBool.equals("false"))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean userInputBoolean(String message) {
        System.out.println(message);

        try {
            String stringBool = userInput.next().toLowerCase();
            if (isBooleanValid(stringBool)) {
                boolean bool = Boolean.parseBoolean(stringBool);
                return bool;
            } else {
                System.out.println("Please true or false!");
                return userInputBoolean(message);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Please enter a boolean value!");
            return userInputBoolean(message);
        }
    }

    /**
     * This is method is used to validate string input.
     *
     * @param string This is user's input.
     * @return boolean This will return true if the input is a string.
     */
    public boolean isStringValid(String string) {
        if ((string.matches("[A-Za-z0-9]+")) && (!(string.matches("[0-9]+")))) {
            return true;
        } else {
            return false;
        }
    }

    public String userInputString(String message) {
        System.out.println(message);

        try {
            String string = userInput.next();
            if (isStringValid(string)) {
                return string;
            } else {
                System.out.println("Please enter an alphanumeric string!");
                return userInputString(message);
            }
        } catch (Exception e) {
            System.out.println("Please enter an alphanumeric string!");
            return userInputString(message);
        }
    }

    /**
     * This is method is used to validate contact number input.
     *
     * @param string This is user's input.
     * @return boolean This will return true if the input is a valid contact number.
     */
    public boolean isContactStringValid(String string) {
        if ((string.matches("[0-9]+")) && string.length() == 10) {
            return true;
        } else {
            return false;
        }
    }

    public String userInputContactString(String message) {
        System.out.println(message);

        try {
            String contactString = userInput.next();
            if (isContactStringValid(contactString)) {
                return contactString;
            } else {
                System.out.println("Please enter a valid contact number!");
                return userInputContactString(message);

            }
        } catch (Exception e) {
            System.out.println("Please enter a valid contact number!");
            return userInputContactString(message);
        }
    }

    /**
     * This is method is used to validate double input.
     *
     * @param doubleVariable This is user's input.
     * @return boolean This will return true if the input is a double.
     */
    public boolean isDoubleValid(double doubleVariable) {
        if (doubleVariable != 0 && doubleVariable > 0) {
            return true;
        } else {
            return false;
        }
    }

    public double userInputDouble(String message) {
        System.out.println(message);

        try {
            double doubleVariable = Double.parseDouble(userInput.next());
            if (isDoubleValid(doubleVariable)) {
                return doubleVariable;
            } else {
                System.out.println("Please enter a value greater than zero!");
                return userInputDouble(message);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Please enter a double value!");
            return userInputDouble(message);
        }
    }

    /**
     * This is method is used to receive user input for add car method.
     *
     * @return Car This will return the new car object created with the received details.
     */
    public Car userInputAddCar() {
        System.out.println("Please enter the car following details,");

        String vPlateNo = userInputString("Vehicle Plate No: ");
        String vMake = userInputString("Vehicle Make: ");
        String vModel = userInputString("Vehicle Model: ");
        String vTransmission = userInputString("Vehicle Transmission: ");
        BigDecimal vRatePerDay = userInputBigDecimal("Rate Per Day: ");
        int cNoOFDoors = userInputInt("No of Doors: ");
        int cNoOFSeats = userInputInt("No of Seats: ");
        boolean cAirCondition = userInputBoolean("A/C Availability" +
                " (true/false): ");

        return new Car(vPlateNo, vMake, vModel, vTransmission, vRatePerDay, cNoOFDoors,
                cNoOFSeats, cAirCondition);
    }

    public Car userInputSearchCar() {
        String vPlateNo = userInputString("Vehicle Plate No: ");

        for (Car car : manager.carList) {
            if (vPlateNo.equals(car.getvPlateNo())) {
                return car;
            }
        }
        return null;
    }

    /**
     * This is method is used to receive user input for add motorbike method.
     *
     * @return Motorbike This will return the new motorbike object created with the
     * received
     * details.
     */
    public Motorbike userInputAddMotorbike() {
        System.out.println("Please enter the motorbike following details,");

        String vPlateNo = userInputString("Vehicle Plate No: ");
        String vMake = userInputString("Vehicle Make: ");
        String vModel = userInputString("Vehicle Model: ");
        String vTransmission = userInputString("Vehicle Transmission: ");
        BigDecimal vRatePerDay = userInputBigDecimal("Rate Per Day: ");
        double mPetrolCapacity = userInputDouble("Petrol Capacity: ");
        String mType = userInputString("Motorbike Type: ");

        return new Motorbike(vPlateNo, vMake, vModel, vTransmission, vRatePerDay,
                mPetrolCapacity, mType);
    }

    public Motorbike userInputSearchMotorbike() {
        String vPlateNo = userInputString("Vehicle Plate No: ");

        for (Motorbike motorbike : manager.motorbikeList) {
            if (vPlateNo.equals(motorbike.getvPlateNo())) {
                return motorbike;
            }
        }
        return null;
    }

    /**
     * This is method is used to receive user input for add customer method.
     *
     * @return Customer This will return the new customer object created with the
     * received details.
     */
    public Customer userInputAddCustomer() {
        System.out.println("Please enter the customer following details,");

        String cusID = userInputString("Customer ID: ");
        String cusName = userInputString("Customer Name: ");
        String cusContactNo = userInputContactString("Contact Number: ");
        String cusLicenseNo = userInputString("License Number: ");

        return new Customer(cusID, cusName, cusContactNo, cusLicenseNo);
    }

    public Customer userInputSearchCustomer() {
        String cusID = userInputString("Customer ID: ");

        for (Customer customer : manager.customerList) {
            if (cusID.equals(customer.getCusID())) {
                return customer;
            }
        }
        return null;
    }

    public void logout() {
        manager.deleteFromDatabase();
        manager.writeToDatabase();
        // closing the scanner object to avoid memory leak
        userInput.close();
        System.out.println("Thank you for using Westminster Rental Vehicle Service!");
        System.exit(0);
    }

    public static void main(String[] args) {
        ManagerConsole managerConsole = new ManagerConsole();
        managerConsole.login();
    }
}
