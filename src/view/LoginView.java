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
        int option ;
        Scanner scan = new Scanner(System.in);

        System.out.println("      ->Welcome to TOFFEE<-");
        System.out.println("1. Sign up");
        System.out.println("2. Login " );
        System.out.print("Please pick one option: ");

        option = scan.nextInt();
        if(option == 1){
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
        System.out.print("Password: ");
        password = scan.nextLine();

        if(accountManager.isUniqueEmail(email)){
            System.out.println("Email does not exist!!");
            signUpView.signUp();
        }

       else if(accountManager.checkPassword(email, password)){
           accountManager.getFileHandler().updateFile();
            toffeeView.start();
        }
       else{
           while (!(accountManager.checkPassword(email, password)))
            {
                System.out.println("Wrong password!!");

                System.out.print("Password: ");
                password = scan.nextLine();

            }
           toffeeView.setCustomerId(accountManager.getId(email));
            toffeeView.start();
        }

    }


}
