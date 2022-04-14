package GB.service;
import GB.User;
import GB.repository.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ServiceGB {

    Map<Integer, User> userMap = new HashMap<>();

    RepositoryGB repositoryGB;

    public ServiceGB() throws SQLException, IOException {
        repositoryGB = new RepositoryGB();
    }

    public void addUser(User userToDB) throws SQLException {
        repositoryGB.addUser(userToDB);
        System.out.println("add to BD and MAP");
        userMap.put(userToDB.getId(), userToDB);
    }

    public User select(int id){
        if(!userMap.containsKey(id)){
            try {
                System.out.println("in BD");
                User user = repositoryGB.select(id);
                userMap.put(user.getId(), user);
                return user;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("in MAP");
        return userMap.get(id);

    }

}
