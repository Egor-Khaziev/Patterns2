package GB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConverterToDB {

    public static String userToDB(User user){
        String result = "insert INTO shop.users (id, name, test) VALUES (" +
                user.getId() + ",'" + user.getName() + "','" + user.getTest() + "')";

        return result;
    }

    public static User DBToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setTest(resultSet.getString("test"));
        return user;

    }

}
