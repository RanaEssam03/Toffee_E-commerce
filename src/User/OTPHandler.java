package User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.Properties;

public class OTPHandler {
    /**
     *This method is responsible for generating a random OTP for the user to verify his email
     * @return otp "One Time Password"
     */
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

    /**
     * This method is responsible for sending the OTP to the user's email
     * @param email
     * @return otp "One Time Password" to be used for verification
     */
    public String sendOTP(String email)
    {
        String otp= generateOTP();
        String host = "smtp.gmail.com";
        String username = "toffeteam@gmail.com";
        String password = "jhhtcvpiahbqekap";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            message.setSubject("Toffee Shop Verification Code");
            message.setText("Dear Customer,\n Thanks for joining Toffee Shop Family Your OTP is  " + otp+ ". Use this Passcode to verify your email." );

            Transport.send(message);
            return otp;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
