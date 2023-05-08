//package User;
//
//
//
//public class Customer {
//
//    private Credentials credentials;
//
//    /**
//     *
//     * @param credentials taken as an input to allow Customer class to check
//     * user credentials in the database storing the registered users
//     */
//    public Customer(Credentials credentials) {
//        this.credentials = credentials;
//    }
//
//    /**
//     *
//     * @param e taken as input
//     * @param p taken as input
//     * @return 'true' if e and p match a user in the Credentials object
//     */
//    public boolean auth(String e, String p) {
//        return credentials.checkUser(e, p);
//    }
//}