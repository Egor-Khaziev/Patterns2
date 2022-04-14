package GB.repository;

import GB.ConverterToDB;
import GB.User;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class RepositoryGB {

    Properties dbPostgreSQLProperties = new Properties();
    Connection connection;

    public RepositoryGB() throws SQLException, IOException {
        start();
    }

    public void start() throws IOException, SQLException {

        dbPostgreSQLProperties.load(RepositoryGB.class.getResourceAsStream("/dbPostgreeSQL.properties"));
        connection = DriverManager.getConnection(dbPostgreSQLProperties.getProperty("url"), dbPostgreSQLProperties);

    }

    public void addUser(User userToDB) throws SQLException {
        Statement statement = connection.createStatement();

        // В БАЗУ
        int i = statement.executeUpdate(ConverterToDB.userToDB(userToDB));
        System.out.println("внесено изменений " + i);
        statement.close();

    }

    public User select(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from shop.users u where u.id = " + id);//

        //ИЗ БАЗЫ
        resultSet.next();
        User user = ConverterToDB.DBToUser(resultSet);
        statement.close();
        return user;


    }
}