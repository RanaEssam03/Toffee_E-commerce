package User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class AccountManager {
    private Credentials credentials;

    public AccountManager(Credentials credentials) {
        this.credentials = credentials;
    }

    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp ;
        int upperbound = 999;
        otp =  random.nextInt(upperbound);
        while (otp < 100){
            otp =  random.nextInt(upperbound);

        }
        return String.valueOf(otp);
    }
    public String sendOTP(String email) throws IOException {
            String otp = generateOTP();
            File file = new File("OTP.txt");
            FileWriter outputFile = new FileWriter(file);
            outputFile.write(otp);
            outputFile.close();
            return otp;
    }




}
