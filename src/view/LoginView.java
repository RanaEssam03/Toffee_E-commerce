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

import java.io.IOException;
import java.util.Scanner;

public class LoginView {

    TOFFEEView toffeeView;
    SignUpView signUpView;
    AccountManager accountManager = new AccountManager();


    /**
     * RegisterAndLoginView constructor that takes the toffeeView
     * @param toffeeView
     */
    LoginView(TOFFEEView toffeeView) throws IOException {
        this.signUpView = new SignUpView(this);
        this.toffeeView = toffeeView;
        accountManager.getFileHandler().loadData();

    }

    /**
     * This method is used to start the register and login process
     * @throws IOException
     */
    public void start() throws IOException {
        String option ;
        Scanner scan = new Scanner(System.in);

        System.out.println("      ->Welcome to TOFFEE<-");
        System.out.println("1. Sign up");
        System.out.println("2. Login " );
        System.out.print("Please pick one option: ");

        option = scan.next();
        while (!(option.equals("1") || option.equals("2")))
        {
            System.out.println("\nInvalid input!!\n");
            System.out.print("Please pick one option: ");
            option = scan.next();
        }
        if(option.equals("1")){
            signUpView.signUp();
        }
        else{
            login();
        }
    }


    /**
     * This method is used to start the login view
     * @throws IOException
     */
    public void login() throws IOException {
        System.out.println("\n----------Login----------");
        String email, password;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter");
        System.out.print("Email: ");
        email  = scan.nextLine();
        while (!accountManager.isValidEmail(email)){
            System.out.println("\nInvalid Email\n");
            System.out.print("Please Enter\nEmail: ");
            email= scan.nextLine();
        }
        if(accountManager.isUniqueEmail(email)){
            System.out.println("\nEmail does not exist!!\n");
            signUpView.signUp();
        }

        System.out.print("Password: ");
        password = scan.nextLine();


        if(accountManager.checkPassword(email, password)){
           accountManager.getFileHandler().updateFile();
            toffeeView.start();
        }
       else{
           while (!(accountManager.checkPassword(email, password)))
            {
                System.out.println("\nWrong password!!\n");

                System.out.print("Password: ");
                password = scan.nextLine();

            }
           toffeeView.setCustomerId(accountManager.getId(email));
            toffeeView.start();
        }

    }


}
