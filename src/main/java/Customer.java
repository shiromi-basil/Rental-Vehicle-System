import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Customer class implements all the attributes and methods
 * of customer object.
 * <p>
 * Student ID: 2018117
 * UoW ID: w1714893
 *
 * @author Shiromi Thevarajan
 * @version 1.0
 * @since 15-11-2019
 */
@Entity
public class Customer implements Comparable<Customer> {
    @Id
    private String cusID;
    private String cusName;
    private String cusContactNo;
    private String cusLicenseNo;

    public Customer() {
        super();
    }

    public Customer(String cusID, String cusName, String cusContactNo,
                    String cusLicenseNo) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusContactNo = cusContactNo;
        this.cusLicenseNo = cusLicenseNo;
    }

    public String getCusID() {
        return cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusContactNo() {
        return cusContactNo;
    }

    public void setCusContactNo(String cusContactNo) {
        this.cusContactNo = cusContactNo;
    }

    public String getCusLicenseNo() {
        return cusLicenseNo;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "cusID='" + cusID + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusContactNo='" + cusContactNo + '\'' +
                ", cusLicenseNo='" + cusLicenseNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Customer customer = (Customer) o;

        if (!cusID.equals(customer.cusID))
            return false;
        if (!cusName.equals(customer.cusName))
            return false;
        if (!cusContactNo.equals(customer.cusContactNo))
            return false;
        return cusLicenseNo.equals(customer.cusLicenseNo);
    }

    @Override
    public int hashCode() {
        int result = cusID.hashCode();
        result = 31 * result + cusName.hashCode();
        result = 31 * result + cusContactNo.hashCode();
        result = 31 * result + cusLicenseNo.hashCode();
        return result;
    }

    @Override
    public int compareTo(Customer customer) {
        return this.getCusID().compareTo(customer.getCusID());
    }
}
