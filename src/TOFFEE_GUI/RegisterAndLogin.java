package TOFFEE_GUI;

import User.Account;
import User.AccountManager;
import User.Credentials;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class RegisterAndLogin {

    TOFFEE toffee = new TOFFEE();

    Credentials credentials = new Credentials();
    AccountManager accountManager = new AccountManager(credentials);

    public void start() throws IOException {
        int option ;
        Scanner scan = new Scanner(System.in);

        System.out.println("            Welcome to TOFFEE");
        System.out.println("Please pick one option ");
        System.out.println("1. Sign up");
        System.out.println("2. Login " );

        option = scan.nextInt();
        if(option == 1){
            signUp();
        }
        else{
            login();
        }
    }

    private  void signUp() throws IOException {
        Scanner scan = new Scanner(System.in);

        String email , password, confirmPassword;
        System.out.print("Please enter your email: ");
        email= scan.nextLine();
        while (!credentials.isValidEmail(email)){
            System.out.println("Invalid Email");
            System.out.print("Please enter your email: ");
            email= scan.nextLine();
        }
        if (!credentials.isUniqueEmail(email)){
            System.out.println("You already have an account !");
            // TODO call login fun
        }

        System.out.print("Password: ");
        password = scan.nextLine();

        System.out.print("Confirm Password: ");
        confirmPassword = scan.nextLine();

        while (!Objects.equals(confirmPassword, password)){
            System.out.println("passwords do not match");
            System.out.print("Password: ");
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
        credentials.addUser(new Account(email, password));
        login();

    }

    private void login() throws IOException {
        String email, password;
        Scanner scan = new Scanner(System.in);
        System.out.println("    Please enter");
        System.out.print("Email: ");
        email  = scan.nextLine();
        System.out.print("Password: ");
        password = scan.nextLine();

        if(credentials.isUniqueEmail(email)){
            System.out.println("Email does not exist ");
            signUp();
        }

       else if(credentials.checkPassword(email, password)){
            toffee.start();
        }
       else{
           while (!(credentials.checkPassword(email, password)))
            {
                System.out.println("Invalid password");

                System.out.print("Password: ");
                password = scan.nextLine();

            }
        }


    }



}


//public class Test {
//
//    public static void main(final String[] args) throws Exception {
//        ConsoleReader reader = new ConsoleReader();
//        Character mask = '*';
//        String line = null;
//        do {
//            line = reader.readLine("Enter Password(blank pwd to exit)> ", mask);
//            System.out.println("Got password: " + line);
//        } while (line != null && line.length() > 0);
//    }
//
//}
