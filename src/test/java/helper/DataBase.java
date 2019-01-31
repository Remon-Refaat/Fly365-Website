package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBase {

    DataBase dbs = new DataBase();

    static String JDBC_DRIVER = "org.postgresql.Driver";
    static String USER = "root";
    static String PASS = "fly12345";
    public static String data;

    public static void execute_query_dbs(String hostName, String dbsName, String query)
    {
        try {
            String url = "jdbc:postgresql://"+hostName+"/"+dbsName;

            // no need to call Class.forName(driver) from JDK 6 onward
             Connection con = DriverManager.getConnection(url,USER,PASS);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             if (rs.next() == false)
             {
                 System.out.println("ResultSet is empty");
             } else
                 {
                     do {
                         data = rs.getString("email");
                     //System.out.println(data);
                     }
                     while (rs.next());
                 }
        } catch (Exception e)
        {
            System.out.println("ResultSet is empty");
        }
    }

}
