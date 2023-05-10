/**
 * Credentials.java
 * This class represents the credentials of the user
 * @see User
 * @see Account
 * @auther Nourhan Abdullah
 */
package User;

public class Credentials {

    String email;
    String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

