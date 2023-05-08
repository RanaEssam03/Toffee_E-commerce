package User;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Credentials {

    HashMap<String , String> accounts = new HashMap<>();
    static final int otpLength = 6;
    private static final String emailReg = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
    public boolean isUniqueEmail(String email){
        return (accounts.get(email) == null);
    }
    public boolean isValidEmail(String email){
        return Pattern.compile(emailReg).matcher(email).matches();

    }

    public void addUser(Account account) {
        accounts.put(account.getEmail(), account.getPassword());
    }

    public void loadData(String file) throws IOException {
        File file2 = new File("customers.csv");
        try {
            FileReader fileReader = new FileReader(file2);
            Scanner sc = new Scanner(new File(file2.toURI()));
            sc.useDelimiter(",");
            while (sc.hasNext()){
                ArrayList<String> strings = new ArrayList<>();
                int x = 2;
                int y = 0;
                while(x!=0){

                    String s = sc.nextLine();
                    ((ArrayList<String>) strings).add(s);
                    x--;
                }
//                System.out.println(strings.get(0)+" "+ strings.get(1));
                accounts.put(strings.get(0), strings.get(1));
            }

        }
        catch (IOException e) {
            FileWriter outputFile = new FileWriter(file2);

            CSVWriter writer = new CSVWriter(outputFile);
            List<String[]> data = new ArrayList<String[]>();

            data.add(new String[] {"Rana", "2003" });
            data.add(new String[]{"Noor", "2003" });
            writer.writeAll(data);
            writer.close();

        }

    }

    public void updateFile() throws IOException {
        FileWriter outputFile = new FileWriter("customers.csv");
        ArrayList<String[]> strings = new ArrayList<>();
        for (Map.Entry<String, String> set : accounts.entrySet()){
            strings.add(new String[]{set.getKey()});
            strings.add(new String[]{ set.getValue()});
        }
        CSVWriter writer = new CSVWriter(outputFile);

        writer.writeAll(strings);
        writer.close();
    }

    public boolean checkPassword(String email, String password){
        return Objects.equals(accounts.get(email), password);
    }
}

