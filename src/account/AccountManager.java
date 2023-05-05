package account;

import java.net.SocketOption;

public class AccountManager {
       //to manage registered users
        private Credentials credentials;

    public AccountManager(Credentials credentials) {
            this.credentials = credentials;
        }

    /**
     *
     * @param email of the new user
     * @param password of the new user
     * both args are to be added to the object credentials' method 'addUser'
     * so that it add the new user to the registered ones
     */
        public void addUser(String email, String password) {
            credentials.addUser(email, password);
        }
    }
