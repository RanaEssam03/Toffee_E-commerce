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
            System.out.println("\nInvalid Email\n");
            System.out.print("Please Enter\nEmail: ");
            email= scan.nextLine();
        }
        if (!loginView.accountManager.isUniqueEmail(email)){
            System.out.println("\nYou already have an account !\n");
            loginView.login();
            return;
        }
        System.out.print("Phone: ");
        phone = scan.nextLine();
        while (!loginView.accountManager.isValidPhone(phone)){
            System.out.println("\nInvalid Phone!!\n");
            System.out.print("Please enter your phone: ");
            phone= scan.nextLine();
        }
        System.out.print("Password: ");
        password = scan.nextLine();

        System.out.print("Confirm Password: ");
        confirmPassword = scan.nextLine();


        while (!Objects.equals(confirmPassword, password)){
            System.out.println("\npasswords do not match!!\n");
            System.out.print("Password: ");
            password = scan.nextLine();
            System.out.print("Confirm Password: ");
            confirmPassword = scan.nextLine();

        }
        System.out.println("\nPlease wait while we send OTP to your email......\n");
        String otp = loginView.accountManager.getOtpHandler().sendOTP(email);
        System.out.println("\nOTP has been sent to your email!\n");
        System.out.print("Please enter OTP: ");
        String otpMatch = scan.nextLine();

        while (!Objects.equals(otp, otpMatch)){
            System.out.println("\nInvalid OTP!!\n");
            System.out.print("Please enter OTP: ");
            otpMatch = scan.nextLine();
        }
        int id = loginView.accountManager.addCustomer(new Credentials(email, password), phone);

        loginView.toffeeView.setCustomerId(id);
        loginView.login();

    }

}
