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


    RegisterAndLoginView(TOFFEEView toffeeView) throws IOException {
        this.toffeeView = toffeeView;
        accountManager.loadData();

    }


    public void start() throws IOException {
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println("            Welcome to TOFFEE");
        System.out.println("Please pick one option ");
        System.out.println("1. Sign up");
        System.out.println("2. Login ");

        option = scan.nextInt();
        if (option == 1) {
            signUp();
        } else {
            login();
        }
    }

    private void signUp() throws IOException {
        Customer customer = new Customer();
        Scanner scan = new Scanner(System.in);

        String email, password, confirmPassword;
        System.out.print("Please enter your email: ");
        email = scan.nextLine();
        while (!accountManager.isValidEmail(email)) {
            System.out.println("Invalid Email");
            System.out.print("Please enter your email: ");
            email = scan.nextLine();
        }
        if (!accountManager.isUniqueEmail(email)) {
            System.out.println("You already have an account !");
            login();
        }

        System.out.print("Password: ");
        password = scan.nextLine();

        System.out.print("Confirm Password: ");
        confirmPassword = scan.nextLine();


        while (!Objects.equals(confirmPassword, password)) {
            System.out.println("passwords do not match");
            System.out.print("Password: ");
            password = scan.nextLine();
            System.out.print("Confirm Password: ");
            confirmPassword = scan.nextLine();

        }
        String otp = accountManager.sendOTP(email);
        System.out.print("Please enter OTP: ");
        String otpMatch = scan.nextLine();

        while (!Objects.equals(otp, otpMatch)) {
            System.out.println("Invalid OTP");
            System.out.print("Please enter OTP: ");
            otpMatch = scan.nextLine();
        }
        accountManager.addUser(new Credentials(email, password));
        login();

    }

    private void login() throws IOException {
        String email, password;
        Scanner scan = new Scanner(System.in);
        System.out.println("    Please enter");
        System.out.print("Email: ");
        email = scan.nextLine();
        System.out.print("Password: ");
        password = scan.nextLine();

        if (accountManager.isUniqueEmail(email)) {
            System.out.println("Email does not exist ");
            signUp();
        } else if (accountManager.checkPassword(email, password)) {
            accountManager.updateFile();
            toffeeView.start();
        } else {
            while (!(accountManager.checkPassword(email, password))) {
                System.out.println("Invalid password");

                System.out.print("Password: ");
                password = scan.nextLine();

            }
        }


    }


}
