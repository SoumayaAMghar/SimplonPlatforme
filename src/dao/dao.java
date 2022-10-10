package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dao {
    private static final String url ="jdbc:postgresql://localhost:5432/mybrief";
    private static String user="postgres";
    private static String password ="Som@med";
    protected static Connection con ;
    public static Connection connect() {

        try {
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }

}
