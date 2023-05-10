/**
 * AccountManager class is responsible for managing the accounts of the users
 * @auther Nourhan Abdullah
 * @version 1.0
 * @since 2021-05-09
 */
package User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Pattern;

public class AccountManager {
    /**
     * This String represents the path of the file that contains the accounts of the users
     */
    private static final String emailReg = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";

    /**
     * This HashMap contains the accounts of the users
     * @see Account
     */
    HashMap<String , String> accounts = new HashMap<>();


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
                message.setText("Dear Customer, Thanks for joining Toffee Shop Family Your OTP is  " + otp+ " .Use this Passcode to verify your email" );

            Transport.send(message);
            return otp;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * This method is responsible for checking if the email is unique or not "already exists"
     * @param email
     * @return true if the email is unique and false if it is not
     */
    public boolean isUniqueEmail(String email){
        return (accounts.get(email) == null);
    }

    /**
     * This method is responsible for checking if the email is valid or not
     * @param email
     * @return true if the email is valid and false if it is not
     */
    public boolean isValidEmail(String email){
        return Pattern.compile(emailReg).matcher(email).matches();

    }
    /**
     * This method is responsible for adding a new user to the accounts HashMap
     * @param credentials
     * @see Credentials
     */
    public void addUser(Credentials credentials) {
        accounts.put(credentials.getEmail(), credentials.getPassword());
    }

    /**
     * This method is responsible for loading the data from the file to the accounts HashMap
     * @throws IOException if the file is not found
     */
    public void loadData() throws IOException {
        File file2 = new File("customers.txt");
        try {
            FileReader fileReader = new FileReader(file2);
            Scanner sc = new Scanner(new File(file2.toURI()));
            sc.useDelimiter(",");

            while (sc.hasNext()){
                ArrayList<String> strings = new ArrayList<>();
                int x = 2;
                int y = 0;
                while(x!=0){

                    String s = sc.next();
                    ((ArrayList<String>) strings).add(s);
                    x--;
                }
                accounts.put(strings.get(0), strings.get(1));
            }

        }
        catch (IOException e) {
            FileWriter outputFile = new FileWriter(file2);

            List<String[]> data = new ArrayList<>();
            int x = data.size();
            int j = 0;
                outputFile.write("ranaessam03@gmail.com,");
                outputFile.write("Rana2003,");
                outputFile.write("noorEyad@gmail.com,");
                outputFile.write("Noor2003");
            outputFile.close();
        }

    }

    /**
     * This method is responsible for updating the file after adding a new user
     * @throws IOException if the file is not found
     */

    public void updateFile() throws IOException {
        File file = new File("customers.txt");
        file.delete();

        FileWriter outputFile = new FileWriter("customers.txt");
        int x = 0;


        for (Map.Entry<String, String> set : accounts.entrySet()){

            outputFile.write(set.getKey()+",");
            if(x == accounts.size()-1) {
                outputFile.write(set.getValue());
                break;
            }
            outputFile.write( set.getValue()+",");
            x++;
        }
        outputFile.close();
    }

    /**
     * This method is responsible for checking if the password is correct or not
     * @param email
     * @param password
     * @return true if the password is correct and false if it is not
     */
    public boolean checkPassword(String email, String password){
        return Objects.equals(accounts.get(email), password);
    }


}
