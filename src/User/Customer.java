/**
 *
 */
package User;

public class Customer{
    Credentials credentials;
    int CustomerId;
    String phone;
    Address address;
    int LoyaltyPoints;

    public Credentials getCredentials() {
        return credentials;
    }

    public Customer(Credentials credentials,String phone, int CustomerID ) {
        this.credentials = credentials;

    }

    public Customer() {
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getLoyaltyPoints() {
        return LoyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        LoyaltyPoints = loyaltyPoints;
    }
}