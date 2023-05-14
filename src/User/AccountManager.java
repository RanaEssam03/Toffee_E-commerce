/**
 * AccountManager class is responsible for managing the accounts of the users
 * @auther Nourhan Abdullah
 * @version 1.0
 * @since 2021-05-09
 */
package User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class AccountManager {
    /**
     * This String represents the path of the file that contains the accounts of the users
     */
    private static final String emailReg = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";

    /**
     * This HashMap contains the accounts of the users with their passwords
     * @see Customer
     */
   private HashMap<String , String> accounts = new HashMap<>();
   private ArrayList<Customer> customers = new ArrayList<>();
    private int accountID;
    FileHandler fileHandler;

    OTPHandler otpHandler = new OTPHandler();

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public AccountManager(){
        fileHandler = new FileHandler(this);
    }

    public OTPHandler getOtpHandler() {
        return otpHandler;
    }

    public void setOtpHandler(OTPHandler otpHandler) {
        this.otpHandler = otpHandler;
    }

    public int getAccountID() {
        return accountID;
    }

    public HashMap<String, String> getAccounts() {
        return accounts;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void setAccounts(HashMap<String, String> accounts) {
        this.accounts = accounts;
    }

    public int getId(String email){
        for(int i = 0 ; i < customers.size() ; i++){
            if(Objects.equals(customers.get(i).getCredentials().getEmail(), email)){
                return customers.get(i).getCustomerId();
            }
        }
        return 0;
    }


    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }


    /**
     * This method is responsible for checking if the email is unique or not "already exists"
     * @param email
     * @return true if the email is unique and false if it is not
     */
    public boolean isUniqueEmail(String email){
        return (accounts.get(email) == null);
    }

    public boolean isValidPhone(String phone){
        return phone.matches("[0-9]+") && phone.length() == 11;
    }

    /**
     * This method is responsible for checking if the email is valid or not
     * @param email
     * @return true if the email is valid and false if it is not
     */
    public boolean isValidEmail(String email){
        return Pattern.compile(emailReg).matcher(email).matches();
    }
    /**
     * This method is responsible for adding a new user to the accounts HashMap
     * @param credentials
     * @see Credentials
     */
    public int addCustomer(Credentials credentials, String phone) {
        accounts.put(credentials.getEmail(), credentials.getPassword());
        int id = ++accountID;
        customers.add(new Customer(credentials, phone, id));
        return id;
    }


    /**
     * This method is responsible for checking if the password is correct or not
     * @param email
     * @param password
     * @return true if the password is correct and false if it is not
     */
    public boolean checkPassword(String email, String password){
        return Objects.equals(accounts.get(email), password);
    }




}
