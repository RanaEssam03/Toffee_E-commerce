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
//    private Credentials credentials;

//    public AccountManager(Credentials credentials) {
//        this.credentials = credentials;
//    }

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


    HashMap<String , String> accounts = new HashMap<>();
    static final int otpLength = 6;
    private static final String emailReg = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
    public boolean isUniqueEmail(String email){
        return (accounts.get(email) == null);
    }
    public boolean isValidEmail(String email){
        return Pattern.compile(emailReg).matcher(email).matches();

    }

    public void addUser(Credentials credentials) {
        accounts.put(credentials.getEmail(), credentials.getPassword());
    }

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

    public boolean checkPassword(String email, String password){
        return Objects.equals(accounts.get(email), password);
    }


}
