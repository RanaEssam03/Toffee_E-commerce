package User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileHandler {
    AccountManager accountManager ;

    public FileHandler(AccountManager accountManager){
        this.accountManager = accountManager;
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
                accountManager.addCustomer(new Credentials(strings.get(0), strings.get(1)), " ");
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


        for (Map.Entry<String, String> set : accountManager.getAccounts().entrySet()){

            outputFile.write(set.getKey()+",");
            if(x == accountManager.getAccounts().size()-1) {
                outputFile.write(set.getValue());
                break;
            }
            outputFile.write( set.getValue()+",");
            x++;
        }
        outputFile.close();
    }

}
