package GB;

import java.io.IOException;
import java.sql.*;
import GB.service.*;

public class Test {

    public static void main(String[] args) throws IOException, SQLException {

        User userToDB = new User(15, "Jonathan Livingston Seagull", "new");
        ServiceGB serviceGB = new ServiceGB();

        serviceGB.addUser(userToDB);
        System.out.println(serviceGB.select(15));
        System.out.println(serviceGB.select(15));
        System.out.println(serviceGB.select(4));
        System.out.println(serviceGB.select(4));
    }


}
