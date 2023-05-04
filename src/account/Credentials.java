package account;

public class Credentials {
   private String[] emails;
    private String[] passwords;
    private int numUsers;

    public Credentials(int capacity) {
        emails = new String[capacity];
        passwords = new String[capacity];
        numUsers = 0;
    }

    public boolean addUser(String email, String password) {
        // Check if email already exists in the array
        for (int i = 0; i < numUsers; i++) {
            if (emails[i].equals(email)) {
                return false;
            }
        }

        // Add user to the array
        emails[numUsers] = email;
        passwords[numUsers] = password;
        numUsers++;

        return true;
    }

    public boolean checkUser(String e, String p) {
        // Check if email and password match a user in the array
        for (int i = 0; i < numUsers; i++) {
            if (emails[i].equals(e) && passwords[i].equals(p)) {
                return true;
            }
        }

        return false;
    }
}


