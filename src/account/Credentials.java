package account;

public class Credentials {
   private String[] email;
    private String[] password;
    private int numUsers;

    public Credentials(int capacity) {
        email = new String[capacity];
        password = new String[capacity];
        numUsers = 0;
    }

    public boolean addUser(String email, String password) {
        // Check if email already exists in the array
        for (int i = 0; i < numUsers; i++) {
            if (email[i].equals(email)) {
                return false;
            }
        }

        // Add user to the array
        email[numUsers] = email;
        password[numUsers] = password;
        numUsers++;

        return true;
    }

    public boolean checkUser(String e, String p) {
        // Check if email and password match a user in the array
        for (int i = 0; i < numUsers; i++) {
            if (email[i].equals(e) && password[i].equals(p)) {
                return true;
            }
        }

        return false;
    }
}
}
}
