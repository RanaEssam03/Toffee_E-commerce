package account;

import java.security.SecureRandom;

public class Credentials {
    private static final int otpLength = 6;
    private static final String emailReg = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
    private String[] emails;
    private String[] passwords;
    private int numUsers;

    private String generateOTP(){
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();
        //SecureRandom : a class that provides a safe random num generator.
        //StringBuilder : a class that concatenates strings more efficiently.

        for(int i = 0; i < otpLength; i++){
            otp.append(random.nextInt());
        }
        //a random digit is generated and is then appended to the StringBuilder using
        //'append' which avoids creates lots of objects when constructing the OTP
        return otp.toString();
    }

    public Credentials(int capacity) {
        emails = new String[capacity];
        passwords = new String[capacity];
        numUsers = 0;
    }

    public boolean addUser(String email, String password) {
        // Check if email already exists in the array
        for (int i = 0; i < numUsers; i++) {
            if (emails[i].equals(email)) {
                return false;
            }
        }

        // Add user to the array
        emails[numUsers] = email;
        passwords[numUsers] = password;
        numUsers++;

        return true;
    }

    public boolean checkUser(String e, String p) {
        // Check if email and password match a user in the array
        for (int i = 0; i < numUsers; i++) {
            if (emails[i].equals(e) && passwords[i].equals(p)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidEmail(String email){
        return email.matches(emailReg);
    }

    public void sendOTP(String email){
        String otp = generateOTP();
        /*
        try {

        }
        catch{

        }
        */

        System.out.println("OTP sent to " + email);
    }
}


