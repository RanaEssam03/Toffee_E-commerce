/**
 * RegisterAndLoginView
 * This class is used to register and login the user
 * @see TOFFEEView
 * @see AccountManager
 * @see Credentials
 * @see Customer
 * @auther Rana Essam & Noor Eyad
 */
package view;

import User.AccountManager;
import User.Credentials;
import User.Customer;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class RegisterAndLoginView {

    TOFFEEView toffeeView;
    AccountManager accountManager = new AccountManager();
    /**
     * RegisterAndLoginView constructor that takes the toffeeView
     * @param toffeeView
     */
    RegisterAndLoginView(TOFFEEView toffeeView) throws IOException {
        this.toffeeView = toffeeView;
        accountManager.loadData();

    }

    /**
     * This method is used to start the register and login process
     * @throws IOException
     */
    public void start() throws IOException {
        int option ;
        Scanner scan = new Scanner(System.in);

        System.out.println("      ->Welcome to TOFFEE<-");
        System.out.println("1. Sign up");
        System.out.println("2. Login " );
        System.out.print("Please pick one option: ");

        option = scan.nextInt();
        if(option == 1){
            signUp();
        }
        else{
            login();
        }
    }

    /**
     * This method is used to start the signup view
     * @throws IOException
     */
    private  void signUp() throws IOException {
        System.out.println("\n----------Sign up----------");
        Customer customer = new Customer();
        Scanner scan = new Scanner(System.in);

        String email , password, confirmPassword;
        System.out.println("Please enter");
        System.out.print("Email: ");
        email= scan.nextLine();
        while (!accountManager.isValidEmail(email)){
            System.out.println("Invalid Email");
            System.out.print("Please enter your email: ");
            email= scan.nextLine();
        }
        if (!accountManager.isUniqueEmail(email)){
            System.out.println("You already have an account !");
            login();
            return;
        }

        System.out.print("Password: ");
        password = scan.nextLine();

        System.out.print("Confirm Password: ");
        confirmPassword = scan.nextLine();



        while (!Objects.equals(confirmPassword, password)){
            System.out.println("passwords do not match");
            System.out.print("Password2: ");
            password = scan.nextLine();
            System.out.print("Confirm Password: ");
            confirmPassword = scan.nextLine();

        }
        String otp = accountManager.sendOTP(email);
        System.out.print("Please enter OTP: ");
        String otpMatch = scan.nextLine();

        while (!Objects.equals(otp, otpMatch)){
            System.out.println("Invalid OTP");
            System.out.print("Please enter OTP: ");
             otpMatch = scan.nextLine();
        }
        accountManager.addCustomer(new Credentials(email, password));
        login();


    }

    /**
     * This method is used to start the login view
     * @throws IOException
     */
    private void login() throws IOException {
        System.out.println("\n----------Login----------");
        String email, password;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter");
        System.out.print("Email: ");
        email  = scan.nextLine();
        System.out.print("Password: ");
        password = scan.nextLine();

        if(accountManager.isUniqueEmail(email)){
            System.out.println("Email does not exist!!");
            signUp();
        }

       else if(accountManager.checkPassword(email, password)){
           accountManager.updateFile();
            toffeeView.start();
        }
       else{
           while (!(accountManager.checkPassword(email, password)))
            {
                System.out.println("Wrong password!!");

                System.out.print("Password: ");
                password = scan.nextLine();

            }
            toffeeView.start();


        }


    }



}
