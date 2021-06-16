package io.github.olgazskiba;

import java.sql.*;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class DeveloperJdbcDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jis6";

    static final String USER = "olgaz";
    static final String PASSWORD = "g64gh76kod";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); cтарый вариант создания драйвера

//       Statement statement = null;
//        PreparedStatement statement = null;
        CallableStatement statement = null;

        System.out.println("Registering jdbc driver...");

        Class.forName (JDBC_DRIVER); //новый вариант создания драйвера

        System.out.println("creating database connection...");

        String sql;
        sql = "SELECT * FROM developers";

        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        System.out.println("Executing statement...");
//        statement = connection.prepareStatement(sql);

//        statement = connection.createStatement();

        statement = connection.prepareCall(sql);

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n===================\n");
            System.out.println("id: " + id);
            System.out.println("name: " + name);
            System.out.println("specialty: "+ specialty);
            System.out.println("salary: " + salary);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();

    }

}
