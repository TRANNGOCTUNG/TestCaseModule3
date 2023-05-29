package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/staff_management?useUnicode=yes&characterEncoding=UTF-8;";
    private static final String jdbcUserName= "root";
    private static final String jdbcPassword= "15122000";

    protected static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
            System.out.println("Successfully connected");
        }catch ( SQLException e){
            e.printStackTrace();
        }
         return connection;
        }
}
