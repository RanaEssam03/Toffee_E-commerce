package view;

import User.Credentials;
import User.Customer;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class SignUpView {

    LoginView loginView;

    SignUpView(LoginView loginView){
        this.loginView = loginView;
    }
    /**
     * This method is used to start the signup view
     * @throws IOException
     */
    public void signUp() throws IOException {
        System.out.println("\n----------Sign up----------");
        Customer customer = new Customer();
        Scanner scan = new Scanner(System.in);

        String email , password, confirmPassword, phone;
        System.out.println("Please enter");
        System.out.print("Email: ");
        email= scan.nextLine();

        while (!loginView.accountManager.isValidEmail(email)){
            System.out.println("Invalid Email");
            System.out.print("Please enter your email: ");
            email= scan.nextLine();
        }
        if (!loginView.accountManager.isUniqueEmail(email)){
            System.out.println("You already have an account !");
            loginView.login();
            return;
        }
        System.out.print("Phone: ");
        phone = scan.nextLine();
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
        String otp = loginView.accountManager.getOtpHandler().sendOTP(email);
        System.out.print("Please enter OTP: ");
        String otpMatch = scan.nextLine();

        while (!Objects.equals(otp, otpMatch)){
            System.out.println("Invalid OTP");
            System.out.print("Please enter OTP: ");
            otpMatch = scan.nextLine();
        }
        int id = loginView.accountManager.addCustomer(new Credentials(email, password), phone);

        loginView.toffeeView.setCustomerId(id);
        loginView.login();

    }

}
