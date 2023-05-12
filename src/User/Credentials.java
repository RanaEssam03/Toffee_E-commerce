/**
 * Credentials.java
 * This class represents the credentials of the user
 * @see User
 * @see Account
 * @auther Nourhan Abdullah
 */
package User;

public class Credentials {

    /**
     * This String represents the email of the user
     */
    String email;
    /**
     * This String represents the password of the user
     */
    String password;

    /**
     * Credentials constructor that takes the email and password of the user
     * @param email : String represents the email of the user
     * @param password : String represents the password of the user
     */
    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Credentials constructor that takes no parameters
     * @return email : String represents the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method is used to set the email of the user
     * @param email : String represents the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method is used to get the password of the user
     * @return password : String represents the password of the user
     */
    public String getPassword() {
        return password;
    }
    /**
     * This method is used to set the password of the user
     * @param password : String represents the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

}

