import TOFFEE_view.RegisterAndLogin;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

//        Credentials c = new Credentials();
//        AccountManager u = new AccountManager(c);
//        u.sendOTP("ranaessam03@gmail.com");

        RegisterAndLogin p = new RegisterAndLogin();
        p.start();

    }
}